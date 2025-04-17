package InputStream;
import java.io.*;
public class ReadUserInput {
    public static void main(String[] args) {
        String filePath = "output.txt";

        try (
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(isr);


                FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter writer = new BufferedWriter(fileWriter)
        ) {
            System.out.println("Enter text to write to the file (type 'exit' to finish):");

            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Input saved to file: " + filePath);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

