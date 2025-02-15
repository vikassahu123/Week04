//Replace and Modify Strings
//        8️⃣ Replace Multiple Spaces with a Single Space
//        🔹 Example Input:
//        "This is an example with multiple spaces."
//        🔹 Expected Output:
//        "This is an example with multiple spaces.

package org.example.regexProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceMultipleWithSingleSpace {

    public static void main(String[] args) {

        String text= "This is an example with multiple spaces.";

        String modifiedText = text.replaceAll("\\s+", " ");

        System.out.println(modifiedText);

    }
}