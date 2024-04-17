//package com.sapati;
//
//import com.sapati.b_userAuth.a_signUp.UserService;
//import jakarta.inject.Inject;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class SumanDai {
//
//    @Inject
//    UserService loginUserServices;
//
//    @Test
//    void checkIfUserCanLoginWithCorrectCredentials() {
//        LoginUserRequest loginUserRequest = new LoginUserRequest();
//        loginUserRequest.setUserName("binaya");
//        loginUserRequest.setUserPassword("password");
//
//        var result = loginUserServices.loginUser(loginUserRequest);
//
//        assertEquals("SUCCESS", result.getMessage());
//    }
//
//    @Test
//    void checkIfUserCanLoginWithIncorrectPassword() {
//        LoginUserRequest loginUserRequest = new LoginUserRequest();
//        loginUserRequest.setUserName("binaya");
//        loginUserRequest.setUserPassword("wrongPassword");
//
//        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//            loginUserServices.loginUser(loginUserRequest);
//        });
//
//        assertEquals("Your password is incorrect. Please re-type your password.",
//                exception.getMessage());
//
//    }
//
//    @Test
//    void checkIfUserCanLoginWithIncorrectUsername() {
//        LoginUserRequest loginUserRequest = new LoginUserRequest();
//        loginUserRequest.setUserName("wrongusername");
//        loginUserRequest.setUserPassword("password");
//
//        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//            loginUserServices.loginUser(loginUserRequest);
//        });
//
//        assertEquals("User not found according to the username.",
//                exception.getMessage());
//    }
//}
