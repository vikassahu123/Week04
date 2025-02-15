package org.example.regexProblems;


import java.util.ArrayList;

public class ExtractLanguages12 {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Define known programming languages
        String[] languages = {"JavaScript", "Java", "Python", "Go", "C", "C++", "Ruby", "Swift", "Kotlin", "PHP"};

        // Create a list to store matches
        ArrayList<String> foundLanguages = new ArrayList<>();

        // Check for each language in the text
        for (String lang : languages) {
            if (text.matches(".*\\b" + lang + "\\b.*")) {
                foundLanguages.add(lang);
            }
        }

        // Print extracted programming languages
        System.out.println(String.join(", ", foundLanguages));
    }
}
