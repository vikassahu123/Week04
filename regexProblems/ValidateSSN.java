package org.example.regexProblems;


public class ValidateSSN {
    public static void main(String[] args) {
        String[] testSSNs = {
                "123-45-6789", // Valid
                "123456789",   // Invalid (No dashes)
                "12-345-6789", // Invalid (Wrong grouping)
                "123-456-789", // Invalid (Wrong grouping)
                "abc-45-6789"  // Invalid (Contains letters)
        };

        for (String ssn : testSSNs) {
            if (isValidSSN(ssn)) {
                System.out.println( ssn + " is valid");
            } else {
                System.out.println( ssn + " is invalid");
            }
        }
    }

    public static boolean isValidSSN(String ssn) {
        // Regular expression to match the SSN format (XXX-XX-XXXX)
        String ssnPattern = "^\\d{3}-\\d{2}-\\d{4}$";

        return ssn.matches(ssnPattern);
    }
}
