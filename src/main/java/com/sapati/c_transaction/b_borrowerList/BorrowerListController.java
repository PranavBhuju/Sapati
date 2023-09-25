package com.sapati.c_transaction.b_borrowerList;

import com.sapati.a_common.entities.Borrow;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/list")
public class BorrowerListController {

    @Inject
    BorrowerListService borrowerListService;

    @Get("/getAllBorrowers")
    public List<Borrow> getlist(@Header("username")String username){
        return borrowerListService.getBorrowerList(username);
    }
}
