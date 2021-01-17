package com.example.test.controller;

import com.example.test.entity.Contact;
import com.example.test.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

//    @GetMapping({"","/"})
//    public String getAllContacts(Model model, String keyword) {
//        if(keyword != null) {
//            model.addAttribute("contacts", contactService.findByKeyword(keyword));
//        } else {
//            model.addAttribute("contacts", contactService.getAllContacts());
//        }
//        return "list-contacts";
//    }

    @GetMapping({"","/"})
    public String getAllContacts(Model model) {
            model.addAttribute("contacts", contactService.getAllContacts());
        return "list-contacts";
    }

    @GetMapping({"/edit","/edit/{id}"})
    public String editContactById(Model model, @PathVariable("id") Optional<Long> id) {
        if(id.isPresent()) {
            Contact contact = contactService.getContactById(id.get());
            model.addAttribute("contact",contact);
        } else {
            model.addAttribute("contact", new Contact());
        }
        return "add-edit-contact";
    }

    @PostMapping("/create")
    public String createOrUpdateContact(Contact contact) {
        contactService.createOrUpdateContact(contact);
        return "redirect:/contact";
    }

    @GetMapping("/delete/{id}")
    public String deleteContactById(@PathVariable Long id) {
        contactService.deleteContactById(id);
        return "redirect:/contact";
    }
}
