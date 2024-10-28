package org.example;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        BuddyInfo Joe = new BuddyInfo("Joe", "101");
        BuddyInfo Bob = new BuddyInfo("Bob", "202");
        addressBook.addBuddy(Joe);
        addressBook.addBuddy(Bob);
        System.out.println(addressBook.toString());

//        org.example.BuddyinfoTest test = new org.example.BuddyinfoTest();
//        test.performBuddyInfo();

    }
}