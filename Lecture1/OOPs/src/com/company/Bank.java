package com.company;

abstract class Bank {

    public int interest() {
        return 0;
    }

    public abstract int LoanInterest();
}

class PNB extends Bank{

    @Override
    public int interest() {
        return 0;
    }

    @Override
    public int LoanInterest() {
        return 0;
    }
}
