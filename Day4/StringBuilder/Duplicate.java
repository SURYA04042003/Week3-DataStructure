package StringBuilder;

import java.util.HashSet;
import java.util.Scanner;

public class Duplicate {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string to remove duplicates: ");
            String input = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            HashSet<Character> seen = new HashSet<>();
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (!seen.contains(currentChar)) {
                    sb.append(currentChar);
                    seen.add(currentChar);
                }
            }
            System.out.println("String without duplicates: " + sb.toString());

            scanner.close();
        }
    }