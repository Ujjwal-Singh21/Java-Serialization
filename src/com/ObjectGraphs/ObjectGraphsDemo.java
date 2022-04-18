package com.ObjectGraphs;
import java.io.*;

class Dog implements Serializable {
    Cat c = new Cat();
}

class Cat implements Serializable {
    Rat r = new Rat();
}

class Rat implements Serializable {
    int j = 20;
}

public class ObjectGraphsDemo {

    public static void main(String[] args) throws Exception {

        Dog d1 = new Dog();

        //Serialization
        FileOutputStream fileOutputStream = new FileOutputStream("abc1.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(d1);

        //DeSerialization
        FileInputStream fileInputStream = new FileInputStream("abc1.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Dog d2 = (Dog) objectInputStream.readObject();

        System.out.println(d2.c.r.j); //20


    }
}
