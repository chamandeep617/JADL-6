package com.company;

class Children{

    static int age = 10;

    public static int getAge(){
        age = age * 2;
        return age;
    }

}

public class StaticVariable {

    public static void main(String[] args) {

//        Children.BadGuys ob1 = new Children.BadGuys();
//        Children ob2 = new Children();

        Children ob1 = new Children();
        Children ob2 = new Children();
        final double pi;
        pi = 3.14;

        System.out.println(ob1 == ob2);

        Children.age = 20;

        System.out.println(Children.getAge());
        System.out.println(Children.getAge());

        int max = Math.max(10,20);

        String str = "Singh";
        str += "chaman";
    }
}
