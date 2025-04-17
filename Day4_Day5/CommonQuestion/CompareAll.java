import java.io.*;
import java.util.Scanner;

public class CompareAll {
    public static void main(String [] args){
            compareStringBuilders();

            compareFileReaders();
        }

        private static void compareStringBuilders() {
            String text = "hello";
            int iterations = 1_000_000;

            long startSB = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < iterations; i++) {
                sb.append(text);
            }
            long endSB = System.nanoTime();
            long timeSB = (endSB - startSB) / 1_000_000;
            System.out.println("Time using StringBuilder: " + timeSB + " ms");

            long startSBuf = System.nanoTime();
            StringBuffer sBuf = new StringBuffer();
            for (int i = 0; i < iterations; i++) {
                sBuf.append(text);
            }
            long endSBuf = System.nanoTime();
            long timeSBuf = (endSBuf - startSBuf) / 1_000_000;
            System.out.println("Time using StringBuffer : " + timeSBuf + " ms");

            System.out.println("---");
        }

        private static void compareFileReaders() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the path to the large text file (e.g., 100MB): ");
            String filePath = scanner.nextLine();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                long startFR = System.nanoTime();
                int wordCount = 0;
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] words = line.trim().split("\\s+");
                    if (!line.isEmpty()) {
                        wordCount += words.length;
                    }
                }

                long endFR = System.nanoTime();
                long timeFR = (endFR - startFR) / 1_000_000;

                System.out.println("FileReader word count: " + wordCount);
                System.out.println("Time using FileReader: " + timeFR + " ms");
            } catch (IOException e) {
                System.out.println("Error using FileReader: " + e.getMessage());
            }


            try (
                    FileInputStream fis = new FileInputStream(filePath);
                    InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                    BufferedReader reader = new BufferedReader(isr)
            ) {
                long startISR = System.nanoTime();
                int wordCount = 0;
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] words = line.trim().split("\\s+");
                    if (!line.isEmpty()) {
                        wordCount += words.length;
                    }
                }

                long endISR = System.nanoTime();
                long timeISR = (endISR - startISR) / 1_000_000;

                System.out.println("InputStreamReader word count: " + wordCount);
                System.out.println("Time using InputStreamReader: " + timeISR + " ms");
            } catch (IOException e) {
                System.out.println("Error using InputStreamReader: " + e.getMessage());
            }

            scanner.close();
        }
    }
