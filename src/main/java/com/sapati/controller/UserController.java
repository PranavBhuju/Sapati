package com.sapati.controller;
import com.sapati.entity.Person;
import com.sapati.services.UserService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/User")
public class UserController {

    @Inject
    UserService userService;
    @Post("/post")
    public Person addUser (@Body Person person){
        return userService.save(person);
    }

    @Get("/get/{id}")
    public Person getbyid (@PathVariable Long id){
        return userService.getbyid(id);
    }

    @Get("/getall")
    public List<Person> getallusers (){
        return userService.getallusers();
    }

    @Delete("/delete/{id}")
    public String deleteuser(@PathVariable Long id){
        return userService.deleteById(id);
    }
}



