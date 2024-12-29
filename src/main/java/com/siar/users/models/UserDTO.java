package com.siar.users.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class UserDTO {
    @Id
    private int docNumber;
    private String fullName;
    private LocalDate birthdate;

    public UserDTO() {}

    public UserDTO(int docNumber, String fullName, LocalDate birthdate) {
        this.docNumber = docNumber;
        this.fullName = fullName;
        this.birthdate = birthdate;
    }

    public int getDocNumber() {
        return docNumber;
    }

    public UserDTO setDocNumber(int docNumber) {
        this.docNumber = docNumber;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public UserDTO setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                " docNumber=" + docNumber +
                ", fullName='" + fullName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
