//package com.aeliter.meituan;
//
//import java.util.Scanner;
//import java.util.Stack;
//
///**
// * 给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，现在要对这个表达式
// * 进行布尔求值，计算结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）。表达式求值是注意
// * and 的优先级比 or 要高，比如：true or false and false，等价于 true or (false and false)，计算结果是 true。
// */
//public class Main1 {
//    public static String judgeString(String a) {
//        String result = new String();
//        if (a == null) {
//            return "error";
//        }
//        String[] s = a.split(" ");
//        Stack<String> stack = new Stack<String>();
//        if (isLogical(s)) {
//            if (s.length == 1) {
//                result = s[0];
//            } else {
//                for (int i = 0; i < s.length; i++) {
//                    if (!s[i].equals("and")) {
//                        stack.push(s[i]);
//                    } else {
//                        String temp1 = stack.pop(); //System.out.println(temp1 + "1");  String temp2 = s[i + 1]; //System.out.println(temp2 + "2");  if (temp2.equals("true") && temp1.equals("true")) {
//                        stack.push("true");
//                    } else {
//                        stack.push("false");
//                    }
//                    i = i + 1;
//                }
//            }
//            String temp3 = new String();
//            String temp = stack.pop();
//            if (stack.size() == 1) {
//                result = temp;
//            } else {
//                for (int i = 0; i < stack.size(); i++) { //temp = stack.pop();  temp3 = stack.pop(); //System.out.println(temp3 + "3");  if (temp3.equals("or")) {
//                    String temp4 = stack.pop(); //System.out.println(temp4 + "4");  if (temp.equals("false") && temp4.equals("false")) {
//                    temp = "false";
//                } else{
//                    temp = "true";
//                }
//            }
//        }
//        result = temp;
//    }
//}
//        }else{
//                result="error";
//                }return result;
//                }
//    public static boolean isLogical(String[]s) {
//        int a1 = 0;
//        int a2 = 0;
//        int a3 = 0;
//        int a4 = 0;
//        boolean b = true;
//        if(s.length%2==0) {
//            b = false;
//        }
//        for(int i = 0; i < s.length; i++) {
//            if(s[i].equals("true")) {
//                a1++;
//            }
//            if(s[i].equals("false")) {
//                a2++;
//            }
//            if(s[i].equals("or")) {
//                a3++;
//            }
//            if(s[i].equals("and")) {
//                a4++;
//            }
//        }
//        if(a1 + a2 + a3 + a4 != s.length) {
//            b = false;
//        }
//        for(int i = 0; i < s.length - 1; i++) {
//            if(s[i].equals(s[i + 1])) {
//                b = false;
//                break;
//            }
//        }
//        if(s[s.length - 1].equals("or") || s[s.length - 1].equals("and")) {
//            b = false;
//        }
//        if(s[0].equals("or") || s[0].equals("and")) {
//            b = false;
//        }
//        return b;
//    }
//    public static void main(String args[]) {
//        Scanner scanner=new Scanner(System.in);
//        String a=scanner.nextLine();
//        String b=judgeString(a);
//        System.out.println(b);
//
//    }
//}
