package com.siar.dto.users;

import com.siar.commons.ValidationsGroups;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record UserDto(

        @Positive(message = "docNumber must not be null", groups = ValidationsGroups.Post.class)
        @Null(groups = ValidationsGroups.Put.class)
        int docNumber,

        @NotBlank(message = "fullName must not be null", groups = ValidationsGroups.Post.class)
        @Null(groups = ValidationsGroups.Put.class)
        String fullName,

        @NotNull(message = "birthdate must not be null", groups = ValidationsGroups.Post.class)
        @Null(groups = ValidationsGroups.Put.class)
        LocalDate birthdate
) {
}
