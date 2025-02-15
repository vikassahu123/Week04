package org.example.regexProblems;


import java.util.regex.*;

public class ExtractCurrency13 {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Regular expression to match currency values (with or without $)
        String currencyPattern = "\\$?\\d+\\.\\d{2}";

        // Compile the pattern
        Pattern pattern = Pattern.compile(currencyPattern);
        Matcher matcher = pattern.matcher(text);

        // Extract and print matches directly
        boolean found = false;
        while (matcher.find()) {
            if (found) {
                System.out.print(", "); // Add a comma between values
            }
            System.out.print(matcher.group());
            found = true;
        }
    }
}
