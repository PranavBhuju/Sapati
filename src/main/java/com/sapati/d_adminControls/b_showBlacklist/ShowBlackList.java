package com.sapati.d_adminControls.b_showBlacklist;

import com.sapati.a_common.entities.Person;
import com.sapati.a_common.repositories.UserRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/blacklist")
public class ShowBlackList {

    @Inject
    UserRepository userRepository;

    @Get("/showAll")
    public List<Person> showAllBlacklists(){
        return userRepository.showBlacklists();
    }
}
