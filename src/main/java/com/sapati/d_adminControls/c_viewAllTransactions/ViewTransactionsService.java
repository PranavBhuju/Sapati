package com.sapati.d_adminControls.c_viewAllTransactions;

import com.sapati.a_common.entities.Person;
import com.sapati.a_common.entities.Transaction;
import com.sapati.a_common.repositories.TransactionRepository;
import com.sapati.a_common.repositories.UserRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class ViewTransactionsService {

    @Inject
    TransactionRepository transactionRepository;
    @Inject
    UserRepository userRepository;
    public List<Transaction> showAllTransactions(String username) {
        Optional<Person> user = userRepository.findByUserName(username);
        if(user.get().getUserType().equalsIgnoreCase("admin")){
            return transactionRepository.findAll();
        }
        return null;
    }
}
