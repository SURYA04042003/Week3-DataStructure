import java.util.*;

public class SlidingWindowMaximum {
        public static List<Integer> maxSlidingWindow(int[] nums, int k) {
            List<Integer> result = new ArrayList<>();
            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                deque.offerLast(i);

                if (i >= k - 1) {
                    result.add(nums[deque.peekFirst()]);
                }
            }
            return result;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();

            int[] nums = new int[n];
            System.out.println("Enter the array elements:");
            for (int i = 0; i < n; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                nums[i] = sc.nextInt();
            }

            System.out.print("Enter window size k: ");
            int k = sc.nextInt();

            if (k > n || k <= 0) {
                System.out.println("Invalid window size!");
                return;
            }

            List<Integer> result = maxSlidingWindow(nums, k);

            System.out.println("\nMaximum in each sliding window of size " + k + ":");
            for (int max : result) {
                System.out.print(max + " ");
            }
            System.out.println();
        }
    }
