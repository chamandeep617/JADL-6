package com.company;

public class runnable {

    public static void main(String[] args) {

        myThread obj = new myThread();
        Thread thread = new Thread(obj);
        thread.start();

    }

    public static class AdvanceFunc{
//        make as per your use case
    }

    public static class myThread extends AdvanceFunc implements Runnable{

        private int a;
        private int b;

        public myThread(){}

        public myThread(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            System.out.println("In the thread with name:"+ Thread.currentThread().getName());
            System.out.println(calculation());

            try {
                Thread.sleep(5000);
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
