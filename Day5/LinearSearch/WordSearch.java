package Day5.LinearSearch;

import java.util.Scanner;

public class WordSearch {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of sentences: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            String[] sentences = new String[n];

            System.out.println("Enter the sentences:");
            for (int i = 0; i < n; i++) {
                sentences[i] = scanner.nextLine();
            }

            System.out.print("Enter the word to search for: ");
            String word = scanner.nextLine();

            String result = searchWordInSentences(sentences, word);

            System.out.println("Result: " + result);

            scanner.close();
        }


        public static String searchWordInSentences(String[] sentences, String word) {
            for (String sentence : sentences) {
                String[] words = sentence.split("\\W+"); // Split by non-word characters
                for (String w : words) {
                    if (w.equalsIgnoreCase(word)) {
                        return sentence;
                    }
                }
            }
            return "Not Found";
        }
    }
