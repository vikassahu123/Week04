//Extract Dates in dd/mm/yyyy Format
//        🔹 Example Text:
//        "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020."
//        🔹 Expected Output:
//        12/05/2023, 15/08/2024, 29/02/2020

 package org.example.regexProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDates {
    public static void main(String[] args) {

            String text= "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

            String regex="\\b[0-9]{2}/[0-9]{2}/[0-9]{4}\\b";

            Pattern pat=Pattern.compile(regex);
            Matcher mat=pat.matcher(text);

            while(mat.find()) {
                System.out.print(mat.group()+" , ");
            }

        }
    }

