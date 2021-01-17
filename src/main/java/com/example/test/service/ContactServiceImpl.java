package com.example.test.service;

import com.example.test.entity.Contact;
import com.example.test.exception.RecordNotFoundException;
import com.example.test.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> result = contactRepository.findAll();
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Contact getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()) {
            return contact.get();
        } else {
            throw new RecordNotFoundException("No contact record exists");
        }
    }

    @Override
    public Contact createOrUpdateContact(Contact contact) {
        if(contact.getId() == null) {
            contact = contactRepository.save(contact);
            return contact;
        } else {
            Optional<Contact> contactOptional = contactRepository.findById(contact.getId());
            if(contactOptional.isPresent()) {
                Contact newContact = contactOptional.get();
                newContact.setFullName(contact.getFullName());
                newContact.setEmail(contact.getEmail());
                newContact.setTelephone(contact.getTelephone());
                newContact = contactRepository.save(newContact);
                return newContact;
            } else {
                contact = contactRepository.save(contact);
                return contact;
            }
        }
    }

    @Override
    public void deleteContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()) {
            contactRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No contact record exists for given id." + id);
        }
    }

//    @Override
//    public List<Contact> findByKeyword(String keyword) {
//        return contactRepository.findByKeyword(keyword);
//    }
}
