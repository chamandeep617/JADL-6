package com.company;

class Student{

    static int age = 10;

    public int getAge(){
        return age;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Geeks");
        Student obj = new Student();
        System.out.println(obj.age);

    }

    static {
        System.out.println("Hey");
    }
    static {
        System.out.println("JADL-6");
    }


//class CollegeStudent implements Student{
//
//    @Override
//    public int getAge() {
//        return age;
//    }
//
//}
}
