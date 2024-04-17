package com.sapati.d_adminControls.c_viewAllTransactions;

import com.sapati.a_common.entities.Transaction;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/admin")
public class ViewTransactionsController {
    @Inject
    ViewTransactionsService viewTransactionsService;
    @Post("/getTransactions")
    public List<Transaction> getlist(@Body("username") String username){
        return viewTransactionsService.showAllTransactions(username);
    }

    @Post("/showTransactions")
    public List<Transaction> showlist(@Body ("num")Long numberOfTransactions){
        return viewTransactionsService.findList(numberOfTransactions);
    }
}

