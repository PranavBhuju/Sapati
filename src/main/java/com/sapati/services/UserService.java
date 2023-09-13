package com.sapati.services;

import com.sapati.entity.Person;
import com.sapati.repository.UserRepository;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    @Inject
    UserRepository userrepository;
    public Person save(Person person){
        return userrepository.save(person);
    }

    public Person getbyid(Long id) {
        Optional <Person> userId = userrepository.findById(id);
        if(userId.isPresent()){
            return userId.get();
        }
        return null;
    }

    public List<Person> getallusers() {
        Iterable<Person> allusers = userrepository.findAll();
        List<Person> userlist = new ArrayList<>();
        for (Person person:allusers) {
            userlist.add(person);
        }
        return userlist;
    }

    public String deleteById(Long id) {
        Optional<Person> person = userrepository.findById(id);
        if(person.isPresent()){
            userrepository.deleteById(id);
            return "Deleted successfully";
        }
        return "User does not exist";
    }
}
