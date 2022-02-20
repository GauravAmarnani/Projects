package com.byGaurav.validation;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public String validateUsernameAndPassword(String username, String password) {
        String message = validateUsername(username);
        if(message == null) {
            message = validatePassword(password);
            if(message == null)
                return null;
            return message;
        }
        return message;
    }

    /**
     * Requirements:
     * 1. Must be between 5-20 characters long.
     * 2. Every initial character of a word must start with Uppercase.
     * 3. Must not contain any numerical values.
     * @param username
     * @return message
     */
    @Override
    public String validateUsername(String username) {
        //1. Must not be null.
        if(username != null) {
            //1. Must be between 5-20 characters long.
            if ((username.length() > 4 && username.length() < 21)) {
                //3. Must contain only Alphabets.
                if(isAlphabet(username)) {
                    //Must have every Initial Letter of the word after space in Upper case.
                    if (isEveryInitialCharacterUppercase(username)) {
                        return null;
                    }
                    return "Username must have initial letter as uppercase.";
                }
                return "Username can only contain alphabets.";
            }
            return "Username length should be between 5 and 20.";
        }
        return "Username cannot be empty.";
    }


    /**
     * Requirements:
     * 1. Must be between 5 - 20 characters long.
     * 2. Must not have white space.
     * 3. Must have at least one numeric value.
     * @param password
     * @return message
     */
    @Override
    public String validatePassword(String password) {
        //1. Must not be null.
        if(password != null) {
            //1. Must be between 5-20 characters long.
            if ((password.length() > 4 && password.length() < 21)) {
                //3. Must not have white spaces.
                if(!password.contains(" ")) {
                    //4. Must have at least 1 numeric value.
                    if(hasNumericValue(password)) {
                        return null;
                    }
                    return "Password should have at least 1 numeric value.";
                }
                return "Password should not contain a white space.";
            }
            return "Password length should be between 5 and 20.";
        }
        return "Password cannot be empty.";
    }

    public Boolean isEveryInitialCharacterUppercase(String input) {
        if(input.charAt(0) > 64 && input.charAt(0) < 91)
            for (int i = 0; i < input.length(); i++)
                if(input.charAt(i) == 32)
                    if(input.charAt(i+1) > 64 && input.charAt(i+1) < 91)
                        return true;
                    else
                        return false;
        return false;
    }

    public Boolean isAlphabet(String input) {
        for (char c : input.toCharArray())
            if(!Character.isLetter(c))
                if(!(c == ' '))
                    return false;
        return true;
    }

    public Boolean hasNumericValue(String input) {
        for (char c : input.toCharArray())
            if (Character.isDigit(c))
                return true;
        return false;
    }
}
