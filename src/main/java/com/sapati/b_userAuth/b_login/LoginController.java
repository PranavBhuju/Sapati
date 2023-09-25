package com.sapati.b_userAuth.b_login;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/Login")
public class LoginController {

    @Inject
    LoginService loginService;

    @Post("/userLogin")
    public HttpResponse login(@Body LoginData loginData){
        String response =loginService.authenticate(loginData.getUserName(), loginData.getPwd());
        return HttpResponse.ok(response);
    }

}
