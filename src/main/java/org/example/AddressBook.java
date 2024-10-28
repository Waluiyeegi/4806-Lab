package org.example;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook{

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BuddyInfo> list;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public AddressBook(String name){
        list = new ArrayList<>();
        this.name = name;
    }

    public AddressBook() {
        list = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddyInfo){
        list.add(buddyInfo);
    }

    public String toString(){
        String str = "";
        for (BuddyInfo buddyInfo : list){
            str += "Name: " + buddyInfo.getName() + " Phone Number: " + buddyInfo.getPhoneNumber() + "\n";
        }
        return str;
    }

    public BuddyInfo getBudd(int num){
        return list.get(num);
    }

    public int getSize(){
        return list.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToMany()
    public List<BuddyInfo> getAddressBook() {
        return list;
    }

    public void setAddressBook(List<BuddyInfo> addressBook) {
        this.list = addressBook;
    }
}
