package com.bridgelabz.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Purpose - To add multiple contacts an Address Book System
 * 
 *
 */
public class AddressBookSystem {
    ArrayList<Contacts> arrayDetails = new ArrayList<Contacts>();
    static Scanner sc = new Scanner(System.in);
     /*
     * This method is used to add details to address book
     */
    public void addDetails() {
        Contacts info = new Contacts();
        System.out.println("Enter the first name");
        info.setFirstName(sc.nextLine());
        System.out.println("Enter the last name");
        info.setLastName(sc.nextLine());
        System.out.println("Enter the address");
        info.setAddress(sc.nextLine());
        System.out.println("Enter the city");
        info.setCity(sc.nextLine());
        System.out.println("Enter the state");
        info.setState(sc.nextLine());
        System.out.println("Enter the email");
        info.setEmail(sc.nextLine());
        System.out.println("Enter the zip code");
        info.setZip(sc.nextInt());
        System.out.println("Enter the phone number");
        info.setPhoneNumber(sc.nextLong());
        arrayDetails.add(info);
        System.out.println(arrayDetails);
    }

    /**
     *This method is used to edit the details in address book
     */

    public void display(){
        System.out.println(arrayDetails);
    }

    public void editDetails() {
        System.out.println("Confirm your first name to edit details: ");
        String confirmName = sc.next();

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
                System.out.println("Edited list is: ");
                System.out.println(arrayDetails);
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
                System.out.println("List After removing"+arrayDetails);

            } else {
                System.out.println("Enter valid first name");
            }
        }
    }

    public static void main(String[] args) {
        AddressBookSystem details = new AddressBookSystem();
        int  input;
        int ans;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to Address Book Program");
            System.out.println("What do you want to do: ");
            System.out.println("1.Add details.\n2.Edit details.\n3.Delete Details.");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    details.addDetails();
                    break;
                case 2:
                    details.editDetails();
                    break;
                case 3:
                    details.deleteDetails();
                    break;
                default:
                    System.out.println("Invalid! option");
                    break;
            }
            System.out.println("Do you want to continue?(0/1)");
            ans=scanner.nextInt();
        }while(ans==1);
    }
}