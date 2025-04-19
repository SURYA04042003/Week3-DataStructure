import java.io.*;
import java.util.Random;

public class LargeFileReading {
    public static void main(String[] args) throws IOException {
        // Generate files of different sizes
        generateFile("1MB.txt", 1 * 1024 * 1024);   // 1MB file
        generateFile("100MB.txt", 100 * 1024 * 1024);  // 100MB file
        generateFile("500MB.txt", 500 * 1024 * 1024);  // 500MB file

        // Test with each file size
        testFile("1MB.txt");
        testFile("100MB.txt");
        testFile("500MB.txt");
    }

    // Method to generate a file of the specified size
    public static void generateFile(String fileName, int sizeInBytes) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[1024];  // 1 KB buffer
        Random random = new Random();
        int bytesWritten = 0;

        while (bytesWritten < sizeInBytes) {
            random.nextBytes(buffer);  // Fill the buffer with random data
            int bytesToWrite = Math.min(buffer.length, sizeInBytes - bytesWritten);
            fos.write(buffer, 0, bytesToWrite);  // Write data to file
            bytesWritten += bytesToWrite;
        }

        fos.close();
        System.out.println(fileName + " created with size: " + sizeInBytes / (1024 * 1024) + " MB");
    }

    // Method to test reading a file and measuring time for FileReader and InputStreamReader
    public static void testFile(String filePath) throws IOException {
        System.out.println("Testing with file: " + filePath);

        // Test FileReader (Character Stream)
        long startTime = System.nanoTime();
        FileReader fr = new FileReader(filePath);
        while (fr.read() != -1); // Read the entire file
        long endTime = System.nanoTime();
        System.out.println("FileReader Time (Character Stream) for " + filePath + ": " + (endTime - startTime) / 1_000_000 + " ms");
        fr.close();

        // Test InputStreamReader (Byte Stream)
        startTime = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        while (isr.read() != -1); // Read the entire file
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Time (Byte Stream) for " + filePath + ": " + (endTime - startTime) / 1_000_000 + " ms");
        isr.close();

        System.out.println();  // Add a blank line for readability
    }
}