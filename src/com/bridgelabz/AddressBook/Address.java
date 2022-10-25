package com.bridgelabz.AddressBook;

import java.sql.*;
import java.util.*;


public class Address {
    static Scanner sc = new Scanner(System.in);
    ConnectionRetriever con = new ConnectionRetriever();
    PreparedStatement Statement;

    public List<Contact> readData() {
        String sql = "select * from contact c, address a where c.contact_id=a.contact_id ;";
        List<Contact> arr = new ArrayList<Contact>();
        try {
            Connection connection = con.getConnection();
            Statement = connection.prepareStatement(sql);
            ResultSet result = Statement.executeQuery();
            while (result.next()) {
                Contact c = new Contact();
                c.first = result.getString("first_name");
                c.last = result.getString("last_name");
                c.address = result.getString("address");
                c.email = result.getString("email");
                c.phno = result.getString("phone_no");
                c.city = result.getString("city");
                c.state = result.getString("state");
                c.zip = result.getString("zip");
                arr.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return arr;
    }

    public void updateContact(String field, String data, int contact_id) {
        String sql = "update contact c, address a set " + field + "=? where c.contact_id=a.contact_id and c.contact_id=?;";
        try {
            Connection connection = con.getConnection();
            Statement = connection.prepareStatement(sql);
            ;
            Statement.setString(1, data);
            Statement.setInt(2, contact_id);
            Statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int findDoj(String start, String end) {
        int count = 0;
        String sql = "select * from address where DOJ between ? and ?;";
        try {
            Connection connection = con.getConnection();
            Statement = connection.prepareStatement(sql);
            ;
            Statement.setString(1, start);
            Statement.setString(2, end);
            ResultSet r = Statement.executeQuery();
            while (r.next()) {
                count++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public int RetriveField(String field,String data)
    {
        int count = 0;
        String sql = "select * from address where "+field+"=?";
        try {
            Connection connection = con.getConnection();
            Statement = connection.prepareStatement(sql);
            Statement.setString(1, data);
            ResultSet r = Statement.executeQuery();
            while (r.next()) {
                count++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
    public void Insert(Contact c)
    {
        String sql="insert into contact (id,first_name,last_name,phone_no,email) values (?,?,?,?,?);";
        try {
            int id=0;
            Connection connection = con.getConnection();
            Statement = connection.prepareStatement(sql);
            Statement.setInt(1, c.id);
            Statement.setString(2,c.first);
            Statement.setString(3,c.last);
            Statement.setString(4,c.phno);
            Statement.setString(5,c.email);
            Statement.executeUpdate();
            //getting the contact id which is assigned by auto increment
            Statement = connection.prepareStatement("select contact_id from contact where phone_no=?");
            Statement.setString(1,c.phno);
            ResultSet r=Statement.executeQuery();
            while(r.next())
            {
                id=r.getInt(1);
                break;
            }
            //using contact id to assign address table
            Statement = connection.prepareStatement("insert into address (contact_id,address,city,state,zip,DOJ) values (?,?,?,?,?,?);");
            Statement.setInt(1,id);
            Statement.setString(2,c.address);
            Statement.setString(3,c.city);
            Statement.setString(4,c.state);
            Statement.setString(5,c.zip);
            Statement.setString(6,c.DOJ);
            Statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertMultiple(ArrayList<Contact> arr) {
        for(Contact c:arr) {
            Runnable task = () -> {
               Insert(c);
            };
            Thread thread = new Thread(task);
            thread.start();
            try {
                thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}