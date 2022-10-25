package com.bridgelabz.AddressBook;
import java.util.*;

public class Contact {
    Scanner sc = new Scanner(System.in);
    String first, last, address, city, state, zip, phno, email,DOJ;
    int id;
    public boolean equals(Contact o) {
        if (o.first.equalsIgnoreCase(this.first) && o.last.equalsIgnoreCase(this.last)) {
            return true;
        } else {
            return false;
        }
    }

}