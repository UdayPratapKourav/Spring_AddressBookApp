package com.bridgelabz.AddressBook.service;

import com.bridgelabz.AddressBook.dto.AddressBookDTO;
import com.bridgelabz.AddressBook.model.AddressBook;
import com.bridgelabz.AddressBook.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressBook addAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook contact = AddressBook.builder()
                .name(addressBookDTO.getName())
                .phone(addressBookDTO.getPhone())
                .email(addressBookDTO.getEmail())
                .build();
        return addressRepository.save(contact);
    }

    @Override
    public List<AddressBook> getAllContacts() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<AddressBook> getContactById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public AddressBook updateContact(Long id, AddressBookDTO addressBookDTO) {
        return addressRepository.findById(id).map(contact -> {
            contact.setName(addressBookDTO.getName());
            contact.setPhone(addressBookDTO.getPhone());
            contact.setEmail(addressBookDTO.getEmail());
            return addressRepository.save(contact);
        }).orElseThrow(() -> new RuntimeException("Contact not found!"));
    }

    @Override
    public boolean deleteContact(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
