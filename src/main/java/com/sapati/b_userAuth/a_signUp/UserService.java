package com.sapati.b_userAuth.a_signUp;
import com.sapati.a_common.useCustom.response.CustomResponse;
import com.sapati.a_common.entities.Person;
import com.sapati.a_common.useCustom.exception.CustomException;
import com.sapati.a_common.repositories.UserRepository;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    @Inject
    UserRepository userRepository;

    public void save(Person person) {
        person.setVerification(false);
        person.setBlacklistStatus(false);
        userRepository.save(person);
    }

    public Person getById(Long id) {
        Optional<Person> userId = userRepository.findById(id);
        if (userId.isPresent()) {
            return userId.get();
        }
        return null;
    }

    public CustomResponse getAllUsers() {
        List<Person> allusers = userRepository.findAll();
        List<Person> userlist = new ArrayList<>();
        for (Person person : allusers) {
            userlist.add(person);
        }
        return new CustomResponse("List: ",HttpStatus.OK,userlist);
    }

    public CustomResponse deleteById(Long id) {
        Optional<Person> person = userRepository.findById(id);
        if (person.isPresent()) {
            userRepository.deleteById(id);
            return new CustomResponse("user deleted", HttpStatus.OK);
        }
        throw new CustomException("User does not exist");
    }

    public Person updateUser(Person p) {
        Optional<Person> findUser = userRepository.findById(p.getId());
        if (findUser.isPresent()) {
            return userRepository.update(p);
        }
        return null;
    }

}
