package com.jiapengcs.alpha.interceptor;

import com.jiapengcs.alpha.util.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@Component
public class CommentInterceptor implements HandlerInterceptor {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommentInterceptor.class);

    @Value("${alpha.comment.interval}")
    private long minInterval;

    @Value("${alpha.comment.times}")
    private int maxTimes;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();

        // no limit for admin
        if (session.getAttribute(Constants.SESSION_ADMIN) != null) {
            return true;
        }

        minInterval = minInterval > 0 ? minInterval : Constants.DEFAULT_COMMENT_INTERVAL;
        maxTimes = maxTimes > 0 ? maxTimes : Constants.DEFAULT_COMMENT_TIMES;
        int times = 0;
        if (session.getAttribute(Constants.COMMENT_TIMES) != null) {
            times = (int) session.getAttribute(Constants.COMMENT_TIMES);
        }
        long lastComment = 0L;
        if (session.getAttribute(Constants.LAST_COMMENT) != null) {
            lastComment = (long) session.getAttribute(Constants.LAST_COMMENT);
        }
        long interval = System.currentTimeMillis() - lastComment;

        if (times < maxTimes && interval >= minInterval) {
            // set comment time and times to session
            session.setAttribute(Constants.LAST_COMMENT, System.currentTimeMillis());
            session.setAttribute(Constants.COMMENT_TIMES, ++times);
            LOGGER.info("Comment operation => times: {}(max: {}), interval: {}ms(min: {}ms)", times, maxTimes, interval, minInterval);
            return true;
        }
        httpServletRequest.getRequestDispatcher("/error/block").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
