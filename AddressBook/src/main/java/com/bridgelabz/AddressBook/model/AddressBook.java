package com.bridgelabz.AddressBook.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "address_book")
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    private Long id;

    @Column(nullable = false) // Ensures 'name' is mandatory
    private String name;

    @Column(nullable = false, unique = true) // Ensures unique phone numbers
    private String phone;

    @Column(nullable = false, unique = true) // Ensures unique emails
    private String email;
}
