//Extract All Email Addresses from a Text
//🔹 Example Text:
//        "Contact us at support@example.com and info@company.org"
//        🔹 Expected Output:
//support@example.com
//info@company.org


package org.example.regexProblems;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllEmailAddresses {
    public static void main(String[] args) {
        String text="Contact us at support@example.com and info@company.org";

        String regex="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pat=Pattern.compile(regex);
        Matcher mat=pat.matcher(text);

        while(mat.find()) {
            System.out.println(mat.group());
        }

    }
}
