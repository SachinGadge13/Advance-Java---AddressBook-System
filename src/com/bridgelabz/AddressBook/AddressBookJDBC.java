package com.bridgelabz.AddressBook;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookJDBC {
	 Connection connection;

	    private Connection getConnection() {
	        String URL_JD = "jdbc:mysql://localhost:3306/addressbookservice";
	        String USER_NAME = "root";
	        String PASSWORD = "Sanjana555@mhatre";
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Drivers loaded!!");
	            connection = DriverManager.getConnection(URL_JD,USER_NAME,PASSWORD);
	            System.out.println("connection Established!!");
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }


	    public List<Contacts> retrieveData() {
	        ResultSet resultSet = null;
	        List<Contacts> addressBookList = new ArrayList<Contacts>();
	        try (Connection connection = getConnection()) {
	            Statement statement = (Statement) connection.createStatement();
	            String sql = "select * from AddressBook";
	            resultSet = ((java.sql.Statement) statement).executeQuery(sql);
	            int count = 0;
	            while (resultSet.next()) {
	                Contacts contactInfo = new Contacts();
	                contactInfo.setFirstName(resultSet.getString("firstName"));
	                contactInfo.setLastName(resultSet.getString("Lastname"));
	                contactInfo.setAddress(resultSet.getString("address"));
	                contactInfo.setCity(resultSet.getString("city"));
	                contactInfo.setState(resultSet.getString("state"));
	                contactInfo.setZip(resultSet.getInt("zip"));
	                contactInfo.setPhoneNumber(resultSet.getString("phoneNumber"));
	                contactInfo.setEmailId(resultSet.getString("email"));
	                contactInfo.setBookName(resultSet.getString("bookName"));
	                contactInfo.setContactType(resultSet.getString("contactType"));
	                contactInfo.setDateAdded(resultSet.getDate("Date_added").toLocalDate());

	                addressBookList.add(contactInfo);
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return addressBookList;

	    }
	    public void updateCityByZip(String address, String city, String state, int zip, int srNo) {
	        try (Connection connection = getConnection()) {
	            Statement statement = (Statement) connection.createStatement();
	            String query = "Update addressBook set address=" + "'" + address + "'" + ", " + "city=" + "'" + city + "'" + ", " + "state=" + "'" + state + "'" + ", " + "zip=" + zip + " where srNo=" + srNo + ";";
	            int result = ((java.sql.Statement) statement).executeUpdate(query);
	            System.out.println(result);
	            if (result > 0) {
	                System.out.println("Address Updated Successfully");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public List<Contacts> particularDate(LocalDate date) {
	        ResultSet resultSet = null;
	        List<Contacts> addressBookList = new ArrayList<Contacts>();
	        try (Connection connection = getConnection()) {
	            Statement statement = (Statement) connection.createStatement();
	            String sql = "select * from AddressBook where date_added between cast(' "+ date + "'" +" as date)  and date(now());";
	            resultSet = ((java.sql.Statement) statement).executeQuery(sql);
	            int count = 0;
	            while (resultSet.next()) {
	                Contacts contactInfo = new Contacts();
	                contactInfo.setFirstName(resultSet.getString("firstName"));
	                contactInfo.setLastName(resultSet.getString("Lastname"));
	                contactInfo.setAddress(resultSet.getString("address"));
	                contactInfo.setCity(resultSet.getString("city"));
	                contactInfo.setState(resultSet.getString("state"));
	                contactInfo.setZip(resultSet.getInt("zip"));
	                contactInfo.setPhoneNumber(resultSet.getString("phoneNumber"));
	                contactInfo.setEmailId(resultSet.getString("email"));
	                contactInfo.setBookName(resultSet.getString("bookName"));
	                contactInfo.setContactType(resultSet.getString("contactType"));
	                contactInfo.setDateAdded(resultSet.getDate("Date_added").toLocalDate());

	                addressBookList.add(contactInfo);
	            }
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return addressBookList;
	    }

	    
}