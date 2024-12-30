package com.siar.dto.users;

import java.time.LocalDate;

public record UpdateUserDto(
        int docNumber,
        String fullName,
        LocalDate birthdate
) {
}
