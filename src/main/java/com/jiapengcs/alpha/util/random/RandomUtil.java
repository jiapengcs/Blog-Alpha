package com.jiapengcs.alpha.util.random;

import java.util.Random;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-6
 */
public class RandomUtil {

    public static String getRandomString(int length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRandomString(16));
    }
}
