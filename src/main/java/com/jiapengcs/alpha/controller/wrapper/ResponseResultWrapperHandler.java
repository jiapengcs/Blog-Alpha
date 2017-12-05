package com.jiapengcs.alpha.controller.wrapper;

import com.alibaba.fastjson.JSON;
import com.jiapengcs.alpha.util.constant.ResponseCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
@ControllerAdvice
public class ResponseResultWrapperHandler implements ResponseBodyAdvice<Object> {

    /**
     * supports when @ResponseResultWrapper annotation present on class or method
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        boolean annotationOnClass = methodParameter.getDeclaringClass().isAnnotationPresent(ResponseResultWrapper.class);
        boolean annotationOnMethod = methodParameter.getMethod().isAnnotationPresent(ResponseResultWrapper.class);
        return  annotationOnClass || annotationOnMethod;
    }

    /**
     * Wrap the return body, add some extra information such as status and message.
     *
     * If the type of the return object o is String, o will be converted by StringMessageConverter by default,
     * instead of MappingJackson2HttpMessageConverter. So exception throws when casting ResponseResult to String.
     *
     * Here are two solutions:
     * 1.cast the ResponseResult to JSONString, so that ClassCastException won't happen;
     * 2.override the converters in the WebConfig.
     * for example:
     *   @Override
     *   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
     *      super.configureMessageConverters(converters);
     *      converters.add(0, new MappingJackson2HttpMessageConverter());
     *   }
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (!(o instanceof ResponseResult)) {
            ResponseResult result = new ResponseResult(ResponseCode.SUCCESS.getStatus(), ResponseCode.SUCCESS.getMessage(), serverHttpRequest.getURI().getPath(), o);
            if (o instanceof String) {
                return JSON.toJSONString(result);
            }
            return result;
        }
        return o;
    }
}
