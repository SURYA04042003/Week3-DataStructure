import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];


        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();


        int[] result = findTwoSum(nums, target);

        if (result[0] != -1) {
            System.out.println("Indices found: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers add up to the target.");
        }

        scanner.close();
    }
}
