package com.bridgelabz.AddressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
	static final File FILE_PATH = new File(
			"C:\\Users\\ADMIN\\eclipse-workspace\\RFP_AddressBook\\src\\com\\bridgelabz\\Files");
	static Scanner sc = new Scanner(System.in);

	public enum FileType {
		TXT, CSV
	}

	static boolean read(File filePath) throws FileNotFoundException {
		for (File file : filePath.listFiles()) {
			System.out.println("AddressBook name: " + file.getName());
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
		return true;
	}

	static boolean writeTxtFile(ArrayList<Contact> addressBook, String addressBookName) throws IOException {
		System.out.println("Enter file name - ");
		addressBookName = sc.next();
		File file = new File(FILE_PATH + "txt//" + addressBookName + ".txt");
		boolean isCreated = file.createNewFile();
		if (!isCreated) {
			file.delete();
			file.createNewFile();
		}
		System.out.println("file created");
		FileWriter fileWriter = new FileWriter(file);
		String data = "";
		for (Contact contactPerson : addressBook) {
			data = data.concat(contactPerson.toString()).concat("\n");
		}
		System.out.println(data);
		fileWriter.write(data);
		fileWriter.close();
		return true;
	}

	public static boolean writeCsvFile(ArrayList<Contact> addressBook, String addressBookName) throws IOException {
		System.out.println("Enter file name - ");
		addressBookName = sc.next();
		File file = new File(FILE_PATH + "csv//" + addressBookName + ".csv");
		boolean isCreated = file.createNewFile();
		if (!isCreated) {
			file.delete();
			file.createNewFile();
		}
		System.out.println("file created");
		FileWriter fileWriter = new FileWriter(file);
		try (CSVWriter csvWriter = new CSVWriter(fileWriter)) {
			List<String[]> data = new ArrayList<>();
			for (Contact person : addressBook) {
				String[] contactData = new String[] { person.getFirstName(), person.getLastName(), person.getAddress(),
						person.getCity(), person.getState(), String.valueOf(person.getZip()),
						String.valueOf(person.getPhoneNumber()), person.getEmail() };
				data.add(contactData);
			}
			csvWriter.writeAll(data);
		}
		fileWriter.close();
		return true;
	}



	public static void writeJsonFile(ArrayList<Contact> addressBook, String addressBookName) throws IOException {
		File file = new File(FILE_PATH + "json//" + addressBookName + ".json");
		boolean isCreated = file.createNewFile();
		if (!isCreated) {
			file.delete();
			file.createNewFile();
		}
		FileWriter writer = new FileWriter(file);
		JsonObject gson = new JsonObject();
		String data = "";
		for (Contact person : addressBook) {
			data = data.concat(gson.toJson(person) + "\n");
		}
		writer.write(data);
		writer.close();
	}
}