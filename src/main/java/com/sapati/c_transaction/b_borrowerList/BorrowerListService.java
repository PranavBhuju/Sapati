package com.sapati.c_transaction.b_borrowerList;

import com.sapati.a_common.entities.Borrow;
import com.sapati.a_common.entities.Person;
import com.sapati.a_common.repositories.BorrowerRepository;
import com.sapati.a_common.repositories.UserRepository;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BorrowerListService {

    @Inject
    BorrowerRepository borrowerRepository;
    @Inject
    UserRepository userRepository;

    public List<Borrow> getBorrowerList(String username) {
        Optional<Person> user = userRepository.findByUserName(username);
        if(user.isPresent() && user.get().getUserType().equalsIgnoreCase("lender")){

            Long lenderBalance =user.get().getBalance();
            List<Borrow> borrowingUsers = borrowerRepository.findAllRequestsLessThanLenderBal(lenderBalance);

            return new ArrayList<>(borrowingUsers);
        }
        return Collections.emptyList();
    }
}
