package com.Inheritence;
import java.io.*;

class Animal implements Serializable {

    int i = 10;
}

class Dog extends Animal {

    int j = 20;
}

public class SerializeDemo1 {

    public static void main(String[] args) throws Exception {

        Dog d1 = new Dog();
        System.out.println(d1.i + " ... " + d1.j);

        //Serialization
        FileOutputStream fos = new FileOutputStream("File4.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d1);

        //DeSerialization
        FileInputStream fis = new FileInputStream("File4.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog d2 = (Dog) ois.readObject();

        System.out.println(d2.i + " ... " + d2.j);

    }
}
