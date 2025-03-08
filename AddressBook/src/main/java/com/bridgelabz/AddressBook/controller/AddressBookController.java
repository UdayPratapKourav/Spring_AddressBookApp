package com.bridgelabz.AddressBook.controller;

import com.bridgelabz.AddressBook.service.AddressBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private AddressBookServiceImpl addressBookService;
    @Autowired
    public AddressBookController(AddressBookServiceImpl addressBookService){
        this.addressBookService=addressBookService;
    }

    //testing application working or not
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Connected Successfully");
    }
}

