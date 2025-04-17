package Day5.BinarySearch;

import java.util.Scanner;

public class RotationPoint {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of elements in the rotated sorted array: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];

            System.out.println("Enter " + n + " elements of the rotated sorted array:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }


            int rotationIndex = findRotationPoint(arr);


            System.out.println("Rotation point (index of smallest element): " + rotationIndex);
            System.out.println("Smallest element: " + arr[rotationIndex]);

            scanner.close();
        }

        public static int findRotationPoint(int[] arr) {
            int left = 0, right = arr.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] > arr[right]) {

                    left = mid + 1;
                } else {

                    right = mid;
                }
            }
            return left;
        }
    }
