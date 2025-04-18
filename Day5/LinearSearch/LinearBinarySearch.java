package Day5;

import java.util.Arrays;
import java.util.Scanner;

public class LinearBinarySearch {
        public static int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            return n + 1;
        }


        public static int binarySearch(int[] arr, int target) {
            int left = 0, right = arr.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return -1;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of elements in the array: ");
            int n = scanner.nextInt();

            int[] nums = new int[n];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }


            int[] numsCopyForLinear = Arrays.copyOf(nums, nums.length);
            int missing = firstMissingPositive(numsCopyForLinear);
            System.out.println("First missing positive integer is: " + missing);

            Arrays.sort(nums);

            System.out.print("Enter target number to search using binary search: ");
            int target = scanner.nextInt();

            int index = binarySearch(nums, target);
            if (index != -1) {
                System.out.println("Target found at index (after sorting): " + index);
            } else {
                System.out.println("Target not found in the array.");
            }

            scanner.close();
        }
    }

