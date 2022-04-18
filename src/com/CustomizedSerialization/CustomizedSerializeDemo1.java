package com.CustomizedSerialization;
import java.io.*;

class Accountt implements Serializable {

    String userName = "Ujjwal";
    transient String password = "Ujjwal@1998";

}

public class CustomizedSerializeDemo1 {

    public static void main(String[] args) throws Exception {

        Accountt a1 = new Accountt();
        System.out.println("UserName: " + a1.userName + " ... " + "Password: " + a1.password);

        //Serialization
        FileOutputStream fos = new FileOutputStream("File1.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a1);

        //DeSerialization
        FileInputStream fis = new FileInputStream("File1.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Accountt a2 = (Accountt) ois.readObject();

        //password will get set to default value null by JVM because of transient keyword
        System.out.println("UserName: " + a2.userName + " ... " + "Password: " + a2.password);


    }
}
