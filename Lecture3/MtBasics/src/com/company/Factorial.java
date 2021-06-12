package com.company;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        int[] arr = {10000,2000,5000,15000,10000,14000,14543,15252};

        long start = System.currentTimeMillis();

        for(int i : arr){
            System.out.println("Factorial of "+ i+" is : "+ calculateFactorial(i) );
        }

        System.out.println("Time consumed : "+ (System.currentTimeMillis()-start));
    }


    public static BigInteger calculateFactorial(int number){

//        BigInteger result = new BigInteger("1");
        BigInteger result = BigInteger.ONE;
        for(int i = 2 ; i <= number ; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
