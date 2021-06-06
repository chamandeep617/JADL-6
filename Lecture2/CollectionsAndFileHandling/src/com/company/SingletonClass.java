package com.company;

class Singleton {
    static int count = 0;
    private static Singleton object = null;

    private Singleton(){
        count++;
    }

    public int getCount() {
        return count;
    }

    static Singleton getInstance(){
        if(object == null){
            object = new Singleton();
        }
        return object;
    }
}

class SingletonClass{

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();

        Singleton obj2 = Singleton.getInstance();

        System.out.println(Singleton.count);
        System.out.println(obj1 == obj2);

    }
}
