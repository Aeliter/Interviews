//package com.aeliter.zantong;
//
//import com.aeliter.dingdian.Test;
//
///**
// * @description:
// * @author: caibingqiang
// * @date: 2020-07-27 10:25
// * @version: V1.0
// */
//
///**
// * 编译有两处错误
// */
//class Person {
//
//    public Person() {
//        System.out.println("this is a Person");
//    }
//
//}
//
//public class Teacher extends Person {
//
//    private String name = "tom";
//
//    public Teacher() {
//        System.out.println("this is a teacher");
//        // Call to 'super()' must be first statement in constructor body
//        super();
//    }
//
//    public static void main(String[] args) {
//        Teacher teacher = new Teacher();
//        // 'com.aeliter.zantong.Teacher.this' cannot be referenced from a static context
//        System.out.println(this.name);
//    }
//
//}
