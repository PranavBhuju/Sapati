package com.sapati.services;

import com.sapati.entity.Person;
import com.sapati.repository.UserRepository;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    @Inject
    UserRepository userRepository;

    public Person save(Person person) {
        person.setIsVerified(false);
        return userRepository.save(person);
    }

    public Person getById(Long id) {
        Optional<Person> userId = userRepository.findById(id);
        if (userId.isPresent()) {
            return userId.get();
        }
        return null;
    }

    public List<Person> getAllUsers() {
        Iterable<Person> allusers = userRepository.findAll();
        List<Person> userlist = new ArrayList<>();
        for (Person person : allusers) {
            userlist.add(person);
        }
        return userlist;
    }

    public String deleteById(Long id) {
        Optional<Person> person = userRepository.findById(id);
        if (person.isPresent()) {
            userRepository.deleteById(id);
            return "Deleted successfully";
        }
        return "User does not exist";
    }

    public Person updateUser(Person p) {
        Optional<Person> findUser = userRepository.findById(p.getId());
        if (findUser.isPresent()) {
            return userRepository.update(p);
        }
        return null;
    }
}
