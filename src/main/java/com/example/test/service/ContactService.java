package com.example.test.service;

import com.example.test.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    Contact createOrUpdateContact(Contact contact);
    void deleteContactById(Long id);
//    List<Contact> findByKeyword(String keyword);
}
