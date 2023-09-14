package com.sapati.controller;
import com.sapati.entity.Person;
import com.sapati.services.UserService;
import io.micronaut.http.HttpResponse;
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
    public Person getById(@PathVariable Long id){
        Person p=userService.getById(id);
        return p;
    }

    @Get("/getall")
    public List<Person> getAllUsers(){
        return userService.getAllUsers();
    }

    @Delete("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteById(id);
    }

    @Put("/put")
    public Person updateUser(@Body Person p){
        return userService.updateUser(p);
    }

//    @Put("/put")
//    public HttpResponse updateUser(@Body Person p){
//        Person person =  userService.updateUser(p);
//        if(person!=null){
//            return HttpResponse.ok(person);
//        }
//        return HttpResponse.notFound("User with id "+ p.getId()+" is not found");
//    }
}



