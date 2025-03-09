package com.bridgelabz.AddressBook.controller;

import com.bridgelabz.AddressBook.dto.AddressBookDTO;
import com.bridgelabz.AddressBook.model.AddressBook;
import com.bridgelabz.AddressBook.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
@CrossOrigin(origins = "*")  // Allow requests from any frontend
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Add a new contact
    @PostMapping("/add")
    public ResponseEntity<AddressBook> addContact(@Valid @RequestBody AddressBookDTO contactDTO) {
        AddressBook savedContact = addressBookService.addAddressBook(contactDTO);
        return ResponseEntity.ok(savedContact);
    }

    // Get all contacts
    @GetMapping("/all")
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    // Get contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getContactById(@PathVariable Long id) {
        Optional<AddressBook> contact = addressBookService.getContactById(id);
        return contact.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update contact by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @Valid @RequestBody AddressBookDTO contactDTO) {
        try {
            AddressBook updatedContact = addressBookService.updateContact(id, contactDTO);
            return ResponseEntity.ok(updatedContact);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete contact by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        if (addressBookService.deleteContact(id)) {
            return ResponseEntity.ok("Contact deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
