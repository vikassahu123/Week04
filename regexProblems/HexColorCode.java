//Validate a Hex Color Code
//        A valid hex color:
//        Starts with a #
//        Followed by 6 hexadecimal characters (0-9, A-F, a-f).
//        🔹 Example Inputs & Outputs
//        ✅ "#FFA500" → Valid
//        ✅ "#ff4500" → Valid
//        ❌ "#123" → Invalid (too short)


package org.example.regexProblems;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColorCode {
    public static void main(String[] args) {

        String[] colors = {"#FFA500", "#ff4500", "#123", "#GGG999", "#abc123", "#A1B2C3"};

        String regex = "^#[0-9A-Fa-f]{6}$";

        for (String color : colors) {
            if (color.matches(regex)) {
                System.out.println(color + " --> is valid");
            } else {
                System.out.println(color + " --> is not valid");
            }
        }
    }
}