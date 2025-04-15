import java.util.*;

public class ZeroSumSubarrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array input from user
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        findZeroSumSubarrays(arr);
    }

    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        boolean found = false;
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sumMap.containsKey(sum)) {
                List<Integer> startIndices = sumMap.get(sum);
                for (int start : startIndices) {
                    System.out.println("Zero-sum subarray found from index " + (start + 1) + " to " + i);
                    found = true;
                }
            }
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        if (!found) {
            System.out.println("No zero-sum subarrays found.");
        }
    }
}
