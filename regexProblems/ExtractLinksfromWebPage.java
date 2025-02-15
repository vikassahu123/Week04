
//Extract Links from a Web Page
//        🔹 Example Text:
//        "Visit https://www.google.com and http://example.org for more info."
//        🔹 Expected Output:
//        https://www.google.com, http://example.org

package org.example.regexProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinksfromWebPage {
    public static void main(String[] args) {

        String text="Visit https://www.google.com and http://example.org for more info.";

        String regex = "https?://[a-zA-Z0-9.-]+(?:\\.[a-zA-Z]{2,})(?:/[^\\s]*)?";

        Pattern pat=Pattern.compile(regex);
        Matcher mat=pat.matcher(text);

        while(mat.find()) {
            System.out.print(mat.group()+" , ");
        }

    }
}
