package com.Introduction;
import java.io.*;

//Serializing & DeSerializing multiple Objects -> where order is very important.
class Dog1 implements Serializable {
    String name = "dog";
}

class Cat implements Serializable {
    String name = "cat";
}

class Rat implements Serializable {
    String name = "rat";
}

public class SerializationDemo2 {

    public static void main(String[] args) throws Exception {

        Dog1 d1 = new Dog1();
        Cat c1 = new Cat();
        Rat r1 = new Rat();

        //Serialization
        FileOutputStream fileOutputStream = new FileOutputStream("abc2.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(d1);
        objectOutputStream.writeObject(c1);
        objectOutputStream.writeObject(r1);

        //DeSerialization
        FileInputStream fileInputStream = new FileInputStream("abc2.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Dog1 d2 = (Dog1) objectInputStream.readObject();
        Cat c2 = (Cat) objectInputStream.readObject();
        Rat r2 = (Rat) objectInputStream.readObject();

        System.out.println(d2.name + "..." + c2.name + "..." + r2.name);

    }
}
