//Validate a Username
//        A valid username:
//        Can only contain letters (a-z, A-Z), numbers (0-9), and underscores (_)
//        Must start with a letter
//        Must be between 5 to 15 characters long
//        🔹 Example Inputs & Outputs
//        ✅ "user_123" → Valid
//        ❌ "123user" → Invalid (starts with a number)
//        ❌ "us" → Invalid (too short)

package org.example.regexProblems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class UsernameValidation {
    public static void main(String[] args) {

        String[] usernames = {"user_123", "123user", "us", "ValidUser12", "_invalidUser", "userTooLong123456"};

        String regex="^[A-Za-z][a-zA-Z0-9_]{4,14}$";

        for (String username : usernames)
        {
            // direct comparison
            if(username.matches(regex))
            {
                System.out.println(username+" --> is valid");
            }
            else {
                System.out.println(username + " --> is not valid");
            }
        }

    }
}
