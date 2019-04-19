package at.nacs.phonebook.communication;

import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactsEndpoint {

    private final ContactManager manager;

    @GetMapping
    public List<Contact> get(){
        return manager.findAll();
    }

    @PostMapping
    public Contact post(@RequestBody Contact contact){
        return manager.save(contact);
    }

    @GetMapping("/address/{address}")
    public List<Contact> get(@PathVariable String address) {
        return manager.findBy(address);
    }
}
