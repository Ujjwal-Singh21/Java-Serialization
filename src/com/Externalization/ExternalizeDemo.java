package com.Externalization;
import java.io.*;

class Account implements Externalizable {

    String userName;
    int userID;
    int accountNo;

    //Compulsory to have otherwise -> InvalidClassException
    public Account() {
        super();
        System.out.println("Public no-arg Constructor");
    }

    public Account(String userName, int userID, int accountNo) {
        this.userName = userName;
        this.userID = userID;
        this.accountNo = accountNo;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(userName);
        out.writeInt(userID);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        userName = (String) in.readObject();
        userID = in.readInt();

    }
}

public class ExternalizeDemo {

    public static void main(String[] args) throws Exception {

        Account a1 = new Account("Steve", 1234, 4444);

        //Steve 1234 4444
        System.out.println(a1.userName + " ... " + a1.userID + " ... " + a1.accountNo);

        //Serialization
        FileOutputStream fos = new FileOutputStream("File6.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a1);

        //Deserialization
        FileInputStream fis = new FileInputStream("File6.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account a2 = (Account) ois.readObject();


        //Steve 1234 0
        System.out.println(a2.userName + " ... " + a2.userID + " ... " + a2.accountNo);
    }
}
