package com.sapati.b_userAuth.a_signUp;

import com.sapati.a_common.useCustom.response.CustomResponse;
import com.sapati.a_common.entities.Person;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/User")
public class UserController {

    @Inject
    UserService userService;

    @Post("/newUser")
    public HttpResponse newUser (@Body Person person){
        userService.save(person);
        return HttpResponse.ok("New User Created");
    }

    @Get("/get/{id}")
    public Person getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @Get("/getall")
    public CustomResponse getAllUsers(){
        return userService.getAllUsers();
    }

    @Delete("/delete/{id}")
    public CustomResponse deleteUser(@PathVariable Long id){
        return userService.deleteById(id);
    }

    @Put("/updateUser")
    public Person updateUser(@Body Person p){
        return userService.updateUser(p);
    }
}
