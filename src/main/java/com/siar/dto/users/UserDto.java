package com.siar.dto.users;

import com.siar.commons.ValidationsGroups;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record UserDto(

        @Positive(groups = ValidationsGroups.Post.class)
        int docNumber,

        @NotBlank
        @NotNull
        String fullName,

        @NotNull(groups = ValidationsGroups.Post.class)
        LocalDate birthdate
) {
}
