package FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountOccurrence {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the path of the file to read: ");
            String filePath = scanner.nextLine();

            System.out.print("Enter the word to count: ");
            String targetWord = scanner.nextLine();

            int count = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;

                while ((line = br.readLine()) != null) {
                    // Split line into words using regex to handle punctuation
                    String[] words = line.split("\\W+"); // \\W+ splits on non-word characters

                    for (String word : words) {
                        if (word.equalsIgnoreCase(targetWord)) {
                            count++;
                        }
                    }
                }

                System.out.println("The word \"" + targetWord + "\" appeared " + count + " times in the file.");

            } catch (IOException e) {
                System.out.println("An error occurred while reading the file: " + e.getMessage());
            }

            scanner.close();
        }
    }

