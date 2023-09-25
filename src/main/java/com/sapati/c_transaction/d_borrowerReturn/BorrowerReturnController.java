package com.sapati.c_transaction.d_borrowerReturn;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/return")
public class BorrowerReturnController {

    @Inject
    BorrowerReturnService borrowerReturnService;
    @Get("/borrowedMoney")
    public HttpResponse returnLoan(@Header("username")String borrowerName){
        String msg = borrowerReturnService.settleLoan(borrowerName);
        return HttpResponse.ok("msg");
    }

}
