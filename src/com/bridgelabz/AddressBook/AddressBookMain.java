package com.bridgelabz.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Purpose - To ensure that there is no duplicate entry
 */

public class AddressBookMain {
    ArrayList<Contacts> arrayDetails = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, ArrayList<Contacts>> hashmap = new HashMap<>();
    static AddressBookMain details = new AddressBookMain();

    /**
     * This method is used to add details to address book
     */
    public void addDetails() {
        Contacts info = new Contacts();
        System.out.println("Enter the first name");
        info.setFirstName(sc.next());
        System.out.println("Enter the last name");
        info.setLastName(sc.next());
        System.out.println("Enter the address");
        info.setAddress(sc.next());
        System.out.println("Enter the city");
        info.setCity(sc.next());
        System.out.println("Enter the state");
        info.setState(sc.next());
        System.out.println("Enter the email");
        info.setEmail(sc.next());
        System.out.println("Enter the zip code");
        info.setZip(sc.nextInt());
        System.out.println("Enter the phone number");
        info.setPhoneNumber(sc.nextLong());
        arrayDetails.add(info);
    }

    /**
     * This method is used to display the details
     */

    public void displayDetails() {
        System.out.println(arrayDetails);
    }

    /**
     * This method is used to edit the details in address book
     */
    public void editDetails() {
        System.out.println("Confirm your first name to edit details: ");
        String confirmName = sc.nextLine();

        for (int i = 0; i < arrayDetails.size(); i++) {
            if (arrayDetails.get(i).getFirstName().equals(confirmName)) {
                System.out.println("Select form below to change: ");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip\n7.Mobile number\n8.Email");
                int edit = sc.nextInt();

                switch (edit) {
                    case 1:
                        System.out.println("Enter first name");
                        arrayDetails.get(i).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter Last name");
                        arrayDetails.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter Address");
                        arrayDetails.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter City");
                        arrayDetails.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter State");
                        arrayDetails.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter Zip");
                        arrayDetails.get(i).setZip(sc.nextInt());
                        break;
                    case 7:
                        System.out.println("Enter Mobile number");
                        arrayDetails.get(i).setPhoneNumber(sc.nextLong());
                        break;
                    case 8:
                        System.out.println("Enter new E-mail");
                        arrayDetails.get(i).setEmail(sc.next());
                        break;
                }
            } else
                System.out.println("Enter a valid First name");
        }
    }

    /**
     * This method is used to delete the contact details
     */
    public void deleteDetails() {
        System.out.println("Confirm the first name of the person to delete contact");
        String confirmName = sc.next();
        for (int i = 0; i < arrayDetails.size(); i++) {

            if (arrayDetails.get(i).getFirstName().equals(confirmName)) {
                arrayDetails.remove(i);
                System.out.println("List After removing" + arrayDetails);

            } else {
                System.out.println("Enter valid first name");
            }
        }
    }


    /**
     * Method to check for duplicate entry before adding the person.
     */
    public void duplicateCheck(String firstName) {
        for (int k = 0; k < arrayDetails.size(); k++) {
            String contactName = arrayDetails.get(k).getFirstName();

            if (firstName.equals(contactName)) {
                System.out.println("This Person is Already Present");
            } else {
                System.out.println("You can Add this Person");
                break;
            }
        }
    }
    /*
     * Method to create multiple address book and editing it.
     */
    public void createAddressBook() {

        while (true) {
            System.out.println("Choose what you want to do: ");
            System.out.println("1.Create new address book.\n2.Edit existing address book.\n3.Display all address books.\n4.exit");
            int choose = sc.nextInt();

            if (choose == 6) {
                System.out.println("Exited");
                break;
            }

            switch (choose) {
                case 1:
                    System.out.println("Enter the name of address book: ");
                    String address_name = sc.next();

                    // condition to check for uniqueness of address book.
                    if (hashmap.containsKey(address_name)) {
                        System.out.println("Adress book name exits, enter different name");
                        break;
                    }

                    ArrayList<Contacts> new_address_book = new ArrayList<>();
                    arrayDetails = new_address_book;
                    while (true) {
                        System.out.println("Choose what you want to do: ");
                        System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact. \n4.Dipslay all contacts. \n5.Duplicate check.\n6.Exit");
                        int choose1 = sc.nextInt();
                        if (choose1 == 6) {
                            System.out.println("Exited");
                            break;
                        }
                        switch (choose1) {
                            case 1:
                                details.addDetails();
                                break;
                            case 2:
                                details.editDetails();
                                break;
                            case 3:
                                details.deleteDetails();
                                break;
                            case 4:
                                details.displayDetails();
                                break;
                            case 5:
                                System.out.println("Enter first name to check for duplicancy");
                                String enteredName = sc.next();
                                details.duplicateCheck(enteredName);
                                break;

                            default:
                                System.out.println("Choose valid option");
                                break;
                        }
                        hashmap.put(address_name, arrayDetails);
                        System.out.println(hashmap);
                    }
                    break;

                case 2:
                    System.out.println("Enter the name of address book: ");
                    String address_name_old = sc.next();

                    // condition to check whether address book exists or no.
                    if (hashmap.containsKey(address_name_old)) {

                        ArrayList<Contacts> old_address_book = new ArrayList<>();
                        arrayDetails = old_address_book;
                        arrayDetails = hashmap.get(address_name_old);
                        while (true) {
                            System.out.println("Choose what you want to do: ");
                            System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact. \n4.Display contact. \n5.Duplicate check. \n5.Exit");
                            int choose1 = sc.nextInt();
                            if (choose1 == 4) {
                                System.out.println("Exited");
                                break;
                            }
                            switch (choose1) {
                                case 1:
                                    details.addDetails();
                                    break;
                                case 2:
                                    details.editDetails();
                                    break;
                                case 3:
                                    details.deleteDetails();
                                    break;
                                case 4:
                                    details.displayDetails();
                                    break;

                                case 5:
                                    System.out.println("Enter first name to check for duplicancy");
                                    String enteredName = sc.next();
                                    details.duplicateCheck(enteredName);
                                    break;
                                default:
                                    System.out.println("Choose valid option");
                                    break;
                            }
                            hashmap.put(address_name_old, arrayDetails);
                            System.out.println(hashmap);
                        }
                    } else {
                        System.out.println("Enter valid address book name");
                    }
                    break;

                case 3:
                    System.out.println(hashmap);
                    break;

                default:
                    System.out.println("Enter valid option");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program ");
        details.createAddressBook();
    }
}