//Extract All Capitalized Words from a Sentence
//        🔹 Example Text:
//        "The Eiffel Tower is in Paris and the Statue of Liberty is in New York."
//        🔹 Expected Output:
//        Eiffel, Tower, Paris, Statue, Liberty, New, York


package org.example.regexProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllCapitalizedWords {
    public static void main(String[] args) {
        String text="The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        String regex="\\b[A-Z][a-z]*\\b";

        Pattern pat=Pattern.compile(regex);
        Matcher mat=pat.matcher(text);

        while(mat.find()) {
            System.out.print(mat.group()+" , ");
        }

    }

}
