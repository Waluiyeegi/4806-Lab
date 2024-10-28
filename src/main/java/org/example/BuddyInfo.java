package org.example;


import jakarta.persistence.*;

@Entity
public class BuddyInfo{

    private String name;
    private String phoneNumber;

    //@ManyToOne
    //private AddressBook book;


    @Id
    @GeneratedValue
    private Long id;

    public BuddyInfo() {
        this.name = "";
        this.phoneNumber = "";
    }
    public BuddyInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String toString(){
        String str = "";
            str += "Name: " + getName() + "Phone Number: " + getPhoneNumber() + "\n";
        return str;

    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="addressbook_id")
    private AddressBook addressBook;
    public AddressBook getBook() {
        return addressBook;
    }

    public void setBook(AddressBook addressBook) {
        this.addressBook = addressBook;
        if (addressBook != null && !addressBook.getAddressBook().contains(this)) {
            addressBook.addBuddy(this);
        }
    }

}
