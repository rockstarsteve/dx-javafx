package com.dx.test;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/22
 */
public class Temp {

    public static void main(String[] args) {

        String property1 = System.getProperty("java.awt.headless");
        System.out.println("开始property1:" + property1);

        System.setProperty("java.awt.headless", "false");

        String property = System.getProperty("java.awt.headless");
        System.out.println(property);
        System.out.println("设置后property:" + property);

    }

}
