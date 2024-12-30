package com.siar.users.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * Se cambia el nombre de la entidad
 */
@Entity
@Data
@AllArgsConstructor
public class UserEntity {
    @Id
    private int docNumber;
    private String fullName;
    private LocalDate birthdate;

    public UserEntity() {}
}
