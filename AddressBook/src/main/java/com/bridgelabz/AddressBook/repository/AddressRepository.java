package com.bridgelabz.AddressBook.repository;

import com.bridgelabz.AddressBook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressBook, Long> {

}
