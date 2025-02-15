package org.example.regexProblems;


import java.util.regex.*;
        import java.util.HashSet;

public class FindRepeatingWords14 {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regular expression to match words
        String wordPattern = "\\b\\w+\\b";

        // Compile the pattern
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(text);

        // HashSet to track words
        HashSet<String> seenWords = new HashSet<>();
        boolean firstRepeated = false;

        // Find and print repeating words
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case insensitivity

            if (seenWords.contains(word)) {
                if (firstRepeated) {
                    System.out.print(", ");
                }
                System.out.print(word);
                firstRepeated = true;
            } else {
                seenWords.add(word);
            }
        }
    }
}
