package com.zipcodewilmington.phonebook;


import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private String number;
    private String homeAddress;
    private String email;
    private String name;
    private ArrayList<String> contact;
    public TreeMap<String, ArrayList> phoneBook;

    public PhoneBook() {
        phoneBook = new TreeMap<String, ArrayList>();
    }

    public ArrayList<String> createContact(String number, String homeAddress, String email) {
        this.number = number;
        this.homeAddress = homeAddress;
        this.email = email;

        ArrayList<String> contacts = new ArrayList<String>();
        contacts.add(number);
        contacts.add(homeAddress);
        contacts.add(email);

        return contacts;

    }

    public void add(String name, ArrayList<String> contact) {

        this.name = name;
        this.contact = contact;
        phoneBook.put(name, contact);

    }

    public void remove(String name) {

        this.name = name;
        phoneBook.remove(name);

    }

    public ArrayList<String> lookup(String name) {
        this.name = name;

        return phoneBook.get(name);

    }

    public Object reverseLookUp(ArrayList<String> contact) {

        this.contact = contact;
        for (Map.Entry s : phoneBook.entrySet()) {
            if (s.getValue() == contact) {
                return s.getKey();
            }

        }
        return null;

    }

    public void display(){
        //this.phoneBook = phoneBook;
        Set<Map.Entry<String, ArrayList>> set = phoneBook.entrySet();

        for(Map.Entry<String, ArrayList> s : set){
            System.out.print(s.getKey() + "'s contact information is: ");
            System.out.println(s.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Sean", phoneBook.createContact("484-574-3999", "1026 Edgerton Rd. Secane, PA 19018", "nope@nope.com"));
        phoneBook.add("Cara", phoneBook.createContact("123-321-2233", "somewhere, USA", "yep@nope.com"));
        phoneBook.add("Mike", phoneBook.createContact("321-123-3322", "somwhere,USA", "howboutNope@nope.com"));

        phoneBook.display();
    }
}








