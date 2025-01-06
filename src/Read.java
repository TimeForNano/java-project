
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;

public class Read {

    public static void readAll() {
        try {
            BufferedReader readerAll = new BufferedReader(new FileReader("Contacts.csv"));
            String line;
            while ((line = readerAll.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.printf("%-15s", "| " + index);
                }
                System.out.println();
            }
            readerAll.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void readLine() {
        Console c = System.console();

        int rowNumber = -1;
        while (true) {
            System.out.println("To exit .readLine type '-1'.");
            System.out.println("To read enter row number:");
            try {
                rowNumber = Integer.parseInt(c.readLine());

                if (rowNumber == -1) {
                    break;
                } else if (rowNumber < 0) {
                    System.out.println("Number needs to be 0 or higher.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            boolean lineFound = false;
            try {
                BufferedReader readerLine = new BufferedReader(new FileReader("Contacts.csv"));
                String line;
                int currentLine = 0;
                while ((line = readerLine.readLine()) != null) {
                    if (currentLine == rowNumber) {
                        String[] row = line.split(",");
                        for (String Index : row) {
                            System.out.printf("%-15s", "| " + Index);
                        }
                        lineFound = true;
                        System.out.println();
                    }
                    currentLine++;
                }
                if (!lineFound) {
                    System.out.println("Line number out of range.");
                    continue;
                }
                readerLine.close();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
