package com.sapati.d_adminControls.a_addBlacklist;

import com.sapati.a_common.entities.Person;
import com.sapati.a_common.repositories.UserRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.Optional;

@Controller("/blacklist")
public class AddBlackList {

    @Inject
    UserRepository userRepository;

    @Post("/add")
    public String addBlacklist(@Header("username") String username){
        Optional<Person> user = userRepository.findByUserName(username);
        if(user.isPresent()){
            user.get().setBlacklistStatus(true);
        }
        return "user blacklisted";
    }

}
