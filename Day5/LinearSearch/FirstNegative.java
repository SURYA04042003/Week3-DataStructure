package Day5.LinearSearch;

import java.util.Scanner;

public class FirstNegative {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of elements in the array: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];

            System.out.println("Enter " + n + " integer elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int index = findFirstNegativeIndex(arr);

            if (index != -1) {
                System.out.println("First negative number found at index: " + index + " (Value: " + arr[index] + ")");
            } else {
                System.out.println("No negative number found in the array.");
            }

            scanner.close();
        }

        public static int findFirstNegativeIndex(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    return i;
                }
            }
            return -1;
        }
    }

