package com.siar.users.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDTO {
    @Id
    @GeneratedValue
    private Long id;
    private int docNumber;
    private String fullName;
    private String birthdate;

    public UserDTO() {}

    public UserDTO(int docNumber, String fullName, String birthdate) {
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

    public String getBirthdate() {
        return birthdate;
    }

    public UserDTO setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", docNumber=" + docNumber +
                ", fullName='" + fullName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
