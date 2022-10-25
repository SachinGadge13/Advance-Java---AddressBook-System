package com.bridgelabz.AddressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
	Contact person = new Contact();
	public List<Contact> people = new ArrayList<Contact>();
	static HashMap<String, ArrayList<Contact>> addressBookList = new HashMap<>();
	static String currentAddressBookName;
	static HashMap<String, ArrayList<Contact>> cityContactList = new HashMap<>();
	static HashMap<String, ArrayList<Contact>> stateContactList = new HashMap<>();
	Scanner sc = new Scanner(System.in);

	public void addContact() {

		System.out.println("First Name :");
		person.firstName = sc.next();

		System.out.println("Last Name :");
		person.lastName = sc.next();

		System.out.println("Address :");
		person.address = sc.nextLine();
		sc.next();
		System.out.println("City :");
		person.city = sc.next();

		System.out.println("State :");
		person.state = sc.next();

		System.out.println("Zip :");
		person.zip = sc.nextInt();

		System.out.println("Phone Number :");
		person.phoneNumber = sc.nextLong();

		System.out.println("Email :");
		person.email = sc.next();

		people.add(person);
	}

	public void editContact() {

		System.out.println("Enter the person whose contact to be edited :");
		System.out.println("Enter First Name:");
		String fname = sc.nextLine();
		System.out.println("Enter Last Name:");
		String lname = sc.nextLine();

		int flag = 0;
		for (int j = 0; j < people.size(); j++) {
			Contact person = people.get(j);
			if (person.firstName.equals(fname) && person.lastName.equals(lname)) {
				flag = 1;
				System.out.println("First Name : " + person.firstName);
				System.out.println("Last Name  : " + person.lastName);
				System.out.println("Address    : " + person.address);
				System.out.println("City       : " + person.city);
				System.out.println("State      : " + person.state);
				System.out.println("Zip        : " + person.zip);
				System.out.println("Phone Number:" + person.phoneNumber);
				System.out.println("Email      : " + person.email);
				System.out.println("---------------------------------------");
				System.out.println(
						"Enter the number which you want to edit\n1.First Name\n2.Last Name\n3.Address\n4.C\n5.State\n6.Zip\n7.Phone Number\n8.Email");
				int choose = sc.nextInt();
				switch (choose) {
				case 1:
					System.out.println("first name:");
					person.firstName = sc.nextLine();
					System.out.println("edited succesfully");
					break;
				case 2:
					System.out.println("last name:");
					person.lastName = sc.nextLine();
					System.out.println("edited succesfully");
					break;
				case 3:
					System.out.println("address:");
					person.address = sc.nextLine();
					System.out.println("edited succesfully");
					break;

				case 4:
					System.out.println("city:");
					person.city = sc.nextLine();
					System.out.println("edited succesfully");
					break;
				case 5:
					System.out.println("state:");
					person.state = sc.nextLine();
					System.out.println("edited succesfully");
					break;
				case 6:
					System.out.println("zip:");
					person.zip = sc.nextInt();
					System.out.println("edited succesfully");
					break;
				case 7:
					System.out.println("phone_number:");
					person.phoneNumber = sc.nextLong();
					System.out.println("edited succesfully");
					break;
				case 8:
					System.out.println("email:");
					person.email = sc.nextLine();
					System.out.println("edited succesfully");
					break;
				}
			}
		}
		if (flag == 0)
			System.out.println("Contact not found!!!");
	}

	public void deleteContact() {

		System.out.println("Enter the person whose contact to be deleted :");
		System.out.println("Enter First Name:");
		String fname = sc.next();
		System.out.println("Enter Last Name:");
		String lname = sc.next();

		for (int j = 0; j < people.size(); j++) {
			Contact person = people.get(j);
			if (person.firstName.equals(fname) && person.lastName.equals(lname)) {
				people.remove(person);
				System.out.println("person removed sucessfully");
			} else {
				System.out.println("contact not matched");
			}
		}

	}

	public void addNewAddressBook() {
		System.out.println("Enter name for AddressBook");
		String AddressBookName = sc.next();
		ArrayList<Contact> AddressBook = new ArrayList();
		addressBookList.put(AddressBookName, AddressBook);
		System.out.println("new AddressBook created");
		people = addressBookList.get(AddressBookName);
		currentAddressBookName = AddressBookName;
	}

	void selectAddressBook() {
		System.out.println(addressBookList.keySet());
		System.out.println("enter name of address book");
		String addressBookName = sc.next();

		for (String key : addressBookList.keySet()) {
			if (key.equalsIgnoreCase(addressBookName)) {
				people = addressBookList.get(key);
				currentAddressBookName = key;
			}
		}
		System.out.println("current AddressBook is " + currentAddressBookName);

	}

	public void checkDuplicateContact() {
		System.out.println("Enter First Name");
		String fname = sc.nextLine();
		System.out.println("Enter Last Name");
		String lname = sc.nextLine();
		for (int j = 0; j < people.size(); j++) {
			Contact temp = people.get(j);
			if (temp.firstName.equals(fname) && temp.lastName.equals(lname)) {
				System.out.println("Contact already exists!!Please enter a different contact name");

			}
		}

	}

	public void searchByCityOrState() {
		System.out.println("please enter state or city :");
		String selection = sc.nextLine();
		for (int j = 0; j < people.size(); j++) {
			Contact person = people.get(j);
			if (person.city.equals(selection) || person.state.equals(selection)) {
				System.out.println("person details are");
				System.out.println("First Name : " + person.firstName);
				System.out.println("Last Name  : " + person.lastName);
				System.out.println("Address    : " + person.address);
				System.out.println("City       : " + person.city);
				System.out.println("State      : " + person.state);
				System.out.println("Zip        : " + person.zip);
				System.out.println("Phone Number:" + person.phoneNumber);
				System.out.println("Email      : " + person.email);
			} else {
				System.out.println("No contact Found");
			}

		}

	}

	public void NoOfContactPersons() {
		System.out.println("please enter state or city :");
		String selection = sc.nextLine();
		int count = 0;
		for (int j = 0; j < people.size(); j++) {
			Contact person = people.get(j);
			if (person.city.equals(selection) || person.state.equals(selection)) {
				count++;
			} else {
				System.out.println("No contact Found");
			}

		}
		System.out.println("List of persons in a AdressBook are :" + count);
	}

	void sortContact() {
		List<Contact> allContacts = getAllContacts();
		List<Contact> sortedContacts;

		System.out.println("1.Sort By Name \n2.Sort By CIty \n3.Sort By State \n4.Sort By Zipcode \n5.back");
		switch (sc.nextInt()) {
		case 1:
			sortedContacts = allContacts.stream().sorted((x, y) -> x.getFirstName().compareTo(y.getFirstName()))
					.collect(Collectors.toList());
			sortedContacts.forEach(x -> System.out.println(x));
			break;
		case 2:
			sortedContacts = allContacts.stream().sorted((x, y) -> x.getCity().compareTo(y.getCity()))
					.collect(Collectors.toList());
			sortedContacts.forEach(x -> System.out.println(x));
			break;
		case 3:
			sortedContacts = allContacts.stream().sorted((x, y) -> x.getState().compareTo(y.getState()))
					.collect(Collectors.toList());
			sortedContacts.forEach(x -> System.out.println(x));
			break;
		case 4:
			sortedContacts = allContacts.stream().sorted((x, y) -> Integer.compare(x.getZip(), y.getZip()))
					.collect(Collectors.toList());
			sortedContacts.forEach(x -> System.out.println(x));
			break;
		case 5:
			break;
		default:
			sortContact();
			break;
		}
	}

	List<Contact> getAllContacts() {
		List<Contact> allContacts = new ArrayList<>();
		for (String key : addressBookList.keySet()) {
			allContacts.addAll(addressBookList.get(key));
		}
		return allContacts;
	}

	void showContacts(ArrayList addressBook) {
		System.out.println("Contacts: ");
		for (Object p : addressBook) {
			Contact person = (Contact) p;
			System.out.println(person);
		}
	}

	void readAddressBook() throws FileNotFoundException, SQLException {
		System.out.println("Select option" + "1.read from txt" + "2.read from csv" + "3.back");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                FileIO.read(new File(FileIO.FILE_PATH + ("txt//")));
                break;
            case 2:
                FileIO.read(new File(FileIO.FILE_PATH + ("csv//")));
                break;
            case 3:
                break;
            default:
                readAddressBook();
		}
	}

	void writeAddressBook() throws IOException {
		System.out.println("Select option" + "1.Write from txt" + "2.Write from csv" + "3.back");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			for (String key : addressBookList.keySet()) {
				FileIO.writeTxtFile(addressBookList.get(key), key);
			}
			break;
		 case 2:
             for (String key : addressBookList.keySet()) {
                 FileIO.writeCsvFile(addressBookList.get(key), key);
             }
             break;
         case 3:
             break;
         default:
             writeAddressBook();
             break;


		}
	}
}