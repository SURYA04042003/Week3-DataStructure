package StringBuffer;

import java.util.Scanner;

public class CompareBuilderandBuffer {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the string to concatenate: ");
            String str = scanner.nextLine();

            System.out.print("Enter the number of times to concatenate: ");
            int numStrings = scanner.nextInt();
            long startTimeBuffer = System.nanoTime();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < numStrings; i++) {
                stringBuffer.append(str);
            }
            long endTimeBuffer = System.nanoTime();
            long durationBuffer = endTimeBuffer - startTimeBuffer;

            long startTimeBuilder = System.nanoTime();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numStrings; i++) {
                stringBuilder.append(str);
            }
            long endTimeBuilder = System.nanoTime();
            long durationBuilder = endTimeBuilder - startTimeBuilder;

            System.out.println("Time taken by StringBuffer: " + durationBuffer + " nanoseconds");
            System.out.println("Time taken by StringBuilder: " + durationBuilder + " nanoseconds");

            scanner.close();
        }
    }

