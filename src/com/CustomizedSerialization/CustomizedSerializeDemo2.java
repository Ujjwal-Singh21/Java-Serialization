package com.CustomizedSerialization;

import java.io.*;

class Account implements Serializable {

    String userName = "Ujjwal";
    transient String password = "Ujjwal@1998";

    //method executed during serialization
    @Serial
    private void writeObject(ObjectOutputStream os) throws Exception {

        os.defaultWriteObject();
        String ePassword = "123" + password; // -> 123Ujjwal@1998
        os.writeObject(ePassword);
    }

    //method executed during deSerialization
    @Serial
    private void readObject(ObjectInputStream is) throws Exception {

        is.defaultReadObject();
        String ePassword = (String) is.readObject();
        password = ePassword.substring(3);
    }

}

public class CustomizedSerializeDemo2 {

    public static void main(String[] args) throws Exception {

        Account a1 = new Account();
        System.out.println("UserName: " + a1.userName + " ... " + "Password: " + a1.password);

        //Serialization
        FileOutputStream fos = new FileOutputStream("File2.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a1);

        //DeSerialization
        FileInputStream fis = new FileInputStream("File2.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account a2 = (Account) ois.readObject();

        System.out.println("UserName: " + a2.userName + " ... " + "Password: " + a2.password);

    }
}
