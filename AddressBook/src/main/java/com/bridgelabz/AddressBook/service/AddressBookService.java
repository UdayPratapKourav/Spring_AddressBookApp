package com.bridgelabz.AddressBook.service;

import com.bridgelabz.AddressBook.dto.AddressBookDTO;
import com.bridgelabz.AddressBook.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface AddressBookService {
    AddressBook addAddressBook(AddressBookDTO addressBookDTO);
    List<AddressBook> getAllContacts();
    Optional<AddressBook> getContactById(Long id);
    AddressBook updateContact(Long id, AddressBookDTO addressBookDTO);
    boolean deleteContact(Long id);
}
