package com.sapati.c_transaction.c_lenderSendMoney;

import com.sapati.a_common.entities.Borrow;
import com.sapati.a_common.entities.Person;
import com.sapati.a_common.entities.Transaction;
import com.sapati.a_common.repositories.BorrowerRepository;
import com.sapati.a_common.repositories.TransactionRepository;
import com.sapati.a_common.repositories.UserRepository;
import jakarta.inject.Inject;

import java.util.Optional;

public class LenderService {

    @Inject
    BorrowerRepository borrowerRepository;
    @Inject
    UserRepository userRepository;
    @Inject
    TransactionRepository transactionRepository;

    public String initiateTransaction(LenderAccept lendingTransaction, String lenderName) {

        Optional<Person> lendingUser = userRepository.findByUserName(lenderName);

        if (lendingUser.isPresent()) {

            Optional<Borrow> borrowingRequest = borrowerRepository.findByBorrowerName(lendingTransaction.getBorrowerName());
            Optional<Person> borrowingUser = userRepository.findByUserName(lendingTransaction.getBorrowerName());

            Long borrowerBalance = borrowingUser.get().getBalance();
            Long lenderBalance = lendingUser.get().getBalance();

            if (borrowingRequest.isPresent()) {
                if (lendingTransaction.getLendingAmount() < lenderBalance) {

                    Transaction transactionData = new Transaction(lenderName, lendingTransaction.getBorrowerName(), lendingTransaction.getLendingAmount());
                    transactionData.setPaymentStatus("Pending");

                    userRepository.updateBalance(borrowingUser.get().getId(), borrowerBalance + lendingTransaction.getLendingAmount());

                    userRepository.updateBalance(lendingUser.get().getId(), lenderBalance - lendingTransaction.getLendingAmount());

                    transactionRepository.save(transactionData);
                    borrowerRepository.deleteById(borrowingRequest.get().getId());
                    return "transaction successful";
                }
                return "your balance is insufficient";
            }
            return "borrower either doesn't exist or hasn't made a request";
        }
        return "Only lender can accept borrow requests";
    }
}
