//Censor Bad Words in a Sentence
//Given a list of bad words, replace them with ****.
//        🔹 Example Input:
//        "This is a damn bad example with some stupid words."
//        🔹 Expected Output:
//        "This is a **** bad example with some **** words."

package org.example.regexProblems;

public class BadWord {
    public static void main(String[] args) {

        String text="This is a damn bad example with some stupid words.";

        text = text.replaceAll("(?i)\\bdamn\\b", "****");
        text = text.replaceAll("(?i)\\bstupid\\b", "****");

        System.out.println(text);
    }
}
