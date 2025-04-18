package Day5.BinarySearch;

import java.util.Scanner;

public class SearchTarget {
        public static boolean searchMatrix(int[][] matrix, int target) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            int left = 0;
            int right = rows * cols - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                int row = mid / cols;
                int col = mid % cols;

                int midElement = matrix[row][col];

                if (midElement == target) {
                    return true;
                } else if (midElement < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return false;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of rows: ");
            int rows = scanner.nextInt();

            System.out.print("Enter number of columns: ");
            int cols = scanner.nextInt();

            int[][] matrix = new int[rows][cols];

            System.out.println("Enter the elements of the matrix (row-wise, sorted as described):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Enter the target value to search: ");
            int target = scanner.nextInt();

            boolean found = searchMatrix(matrix, target);
            System.out.println("Target " + target + (found ? " found." : " not found."));

            scanner.close();
        }
    }


