package org.example.regexProblems;

public class CreditCardNumber {
    public static void main(String[] args) {
        String[] testCards = {
                "4123456789012345", // Valid Visa
                "5123456789012345", // Valid MasterCard
                "6123456789012345", // Invalid (Doesn't start with 4 or 5)
                "41234",            // Invalid (Too short)
                "5234567890123456", // Valid MasterCard
                "42345678901234a6", // Invalid (Contains a letter)
                "52345678901234567" // Invalid (Too long)
        };

        for (String card : testCards) {
            System.out.println(card + " → " + (isValidCreditCard(card) ? "Valid" : "Invalid"));
        }
    }

    public static boolean isValidCreditCard(String cardNumber) {
        // Check if length is exactly 16
        if (cardNumber.length() != 16) {
            return false;
        }

        // Check if all characters are digits
        for (char ch : cardNumber.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        // Check if it starts with '4' (Visa) or '5' (MasterCard)
        return cardNumber.startsWith("4") || cardNumber.startsWith("5");
    }
}
