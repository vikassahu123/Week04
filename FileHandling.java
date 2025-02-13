package org.example;

import java.io.*;


public class FileHandling {
    public static void main(String[] args) {
        String sourceFile = "C:\\cap-4th week\\Day03\\src\\main\\java\\org\\example\\source.txt";  // Change to your actual file path
        String destinationFile = "destination.txt"; // Output file

        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile);

            int byteData;
            while ((byteData = fis.read()) != -1) { // Read byte by byte
                fos.write(byteData); // Write to the destination file
            }

            System.out.println("File copied successfully!");

            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            System.out.println("Error: Unable to read/write file.");
        }
    }
}
