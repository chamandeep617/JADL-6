package com.company;


class Vehicle{

    public Vehicle(int a){
        System.out.println("VEHICLE");
    }

    public int find(){
        return 10;
    }

}

class Bus extends Vehicle{

    public Bus(){
        super(10);

        System.out.println("BUS");

    }

    public int find(){
        return 20;
    }

}

class volvo extends Bus{

}


public class Main {

    public static void main(String[] args) {
	// write your code here
        Vehicle obj = new Bus();
        System.out.println(obj.find());
    }
}
