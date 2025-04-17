package StringBuffer;

import java.util.Scanner;

public class Concatenate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] inputStrings = new String[n];


        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            inputStrings[i] = scanner.nextLine();
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (String str : inputStrings) {
            stringBuffer.append(str);
        }
        System.out.println("Concatenated string: " + stringBuffer.toString());

        scanner.close();
    }
}
