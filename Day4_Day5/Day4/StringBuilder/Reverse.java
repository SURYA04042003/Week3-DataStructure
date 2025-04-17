package StringBuilder;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String input = scan.nextLine();
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        System.out.println("Reversed string: " + sb.toString());

        scan.close();
    }
}
