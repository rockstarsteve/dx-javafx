//package com.dx;
//
//import com.dx.util.OkHttpUtils;
//import okhttp3.Call;
//import org.junit.jupiter.api.Test;
//
///**
// * Description:
// *
// * @author rockstarsteve
// * @version 1.0
// * @copyright Copyright (c) 电信
// * @since 2022/8/25
// */
//public class OkhttpTest {
//
//
//    /**
//     * get请求 不带参数 有返回值
//     */
//    @Test
//    public void doGetNoParameter() {
//        // get请求，方法顺序按照这种方式，切记选择post/get一定要放在倒数第二，同步或者异步倒数第一，才会正确执行
//        String async = OkHttpUtils.builder()
//                .url("http://www.bidu.com")
//                .get()
//                .async();
//        System.out.println("async:" + async);
//    }
//
//    /**
//     * get请求 带参数 有返回值
//     */
//    @Test
//    public void doGet() {
//        // get请求，方法顺序按照这种方式，切记选择post/get一定要放在倒数第二，同步或者异步倒数第一，才会正确执行
//        String async = OkHttpUtils.builder()
//                .url("http://www.bidu.com")
//                .addParam("id", "3")
//                .get()
//                .async();
//        System.out.println("async:" + async);
//
//    }
//
//    /**
//     * post请求 不带参数 表单提交 有返回值
//     */
//    @Test
//    public void doPostNoParameter() {
//        // post请求，方法顺序按照这种方式，切记选择post/get一定要放在倒数第二，同步或者异步倒数第一，才会正确执行
//        String async = OkHttpUtils.builder()
//                .url("http://www.bidu.com")
//                .post(false)//表单提交
//                .async();
//        System.out.println("async:" + async);
//    }
//
//    /**
//     * post请求 带参数 表单提交 有返回值
//     */
//    @Test
//    public void doPost() {
//        // post请求，方法顺序按照这种方式，切记选择post/get一定要放在倒数第二，同步或者异步倒数第一，才会正确执行
//        String async = OkHttpUtils.builder()
//                .url("http://www.bidu.com")
//                .addParam("username", "username")
//                .addParam("password", "password")
//                .post(false)//表单提交
//                .async();
//        System.out.println("async:" + async);
//    }
//
//    /**
//     * post请求 带参数 body提交 带请求头参数token 有返回值
//     */
//    @Test
//    public void doPostByHeader() {
//        // post请求，方法顺序按照这种方式，切记选择post/get一定要放在倒数第二，同步或者异步倒数第一，才会正确执行
//        String async = OkHttpUtils.builder()
//                .url("http://www.bidu.com")
//                .addParam("id", "3")
//                .addHeader("accessToken","123456789")
//                .post(true)//body提交
//                .async();
//        System.out.println("async:" + async);
//    }
//
//    /**
//     * 所有方法使用教程
//     */
//    public static void main(String[] args) {
//        // get请求，方法顺序按照这种方式，切记选择post/get一定要放在倒数第二，同步或者异步倒数第一，才会正确执行
//        //请求地址，http/https都可以
//        OkHttpUtils.builder().url("https://www.bidu.com")
//                // 有参数的话添加参数，可多个
//                .addParam("username", "tom")
//                .addParam("age", "12")
//                // 也可以添加多个
//                .addHeader("Content-Type", "application/json; charset=utf-8")
//                .get()
//                // 可选择是同步请求还是异步请求
//                //.async();
//                .sync();
//
//        // post请求，分为两种，一种是普通表单提交，一种是json提交
//        //请求地址，http/https都可以
//        OkHttpUtils.builder().url("https://www.bidu.com")
//                // 有参数的话添加参数，可多个
//                .addParam("username", "tom")
//                .addParam("age", "12")
//                // 也可以添加多个
//                .addHeader("Content-Type", "application/json; charset=utf-8")
//                // 如果是true的话，会类似于postman中post提交方式的raw，用json的方式提交，不是表单
//                // 如果是false的话传统的表单提交
//                .post(true)
//                .sync();
//
//        // 选择异步有两个方法，一个是带回调接口，一个是直接返回结果
//        OkHttpUtils.builder().url("")
//                .post(false)
//                .async();
//
//        OkHttpUtils.builder().url("").post(false).async(new OkHttpUtils.ICallBack() {
//            @Override
//            public void onSuccessful(Call call, String data) {
//                // 请求成功后的处理
//
//            }
//
//            @Override
//            public void onFailure(Call call, String errorMsg) {
//                // 请求失败后的处理
//            }
//        });
//    }
//
//
//}
