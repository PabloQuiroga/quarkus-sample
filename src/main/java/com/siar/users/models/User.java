package com.siar.users.models;

import java.util.Date;

public class User {
    private int docNumber;
    private String fullName;
    private String birthdate;

    public User(int docNumber, String fullName, String birthdate) {
        this.docNumber = docNumber;
        this.fullName = fullName;
        this.birthdate = birthdate;
    }

    public int getDocNumber() {
        return docNumber;
    }

    public User setDocNumber(int docNumber) {
        this.docNumber = docNumber;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public User setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "docNumber=" + docNumber +
                ", fullName='" + fullName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
