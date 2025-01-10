package com.siar.users.models;

import com.siar.commons.ValidationsGroups;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(groups = ValidationsGroups.Post.class)
    @NotNull
    private String fullName;
    private LocalDate birthdate;

    public UserEntity() {}
}
