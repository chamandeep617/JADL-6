package com.company;

import java.math.BigInteger;

public class FactorialUsingMT {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {10000,2000,5000,15000,10000,14000,14543,15252};

        long start = System.currentTimeMillis();            //11.12

        Mythread[] threads = new Mythread[arr.length];

        for(int i = 0 ; i < threads.length ; i++){
            threads[i] = new Mythread(arr[i]);
            threads[i].start();
//            System.out.println(.getResult());
        }

        for(Mythread mythread : threads){
            mythread.join(); // This term means that you have to wait till the time it got exectuded
        }


        System.out.println("Time consumed : "+ (System.currentTimeMillis()-start));    //11.15
    }

    public static class Mythread extends Thread{

        private int number;
        BigInteger result = BigInteger.ONE;

        public Mythread(int number){
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public BigInteger getResult() {
            return result;
        }

        @Override
        public void run() {
//            System.out.println("Factorial of "+ this.number +" is : "+ calculateFactorial());
            calculateFactorial();
        }

        public BigInteger calculateFactorial(){
//        BigInteger result = new BigInteger("1");
            for(int i = 2 ; i <= number ; i++){
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }
    }




}
