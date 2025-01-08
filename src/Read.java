
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;

/**
 * Allows reading all or a specific line from the csv text file.
 */
public class Read {

    /**
     * Reads all lines in the text file and prints them out.
     */
    public static void readAll() {
        try {
            try (BufferedReader readerAll = new BufferedReader(new FileReader("Contacts.csv"))) {
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
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Reads user specified line and prints it. User can keep reading lines
     * until they decide to exit.
     */
    public static void readLine() {
        Console c = System.console();

        int rowNumber = -1;
        while (true) {
            System.out.println("    (To exit type '-1'.)");
            System.out.println("To read enter row number:");
            try {
                rowNumber = Integer.parseInt(c.readLine());
                if (rowNumber == Constants.COMMAND_EXIT) {
                    return;
                } else if (rowNumber < Constants.INDEX_0) {
                    System.out.println("Number needs to be 0 or higher.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            boolean lineFound = false;
            try {
                try (BufferedReader readerLine = new BufferedReader(new FileReader("Contacts.csv"))) {
                    String line;
                    int currentLine = Constants.INDEX_0;
                    while ((line = readerLine.readLine()) != null) {
                        if (currentLine == rowNumber) {
                            String[] row = line.split(",");
                            for (String index : row) {
                                System.out.printf("%-15s", "| " + index);
                            }
                            lineFound = true;
                            System.out.println();
                        }
                        currentLine++;
                    }
                    if (!lineFound) {
                        System.out.println("Line number out of range.");
                    }
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
