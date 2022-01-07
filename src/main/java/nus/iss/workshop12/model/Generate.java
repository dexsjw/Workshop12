package nus.iss.workshop12.model;

import java.io.Serializable;

public class Generate implements Serializable {             // serialization is crucial
    private int numberVal;

    // setter
    public void setNumberVal(int numberVal) {
        this.numberVal = numberVal;
    }

    // getter
    public int getNumberVal() {
        return this.numberVal;
    }
}

/* 
Serialize: saving of a file (writing)
Deserialize: opening of a file (reading)
It is compulsory to serialize a Class if it is going to be moving around the network
*/