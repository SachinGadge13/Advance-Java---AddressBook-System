package com.bridgelabz.AddressBook;
import io.restassured.*;
import io.restassured.http.*;
import org.junit.*;

import java.util.*;

public class TestRestAssuredAddress {

    @Before
    public void setup() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 4001;

    }

    @Test
    public void test1WriteIntoJson() {
        Address a = new Address();
        List<Contact> contacts = a.readData();
        for (Contact e : contacts) {
            HashMap<String, String> map = new HashMap<>();
            String fname = e.first;
            String lname = e.last;
            String phNo = e.phno;
            String email = e.email;
            String date = e.DOJ;
            map.put("firstName", fname);
            map.put("lastName", lname);
            map.put("Phone", phNo);
            map.put("Email", email);
            map.put("Date", date);
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(map)
                    .when()
                    .post("/Contacts/create");
        }
    }
}