package com.hexiaofei.nacoscustomer.service;

/**
 * @author lcyj
 * @date 2022-03-19 09:49
 * @since
 */
public class Main {

    public static void main(String[] args) {
        f1();
    }

    private static String f1(){
        try{
            int i = 1/0;
            return aaa();
        }catch (Exception e){
            e.printStackTrace();
            return eee();
        }finally {
            System.out.println("finally");
//            return ddd();
        }

    }

    private static String eee() {
        System.out.println("eee");
        return "eee";
    }

    private static String aaa(){
        System.out.println("aaa");
        return "aaa";
    }

    private static String ddd(){
        System.out.println("ddd");
        return "ddd";
    }
}
