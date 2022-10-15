package com.bridgelabz.AddressBook;
import java.util.Scanner;

public class AddressBook 
{
		//variables
		private  String FirstName;
		private String LastName;
		private String State;
		private String City;
		private String Address;
		private long ZipCode;
		private long PhoneNO;
		private String Email;
		//getters abd setters  for  each variable
		
		Scanner userinput = new Scanner(System.in);

		public String getFirstName() {
			return FirstName;
		}
		public void setFirstName(String firstName) {
			FirstName = firstName;
		}
		
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String lastName) {
			LastName = lastName;
		}
		
		public String getState() 
		{
			return State;
		}
		public void setState(String state)
		{
			this.State = state;
		}
		
		
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			this.Address = address;
		}
		public Long getZipCode() {
			return ZipCode;
		}
		public void setZipCode(Long zipCode) {
			ZipCode = zipCode;
		}
		public Long getPhoneNO() {
			return PhoneNO;
		}
		public void setPhoneNO(Long phoneNO) {
			PhoneNO = phoneNO;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email=email;
		}
			
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		
		public void display()
		{
			    System.out.println("Enter a first name: ");
			    setFirstName(userinput.nextLine()); 
			
			    System.out.println("Enter a last name: ");
			    setLastName(userinput.nextLine()); 
			    
			    System.out.println("Enter a state: ");
			    setState(userinput.next());
			    
			    System.out.println("Enter a city: ");
			    setCity(userinput.next());
				  
			    
			    
			    System.out.println("Enter a address: ");
			    setAddress(userinput.next());
			   
			    System.out.println("Enter a zipcode: ");
			    setZipCode(userinput.nextLong());
			    
			    
			    System.out.println("Enter a phoneno: ");
			    setPhoneNO(userinput.nextLong());
			   
			    System.out.println("Enter a email: ");
			    setEmail(userinput.next());
			    
			    
			    
			    System.out.println("name:\t" + this.getFirstName());
			    System.out.println("last name:\t" + this.getLastName());
			    System.out.println("state:\t" + this.getState());
			    System.out.println("zipcode:\t" + this.getZipCode());
			    System.out.println("city:\t" + this.getCity());
			    System.out.println("phone_no:\t" + this.getPhoneNO());
			    System.out.println("email:\t" + this.getEmail());
			    System.out.println("email:\t" + this.getEmail());
						
		
		}
		
		public static void main(String[] args)
		{

			 AddressBook user1 = new  AddressBook();//usecase 1 displainf contact book for user
			 user1.display();
		}
					
	}	