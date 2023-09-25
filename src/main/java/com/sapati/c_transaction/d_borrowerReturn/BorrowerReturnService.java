package com.sapati.c_transaction.d_borrowerReturn;

import com.sapati.a_common.entities.Person;
import com.sapati.a_common.entities.Transaction;
import com.sapati.a_common.repositories.TransactionRepository;
import com.sapati.a_common.repositories.UserRepository;
import jakarta.inject.Inject;

import java.util.Optional;

public class BorrowerReturnService {

    @Inject
    UserRepository userRepository;
    @Inject
    TransactionRepository transactionRepository;

    public String settleLoan(String borrowerName) {
        Optional<Transaction> transactionDetails = transactionRepository.findByBorrowerName(borrowerName);
        String lenderName = transactionDetails.get().getLenderName();
        Optional<Person> lenderDetails = userRepository.findByUserName(lenderName);
        if(transactionDetails.isPresent()){
            Optional<Person> borrowerDetails = userRepository.findByUserName(borrowerName);
            if(borrowerDetails.get().getBalance()>=transactionDetails.get().getLoan()){

                Long lenderOriginalBalance = lenderDetails.get().getBalance();
                Long newBorrowerBalance =borrowerDetails.get().getBalance()-transactionDetails.get().getLoan();
                Long newLenderBalance = lenderOriginalBalance+transactionDetails.get().getLoan();

                if(borrowerDetails.get().getBalance().equals(transactionDetails.get().getLoan())){
                    transactionRepository.setPendingStatus(transactionDetails.get().getTransactionId(),"Paid");
                    userRepository.setBalance(borrowerDetails.get().getId(),newBorrowerBalance);
                    userRepository.setBalance(lenderDetails.get().getId(),newLenderBalance);
                    return "fully paid";
                }else{
                    userRepository.setBalance(borrowerDetails.get().getId(),newBorrowerBalance);
                    userRepository.setBalance(lenderDetails.get().getId(),newLenderBalance);
                    return "Partially paid.";
                }
            }
            return "balance insufficient to pay back loan ";
        }
        return "No transaction detail found";
    }
}
