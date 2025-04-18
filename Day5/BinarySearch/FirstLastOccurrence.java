package Day5.BinarySearch;

import java.util.Scanner;

public class FirstLastOccurrence {
        public static int findFirstOccurrence(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            int result = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == target) {
                    result = mid;
                    right = mid - 1;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return result;
        }

        // Method to find last occurrence
        public static int findLastOccurrence(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            int result = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == target) {
                    result = mid;
                    left = mid + 1;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return result;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of elements in the sorted array: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];

            System.out.println("Enter the elements (sorted in non-decreasing order):");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.print("Enter the target element: ");
            int target = scanner.nextInt();


            int first = findFirstOccurrence(arr, target);
            int last = findLastOccurrence(arr, target);

            if (first == -1) {
                System.out.println("Target element not found.");
            } else {
                System.out.println("First occurrence at index: " + first);
                System.out.println("Last occurrence at index: " + last);
            }

            scanner.close();
        }
    }


