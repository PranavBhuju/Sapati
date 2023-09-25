package com.sapati.c_transaction.e_addBalance;

import com.sapati.a_common.entities.Person;
import com.sapati.a_common.repositories.UserRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.Optional;

@Controller("/add")
public class AddBalance {
    @Inject
    UserRepository userRepository;
    @Post("/addbalance")
    public HttpResponse addBalance(@Body("username") String username,@Body("balance") Long balance){
        Optional <Person> user = userRepository.findByUserName(username);
        Long newBalance = user.get().getBalance()+balance;
        userRepository.addBalance(username,newBalance);
        return HttpResponse.ok("Balance added to user:"+username);
    }
}
