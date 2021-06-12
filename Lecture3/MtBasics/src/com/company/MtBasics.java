package com.company;

import java.sql.SQLOutput;

public class MtBasics {

    public static void main(String[] args){

        MyThread thread = new MyThread(10,20);
        thread.setDaemon(true);
//        thread.run();
        thread.start();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("In the thread with name:"+ Thread.currentThread().getName());

//        check obj1 = new check();
//        check obj2 = new check();
//        System.out.println(obj1.equals(obj2));
    }

//    public static class check{
//
//    }
    public static class MyThread extends Thread{

        private int a;
        private int b;

        public MyThread(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            System.out.println("In the thread with name:"+ currentThread().getName());
            System.out.println(calculation());

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("I'm executed after 5 secs");
        }

        int calculation(){
            return a*b;
        }
    }
}
