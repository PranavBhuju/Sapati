package com.sapati.c_transaction.a_borrowRequest;

import com.sapati.a_common.entities.Borrow;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/borrow")
public class BorrowRequestController {

    @Inject
    BorrowRequestService borrowRequestService;

    @Post("/request")
    public HttpResponse request(@Body Borrow borrow){
        String statusmsg = borrowRequestService.newBorrowRequest(borrow);
        return HttpResponse.ok(statusmsg);
    }
}
