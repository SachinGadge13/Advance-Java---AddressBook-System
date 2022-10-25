package com.bridgelabz.AddressBook;

import java.util.*;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook book = new AddressBook();
        Map<String, AddressBook> map = new HashMap<>();
        Map<String, AddressBookMain> addressBookMap = new HashMap<>();

        while (true) {
            System.out.println("Welcome to Address Book System");
            System.out.println("Enter your choice \n1. New Address Book \n2. Select Address Book \n3. Delete Address Book \n4. Search Contact Data \n5. view Contact details \n6.count contacts \n7.Write Data \n8.Read Data \n9.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name of new Address Book: ");
                    String bookName = sc.next();
                    map.put(bookName, new AddressBook());// adding bookName as a key and value is allocating
                    AddressBook.addressBookOptions(map.get(bookName));
                    break;
                case 2:
                    System.out.println("Available Address Books are : ");
                    Set<String> keys = map.keySet();
                    Iterator<String> i = keys.iterator();
                    while (i.hasNext()) {
                        System.out.println(i.next());
                    }
                    System.out.println("Enter Address Book name you want to Open : ");
                    String name = sc.nextLine();
                    System.out.println("Current Address Book is : " + name);
                    AddressBook.addressBookOptions(map.get(name));// call method with passing address book name
                    break;
                case 3:
                    System.out.println("Enter Address Book name to be delete: ");
                    name = sc.nextLine();
                    map.remove(name);// delete hashmap using remove function
                    break;
                case 4:
                    book.searchByOptions();
                case 5:
                    AddressBook.viewByOption(map);
                    break;
                case 6:
                    AddressBook.countByOption();
                    break;
                case 7 : FileIO fileIO = new FileIO();
                    fileIO.writeData(addressBookMap);
                    break;
                case 8 : FileIO fileIORead = new FileIO();
                    System.out.println(fileIORead.readData());
                    break;
                case 9:
                    sc.close();
                    return;

                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }
}