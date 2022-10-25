package com.bridgelabz.AddressBook;
import org.junit.*;

import java.util.*;

public class TestAddressBook {
    @Test
    public void test1ReadData()
    {
        Address a=new Address();
        Assert.assertEquals(9,a.readData().size());
    }
    @Test
    public void test2CheckUpdate()
    {
        Address a=new Address();
        a.updateContact("address","l",2);
    }
    @Test
    public void test3CheckDoj()
    {
        Address a=new Address();
        Assert.assertEquals(3,a.findDoj("2019-01-01","2019-12-12"));
    }
    @Test
    public void test4CheckCity()
    {
        Address a=new Address();
        Assert.assertEquals(3,a.RetriveField("city","g"));
    }
    @Test
    public void test5CheckState()
    {
        Address a=new Address();
        Assert.assertEquals(2,a.RetriveField("state","l"));
    }

    @Test
    public void test6CheckInsert()
    {
        Address a=new Address();
        int count=a.readData().size();
        Contact c=new Contact();
        c.id=1;
        c.first="a";
        c.last="b";
        c.address="c";
        c.city="d";
        c.state="e";
        c.phno="23456";
        c.email="ab@cd";
        c.zip="45678";
        c.DOJ="2019-11-13";
        a.Insert(c);
        Assert.assertEquals(count+1,a.readData().size());
    }
    @Test
    public void test7CheckMultipleInserts()
    {   Address a=new Address();
        int count=a.readData().size();
        ArrayList<Contact> arr=new ArrayList<>();
        Contact c=new Contact();
        c.id=1;
        c.first="a";
        c.last="b";
        c.address="c";
        c.city="d";
        c.state="e";
        c.phno="23456";
        c.email="ab@cd";
        c.zip="45678";
        c.DOJ="2019-11-13";
        Contact c1=new Contact();
        c1.id=1;
        c1.first="d";
        c1.last="e";
        c1.address="f";
        c1.city="g";
        c1.state="h";
        c1.phno="78901";
        c1.email="de@gh";
        c1.zip="98765";
        c1.DOJ="2016-05-07";
        arr.add(c1);
        arr.add(c);
        a.insertMultiple(arr);
        Assert.assertEquals(count+2,a.readData().size());
    }
}