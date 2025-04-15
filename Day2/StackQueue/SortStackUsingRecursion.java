import java.util.Scanner;
import java.util.Stack;

public class SortStackUsingRecursion {

        public static void insertInSortedOrder(Stack<Integer> stack, int element) {
            if (stack.isEmpty() || element > stack.peek()) {
                stack.push(element);
                return;
            }

            int top = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(top);
        }

        public static void sortStack(Stack<Integer> stack) {
            if (!stack.isEmpty()) {
                int top = stack.pop();
                sortStack(stack);
                insertInSortedOrder(stack, top);
            }
        }

        public static void displayStack(Stack<Integer> stack) {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                int val = stack.pop();
                System.out.print(val + " ");
                temp.push(val);
            }

            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Stack<Integer> stack = new Stack<>();

            System.out.print("Enter the number of elements in the stack: ");
            int n = sc.nextInt();

            System.out.println("Enter stack elements (top to bottom):");
            for (int i = 0; i < n; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                int value = sc.nextInt();
                stack.push(value);
            }

            System.out.println("\nOriginal Stack (top to bottom):");
            displayStack(stack);

            sortStack(stack);

            System.out.println("\nSorted Stack (top to bottom):");
            displayStack(stack);
        }
    }

