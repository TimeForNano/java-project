
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles the deletion of lines in the text file.
 */
public class Delete {

    /**
     * User is prompted to give a line number that they want to delete.
     * Line number is first validated to be 1 or higher and found in the text file.
     * If valid. User is asked if they really want to delete line x.
     * Proceeds to delete said line.
     */
    public static void delete() {
        Console c = System.console();

        int toDelete = -1;
        while (true) {
            System.out.println("    (To exit type '-1' and for help type '-2'.)");
            System.out.println("What line do you wish to delete?");
            try {
                toDelete = Integer.parseInt(c.readLine());
                if (toDelete == Constants.COMMAND_EXIT) {
                    System.out.println("Cancelling and exiting delete.");
                    return;
                } else if (toDelete == Constants.COMMAND_HELP) {
                    Help.deleteHelp();
                } else if (toDelete < 1) {
                    System.out.println("Number needs to be 1 or higher.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            try {
                try (BufferedReader readerLine = new BufferedReader(new FileReader(""
                        + "Contacts.csv"))) {
                    String line;
                    int currentLine = 0;
                    while ((line = readerLine.readLine()) != null) {
                        if (currentLine == toDelete) {
                            System.out.println("Current line: " + line);
                            break;
                        }
                        currentLine++;
                    }
                    if (currentLine <= toDelete) {
                        System.out.println("Line number out of range.");
                    }
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        System.out.println("Are you sure you wanna delete this line? Type 'Yes'/'No'.");
        System.out.println("Warning! There is no way to restore deleted data.");
        String confirmDelete = c.readLine();
        if (confirmDelete.equals("Yes")) {
            System.out.println("Proceeding to delete...");
        } else {
            System.out.println("Cancelling and exiting delete.");
            return;
        }

        try {
            ArrayList<String> contactsList = new ArrayList<>();
            try (BufferedReader readerCSV = new BufferedReader(new FileReader("Contacts.csv"))) {
                String line;
                while ((line = readerCSV.readLine()) != null) {
                    contactsList.add(line);
                }
            }

            if (toDelete >= 0 && toDelete < contactsList.size()) {
                contactsList.remove(toDelete);
                System.out.println("Line deleted successfully.");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Contacts.csv"))) {
                for (String index : contactsList) {
                    writer.write(index);
                    writer.newLine();
                }
            }
            System.out.println("File has been updated.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
