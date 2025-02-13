package org.example;
import java.io.*;

public class UpperToLowerCaseConverter {
    public static void main(String[] args) {
        String sourceFile = "C:\\cap-4th week\\Day03\\src\\main\\java\\org\\example\\source.txt";
        String destinationFile = "lowercase_output.txt";

        convertUpperToLower(sourceFile, destinationFile);
    }


    private static void convertUpperToLower(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("File converted successfully. Check " + destination);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}