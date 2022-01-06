package nus.iss.workshop12.model;

import java.io.Serializable;

public class Generate implements Serializable {
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
