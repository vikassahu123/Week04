//Validate a License Plate Number
//        License plate format: Starts with two uppercase letters, followed by four digits.
//        Example: "AB1234" is valid, but "A12345" is invalid.


package org.example.regexProblems;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlateNumber {
    public static void main(String[] args) {

        String[] plates = {"AB1234", "A12345", "XY6789", "abc1234", "AB12C4", "A1234B"};

        String regex = "^[A-Z]{2}[0-9]{4}$";

        for (String plate : plates) {
            if (plate.matches(regex)) {
                System.out.println(plate + " --> is valid ");
            } else {
                System.out.println(plate + " --> is invalid");
            }
        }
    }
}
