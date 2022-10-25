package com.bridgelabz.AddressBook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) throws IOException, SQLException {

		System.out.println("\n***** WELCOME TO ADDRESS BOOK ****** \n");

		AddressBook addressBook = new AddressBook();
		int choice = 0;
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("Enter your choice --->\n");
			System.out.println("1.Add Contact\n" + "2.Edit Contact\n" + "3.Show Contact\n" + "4.Delete Contact\n"
					+ "5.Add New Addres Book\n" + "6.Select Address Book\n" + "7.Check Duplicate Contact\n"
					+ "8.Search Person\n" + "9.Number of Contacts\n" + "10.Sort Contacts\n" + "11.Write Address Book\n" + "12.Read Address Book\n" + "13.Exit\n");

			choice = input.nextInt();

			switch (choice) {
			case 1:
				addressBook.addContact();
				break;
			case 2:
				addressBook.editContact();
				break;
			case 3:
				addressBook.showContacts((ArrayList) addressBook.people);
				System.out.println(addressBook.people);
				break;
			case 4:
				addressBook.deleteContact();
				break;
			case 5:
				addressBook.addNewAddressBook();
				break;
			case 6:
				addressBook.selectAddressBook();
				break;
			case 7:
				addressBook.checkDuplicateContact();
				break;
			case 8:
				addressBook.searchByCityOrState();
				break;
			case 9:
				addressBook.NoOfContactPersons();
				break;
			case 10:
				addressBook.sortContact();
				break;
			case 11:
				addressBook.writeAddressBook();
				break;
			case 12:
				addressBook.readAddressBook();
				break;
			case 13:
				System.out.println("* Successfully Exit *");
				break;
			default:
				System.out.println("Enter Valid Input !!!\n");
			}

		} while (choice != 11);

	}
}