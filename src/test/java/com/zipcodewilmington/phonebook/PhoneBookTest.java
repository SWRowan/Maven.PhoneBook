package com.zipcodewilmington.phonebook;

//import jdk.internal.jline.internal.TestAccessible;
import org.junit.Assert;
//import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {


    @Test
    public void addTest() {
        //Given
        //Created new instance of PhoneBook
        PhoneBook testBook = new PhoneBook();
        //Created contact using createContact Method
        ArrayList<String> contact = testBook.createContact("484-574-3999", "1026 Edgerton Rd", "seanwrowan@gmail.com");
        //Expected size of TreeMap should be current size + 1 more after adding 1 key/value
        int expectedSize = testBook.phoneBook.size() + 1;
        //When
        testBook.add("Sean", contact);
        int actualSize = testBook.phoneBook.size();
        //Then
        Assert.assertEquals(expectedSize, actualSize);

    }

    @Test
    public void removeTest() {
        //Given
        PhoneBook testBook = new PhoneBook();
        ArrayList<String> contact = testBook.createContact(null, null, null);
        testBook.add("sean", contact);
        int expected = testBook.phoneBook.size() - 1;
        //When
        testBook.remove("sean");
        int actual = testBook.phoneBook.size();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookupTest() {
        //Given
        PhoneBook testBook = new PhoneBook();
        ArrayList<String> contact = testBook.createContact(null, null, null);
        testBook.add("sean", contact);
        //When
        ArrayList<String> actual = testBook.lookup("sean");
        //Then
        Assert.assertEquals(contact, actual);

    }

    @Test
    public void reverseLookupTest(){
        //Given
        PhoneBook testBook = new PhoneBook();
        ArrayList<String> contact = testBook.createContact("555-555-5555", "here", "nope");
        testBook.add("sean", contact);
        //When
        Object actual = testBook.reverseLookUp(contact);
        //Then
        Assert.assertEquals("sean", actual);
    }

//    @Test
//    public void displayTest(){
//        //Given
//        PhoneBook testBook = new PhoneBook();
//        ArrayList<String> contact = new ArrayList<String>();
//        contact.add("484-574-3999");
//        testBook.add("sean", contact);
//        //Then
//        Assert.assertEquals("sean : 484-574-3999", testBook.display());
//    }


}
