package com.Inheritence;
import java.io.*;

class Animal1 {

    int i = 10;

    Animal1() {
        System.out.println("Animal Constructor Called");
    }
}

class Dog1 extends Animal1 implements Serializable {

    int j = 20;

    Dog1() {
        System.out.println("Dog Constructor Called");
    }
}

public class SerializeDemo2 {

    public static void main(String[] args) throws Exception {

        Dog1 d1 = new Dog1();
        d1.i = 888;
        d1.j = 999;
        System.out.println(d1.i + " ... " + d1.j); // 888 ... 999

        //Serialization
        FileOutputStream fos = new FileOutputStream("File5.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d1);

        //DeSerialization
        System.out.println("Deserialization Started....");
        FileInputStream fis = new FileInputStream("File5.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog1 d2 = (Dog1) ois.readObject();

        System.out.println(d2.i + " ... " + d2.j); /// 10 ... 999

    }
}
