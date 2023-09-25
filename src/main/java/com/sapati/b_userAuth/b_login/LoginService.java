package com.sapati.b_userAuth.b_login;

import com.sapati.a_common.entities.Person;
import com.sapati.a_common.repositories.UserRepository;
import jakarta.inject.Inject;

import java.util.Optional;

public class LoginService {
    @Inject
    UserRepository userRepository;

    public String authenticate(String username, String password) {
        Optional<Person> existingUser = userRepository.findByUserName(username);
        if (existingUser.isPresent()) {
            Person user = existingUser.get();
            if(user.getPwd().equals(password)){
                return "Authentication successful";
            }else{
                return "Wrong password";
            }
        }else{
            return "user doesn't exist";
        }
    }
}
