package com.company;

class Encapsulation {
    private int Age;
    private int B;

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        if(age > 0 ) Age = age;
        else System.out.println("Enter A valid Age");
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }
}

class Solution{

    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();
        obj.setAge(10);
        System.out.println(obj.getAge());
    }
}

