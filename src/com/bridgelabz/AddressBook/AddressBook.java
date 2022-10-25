package com.bridgelabz.AddressBook;

import java.sql.SQLException;
import java.time.LocalDate;
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
    private static void reteriveData() {
    	AddressBookJDBC addressBookRepo = new AddressBookJDBC();
        System.out.println("Enter the Date of Joining (YYYY-MM-DD");
        System.out.println("Enter year , month and Day ex: 2020 02 03");
        List<Contacts> employeeInfoList = addressBookRepo.particularDate(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        for (Contacts employee : employeeInfoList
        ) {
            System.out.println(employee + "\n");
        }
    }
    
    private static void retrieveCityOrState() {
    	AddressBookJDBC add = new AddressBookJDBC();
        System.out.println("Enter 1 -> Contacts count by City\n" +
                "2 -> Contacts count by State");

        switch (sc.nextInt()) {
            case 1:
                System.out.println("Enter city Name");
                int cityContactsCount = add.countByCity(sc.next());
                System.out.println("Number of Contacts is Given city= " + cityContactsCount);
                break;
            case 2:
                System.out.println("Enter state name");
                int stateContactsCount=  add.countByState(sc.next());
                System.out.println("Number of Contacts is Given state= " + stateContactsCount);
                break;
        }
}
    private static void addNewContact() throws SQLException {
        Contacts add = new Contacts();
        System.out.println("Enter First Name:");
        add.setFirstName(sc.next());
        System.out.println("Enter Last name:");
        add.setLastName(sc.next());
        System.out.println("Enter address");
        add.setAddress(sc.next());
        System.out.println("Enter city");
        add.setCity(sc.next());
        System.out.println("Enter state");
        add.setState(sc.next());
        System.out.println("Enter Zip");
        add.setZip(sc.nextInt());
        System.out.println("Enter PhoneNumber");
        add.setPhoneNumber(sc.next());
        System.out.println("Enter Email");
        add.setEmailId(sc.next());
        System.out.println("Enter Addressbook name");
        add.setBookName(sc.next());
        System.out.println("Enter contact type");
        add.setContactType(sc.next());
        add.setDateAdded(LocalDate.now());
        AddressBookJDBC.insertData(add);

    }
}