package com.sapati.b_userAuth.C_adminverify;

import com.sapati.a_common.entities.Person;
import com.sapati.a_common.repositories.UserRepository;
import jakarta.inject.Inject;

import java.util.Optional;

public class AdminVerifyService {
    @Inject
    UserRepository userRepository;

    public String verifyUser(Long id, String username) {
        Optional<Person> user = userRepository.findById(id);
        Optional<Person> admin = userRepository.findByUserName(username);
        if(admin.isPresent() && user.isPresent()){
            if(admin.get().getUserType().equalsIgnoreCase("admin")){
                userRepository.updateVerification(id);
                return "Verification successful";
            }
            return "user not found";
        }
        return "only admin can verify";
    }
}
