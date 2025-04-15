import java.util.Scanner;
import java.util.Stack;

class QueueUsingStacks {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        public void enqueue(int value) {
            stack1.push(value);
            System.out.println("Enqueued: " + value);
        }

        public void dequeue() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) {
                    System.out.println("Queue is empty.");
                    return;
                }

                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            System.out.println("Dequeued: " + stack2.pop());
        }

        public void peek() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) {
                    System.out.println("Queue is empty.");
                    return;
                }
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            System.out.println("Front: " + stack2.peek());
        }

        public void display() {
            Stack<Integer> temp = new Stack<>();
            System.out.println("Queue elements:");

            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i) + " ");
            }
            for (int i = 0; i < stack1.size(); i++) {
                temp.push(stack1.get(i));
            }
            while (!temp.isEmpty()) {
                System.out.print(temp.pop() + " ");
            }
            System.out.println();
        }
    }

    public class QueueUsingStacksApp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            QueueUsingStacks queue = new QueueUsingStacks();

            while (true) {
                System.out.println("\n--- Queue Using Two Stacks ---");
                System.out.println("1. Enqueue");
                System.out.println("2. Dequeue");
                System.out.println("3. Peek Front");
                System.out.println("4. Display Queue");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to enqueue: ");
                        int value = sc.nextInt();
                        queue.enqueue(value);
                        break;
                    case 2:
                        queue.dequeue();
                        break;
                    case 3:
                        queue.peek();
                        break;
                    case 4:
                        queue.display();
                        break;
                    case 0:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

