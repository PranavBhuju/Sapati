package com.sapati.c_transaction.a_borrowRequest;

import com.sapati.a_common.entities.Borrow;
import com.sapati.a_common.entities.Person;
import com.sapati.a_common.repositories.BorrowerRepository;
import com.sapati.a_common.repositories.UserRepository;
import jakarta.inject.Inject;

import java.util.Optional;

public class BorrowRequestService {
    @Inject
    BorrowerRepository borrowerRepository;
    @Inject
    UserRepository userRepository;

    public String newBorrowRequest(Borrow borrow) {
        Optional<Person> existingUser = userRepository.findByUserName(borrow.getBorrowerName());
        Optional<Borrow> existingRequest = borrowerRepository.findByBorrowerName(borrow.getBorrowerName());

        Long principal = borrow.getRequestedAmount();
        Long rate = borrow.getInterestRate();
        Long time = borrow.getPayBackTime();
        Long simpleInterest = (principal * time * rate) / 100;
        Long totalProfit = principal + simpleInterest;

        if (existingUser.isPresent() && existingUser.get().getUserType().equalsIgnoreCase("borrower")) {
            if (existingRequest.isEmpty()) {
                borrow.setTotalProfit(totalProfit);
                borrowerRepository.save(borrow);
                return "Borrow request successfully created";
            }
            return "request already exists";
        }
        return "User is not borrower";
    }
}
