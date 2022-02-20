package com.byGaurav.application;

import com.byGaurav.validation.ValidationServiceImpl;

import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String...arguments) {
        Scanner scanner = new Scanner(in);
        out.println("Enter Username: ");
        String username = scanner.nextLine();
        out.println("Enter Password: ");
        String password = scanner.nextLine();
        ValidationServiceImpl validationService = new ValidationServiceImpl();
        String message = validationService.validateUsernameAndPassword(username, password);
        if(message != null)
            out.println(message);
        else
            out.println("Successful Registration.");
    }
}
