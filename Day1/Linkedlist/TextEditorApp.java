package level1;

import java.util.Scanner;

    class TextState {
        String content;
        level1.TextState prev, next;

        TextState(String content) {
            this.content = content;
            this.prev = null;
            this.next = null;
        }
    }

    class TextEditor {
        private level1.TextState head = null;
        private level1.TextState current = null;
        private int size = 0;
        private final int MAX_HISTORY = 10;

        public void addState(String newContent) {
            level1.TextState newState = new level1.TextState(newContent);

            if (current != null) {
                current.next = null;
            }

            newState.prev = current;

            if (current != null) {
                current.next = newState;
            } else {
                head = newState;
            }

            current = newState;
            size++;


            if (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }

            System.out.println("Text updated.");
        }

        public void undo() {
            if (current != null && current.prev != null) {
                current = current.prev;
                System.out.println("Undo successful.");
            } else {
                System.out.println("No more undo operations available.");
            }
        }

        public void redo() {
            if (current != null && current.next != null) {
                current = current.next;
                System.out.println("Redo successful.");
            } else {
                System.out.println("No more redo operations available.");
            }
        }

        public void displayCurrentState() {
            if (current != null) {
                System.out.println("Current Text: " + current.content);
            } else {
                System.out.println("No text available.");
            }
        }
    }

    public class TextEditorApp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            level1.TextEditor editor = new level1.TextEditor();

            while (true) {
                System.out.println("\n--- Text Editor Menu ---");
                System.out.println("1. Type/Add Text");
                System.out.println("2. Undo");
                System.out.println("3. Redo");
                System.out.println("4. Display Current Text");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter new text state: ");
                        String newText = sc.nextLine();
                        editor.addState(newText);
                        break;
                    case 2:
                        editor.undo();
                        break;
                    case 3:
                        editor.redo();
                        break;
                    case 4:
                        editor.displayCurrentState();
                        break;
                    case 0:
                        System.out.println("Exiting editor.");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }



