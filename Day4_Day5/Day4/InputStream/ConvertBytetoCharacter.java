package InputStream;

import java.io.*;
import java.util.Scanner;

public class ConvertBytetoCharacter {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the path of the file to read: ");
            String filePath = scanner.nextLine();


            try (
                    FileInputStream fis = new FileInputStream(filePath);
                    InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                    BufferedReader reader = new BufferedReader(isr);
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }

            scanner.close();
        }

    public static class ReadUserInput {
            public static void main(String[] args) {
                String filePath = "output.txt";

                try (
                        InputStreamReader isr = new InputStreamReader(System.in);
                        BufferedReader reader = new BufferedReader(isr);


                        FileWriter fileWriter = new FileWriter(filePath);
                        BufferedWriter writer = new BufferedWriter(fileWriter)
                ) {
                    System.out.println("Enter text to write to the file (type 'exit' to finish):");

                    String line;
                    while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                        writer.write(line);
                        writer.newLine();
                    }

                    System.out.println("Input saved to file: " + filePath);

                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
        }
}

