package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        myContacts = contacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(List<Contact> myContacts) {
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (contact == null || myContacts.contains(contact)) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact contactOld, Contact contactNew) {
        int indexOfOld = myContacts.indexOf(contactOld);
        if (myContacts.contains(contactOld)) {
            myContacts.set(indexOfOld, contactNew);
            return true;
        } else {
            return false;
        }

    }

    public boolean removeContact(Contact contact) {
        if (myContacts.contains(contact)){
            myContacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }

    public int findContact(Contact contact) {
        if (myContacts.contains(contact)) {
            return myContacts.indexOf(contact);
        } else {
            return -1;
        }
    }

    public int findContact(String str) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String str) {
        for (Contact contact: myContacts) {
            if (contact.getName().equals(str)) {
                return contact;
            }
        }
        return null;
    }

    public void printContact() {
        int index = 1;
        for (Contact contact: myContacts) {
            String contactName = contact.getName();
            String contactPhoneNumber = contact.getPhoneNumber();
            System.out.println(index + ". " + contactName + " -> " + contactPhoneNumber);
            index++;
        }
    }


}
