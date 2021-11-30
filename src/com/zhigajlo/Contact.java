package com.zhigajlo;


import java.io.Serializable;

public class Contact implements Serializable {
    private static final long serialVersionUID = 2L;

    private String name;
    private String phoneNumber;
    private int birthday;

    public Contact(String name, String phoneNumber, int birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Contact\n" +
                "Name: " + name + '\n' +
                "Phone number: " + phoneNumber + '\n' +
                "Birth date: " + birthday;
    }
}
