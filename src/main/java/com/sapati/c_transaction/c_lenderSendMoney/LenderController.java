package com.sapati.c_transaction.c_lenderSendMoney;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/lender")
public class LenderController {

    @Inject
    LenderService lenderService;


    @Post("/accept")
    public HttpResponse acceptloan(@Body LenderAccept lendingChoose, @Header("username") String lenderName){
        String statusmsg=lenderService.initiateTransaction(lendingChoose,lenderName);
        return HttpResponse.ok(statusmsg);
    }
}
