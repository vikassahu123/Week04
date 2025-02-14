//5. try-with-resources (Auto-closing Resources)
//💡 Problem Statement:
//Write a Java program that reads the first line of a file named "info.txt" using BufferedReader.
//Use try-with-resources to ensure the file is automatically closed after reading.
//Handle any IOException that may occur.
//Expected Behavior:
//If the file exists, print its first line.
//If the file does not exist, catch IOException and print "Error reading file".

package org.example.ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class tryWithResources {
        public static void main(String[] args) {
            String fileName = "C:\\cap-4th week\\Day04\\src\\main\\java\\org\\example\\info.txt";

            // Try-with-resources to auto-close BufferedReader
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String firstLine = br.readLine(); // Read the first line
                if (firstLine != null) {
                    System.out.println("First line: " + firstLine);
                } else {
                    System.out.println("File is empty.");
                }
            } catch (IOException e) {
                System.out.println("Error reading file");
            }
        }
    }

