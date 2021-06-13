package com.company;

import com.company.resources.Bank;

import java.math.BigInteger;
import java.sql.SQLOutput;

public class BankSynchronization {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Bank bank1 = new Bank(1,100);
        Bank bank2 = new Bank(2,200);

        MyThread[] threads = new MyThread[6];

//      Threads for Bank1
        threads[0] = new MyThread(bank1,true,50,true);
        threads[1] = new MyThread(bank1,false,100,false);
        threads[2] = new MyThread(bank1,true,250,true);

//        Threads for Bank2
        threads[3] = new MyThread(bank2,false,150,false);
        threads[4] = new MyThread(bank2,true,350,true);
        threads[5] = new MyThread(bank2,false,50,true);

        for(MyThread thread : threads){
            thread.start();
//            thread.join();
        }

//        for(MyThread thread: threads){
//            thread.join();
//        }

        Thread.sleep(5000);
        System.out.println("Amount in Bank1 " +bank1.getBalance());
        System.out.println("Amount in Bank2 " +bank2.getBalance());

        System.out.println("Time taken for execution : "+ (System.currentTimeMillis()-start));

    }
    public static class MyThread extends Thread{

        private Bank bank;
        private boolean isDeposit;
        private int amount;
        private boolean isSleep;

        public MyThread(Bank bank, boolean isDeposit, int amount, boolean isSleep){
            this.bank = bank;
            this.isDeposit = isDeposit;
            this.amount = amount;
            this.isSleep = isSleep;
        }

        @Override
        public void run() {
            if(isSleep) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(this.isDeposit){
                depositAmount();
            }else{
                debitAmount();
            }
        }

        private void wasteTime(){
            for(int i = 0 ; i < 1000000; i++){

            }
            BigInteger first = new BigInteger("1234567565432123456576876756543423211343565");
            BigInteger second = new BigInteger("3244535646757655434232124253647557645434234253645786657554343233124253646");
            first.multiply(second);
            first.divide(second);
        }

        private void depositAmount(){
            synchronized (bank) {
                wasteTime();
                System.out.println("In deposit Function : amount " + bank.getBalance() + " and in thread : " + currentThread().getName());
                bank.setBalance(bank.getBalance() + amount);
            }
        }

        private void debitAmount() {
            synchronized (bank){
                wasteTime();
                System.out.println("In debit Function : amount " + bank.getBalance() +" and in thread : "+currentThread().getName());
                bank.setBalance(bank.getBalance()-amount);
            }
        }
    }
}
