package com.byGaurav.validation;

public interface ValidationService {

    String validateUsername(String username);

    String validatePassword(String password);

    String validateUsernameAndPassword(String username, String password);
}
