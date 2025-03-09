package com.bridgelabz.AddressBook.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressBookDTO {

        @NotEmpty(message = "Name cannot be empty")
        @Size(min = 2, message = "Name must be at least 2 characters")
        private String name;

        @NotEmpty(message = "Phone number cannot be empty")
        @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
        private String phone;

        @NotEmpty(message = "Email cannot be empty")
        @Email(message = "Invalid email format")
        private String email;
}
