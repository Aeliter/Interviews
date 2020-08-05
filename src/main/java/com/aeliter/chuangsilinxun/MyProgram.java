package com.aeliter.chuangsilinxun;

/**
 * @description:
 * @author: caibingqiang
 * @date: 2020-07-27 18:37
 * @version: V1.0
 */
public class MyProgram {

    public static void main(String[] args){
        int a = 6;
        int[] b = new int[9];
        int result;
        try {
            b[10] = a;
            result = b[10];
            System.out.println("result = " + result + " ");
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Index out of bound exception: ");
        }
        System.out.println("Statements after exception");
    }

    /*class MyProgram {
        static void Main(string[] args){
            int a = 6;
            int[] b = new int[9];
            int result;
            try {
                b[10] = a;
                result = b[10];
                Console.Write("result = " + result + " ");
            } catch (IndexOutOfRangeException e){
                Console.Write("Index out of bound exception : ");
            }
            Console.Write("Statements after exception");
        }
    }*/


}
