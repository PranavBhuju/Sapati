package com.sapati.b_userAuth.C_adminverify;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/Verify")
public class AdminVerifyController {
    @Inject
    AdminVerifyService adminVerifyService;
    @Get("/User/{id}")
    public HttpResponse verify(@PathVariable Long id, @Header("username")String username){
        String statusMsg = adminVerifyService.verifyUser(id,username);
        return HttpResponse.ok(statusMsg);
    }
}