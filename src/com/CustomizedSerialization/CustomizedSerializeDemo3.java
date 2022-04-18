package com.CustomizedSerialization;
import java.io.*;

class Account1 implements Serializable {

    String userName = "Ujjwal";
    transient String password = "Ujjwal@1998";
    transient int pin = 1234;

    @Serial
    private void writeObject(ObjectOutputStream os) throws Exception {

        os.defaultWriteObject();

        String ePassword = "123" + password;
        os.writeObject(ePassword);

        int ePin = 4444 + pin;
        os.writeInt(ePin);
    }

    @Serial
    private void readObject(ObjectInputStream is) throws Exception {

        is.defaultReadObject();

        String ePassword = (String) is.readObject();
        password = ePassword.substring(3);

        int ePin = is.readInt();
        pin = ePin - 4444;
    }

}

public class CustomizedSerializeDemo3 {

    public static void main(String[] args) throws Exception {

        Account1 a1 = new Account1();
        System.out.println("UserName: " + a1.userName + " ... " + "Password: " + a1.password
                + " ... " + "Pin: " + a1.pin);

        //Serialization
        FileOutputStream fos = new FileOutputStream("File3.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a1);

        //DeSerialization
        FileInputStream fis = new FileInputStream("File3.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account1 a2 = (Account1) ois.readObject();

        System.out.println("UserName: " + a2.userName + " ... " + "Password: " + a2.password
                + " ... " + "Pin: " + a2.pin);

    }
}
