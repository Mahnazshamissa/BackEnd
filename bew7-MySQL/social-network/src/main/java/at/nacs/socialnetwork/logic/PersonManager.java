package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.persistence.domain.Person;
import at.nacs.socialnetwork.persistence.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public List<Person> findWithFriends() {
        return repository.findByFriendsNotEmpty();
    }

    public List<Person> findWithoutFriends() {
        return repository.findByFriendsEmpty();
    }




}
