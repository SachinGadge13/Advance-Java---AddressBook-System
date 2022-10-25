package com.bridgelabz.AddressBook;

import java.util.List;
import java.util.Scanner;

public class AddressBook {
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {
            System.out.println(" Press\n 1:- Retrieve \n 2:- Exit");
            switch (sc.nextInt()) {
                case 1:
                    retrieveData();
                    break;
                case 2:
                    exit = true;
            }
        }
    }

    private static void retrieveData() {
    	AddressBookJDBC addressBookRepo = new AddressBookJDBC();
        List<Contacts> employeeInfoList = addressBookRepo.retrieveData();
        for (Contacts employee : employeeInfoList
        ) {
            System.out.println(employee + "\n");
        }
    }
    private static void cityUpdate() {
    	AddressBookJDBC addressBookRepo = new AddressBookJDBC();
        System.out.println("Enter the address,city,state, zip and Serial Number  to Update");
        addressBookRepo.updateCityByZip(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
    }
}