import java.io.Console;

/**
 * Extra help texts to be printed when called.
 */
public class Help {

    /**
     * Main menu command help and details.
     * Can also open more details on input formats used.
     */
    public static void showHelp() {
        Console c = System.console();

        System.out.println();
        System.out.println("| Contacts Application Help |");
        System.out.println("Available commands and how to use them.");
        System.out.println("(Type '.guide' for input format details or '.exit' to exit.)");
        System.out.println();
        System.out.println("    | .readAll |");
        System.out.println("    - Prints all rows in the file.");
        System.out.println();
        System.out.println("    | .readLine |");
        System.out.println("    - Prints a line specified by you.");
        System.out.println("    - Example format: '10' would print the contact information on line 10.");
        System.out.println();
        System.out.println("    | .create |");
        System.out.println("    - Allows creating a new contact information line.");
        System.out.println("        - Goes through each field (below) one by one"
                + " while validating given data.");
        System.out.println("    - Headlines: 'Personal ID', 'First Name', 'Last Name', 'Phone Number',"
                + " 'Street Address', 'Street Number', 'Postcode', 'City/Postoffice', 'E-mail'");
        System.out.println("    - Example formats: '131052-308T', 'Jaakko', 'Vilen', '+3584023423',"
                + " 'Hämeenkatu', '1', '33100', 'Tampere', 'jack.smith@gmail.com'");
        System.out.println();
        System.out.println("    | .update |");
        System.out.println("    - Allows updating any content in a line given by you.");
        System.out.println("    - (You can access more information when opening this function.)");
        System.out.println();
        System.out.println("    | .delete |");
        System.out.println("    - Allows deleting lines.");
        System.out.println("    - Example format: '10' would delete the contact information on line 10.");
        System.out.println("    - (You can access more information when opening this function.)");
        System.out.println();
        System.out.println("    | .help |");
        System.out.println("    - Opens this help panel from main menu.");
        System.out.println("    - Inside some functions it's used to access more details on input formats.");
        System.out.println("        - Or you could type '.guide' here for the same information.");
        System.out.println("    - In .update and .delete you can access more information by typing '-2'.");
        System.out.println();
        System.out.println("    | .exit |");
        System.out.println("    - Used in main menu to exit the application.");
        System.out.println("    - Inside some functions it's used to exit those function and to return to main menu.");
        System.out.println("    - In .update and .delete you can exit by typing '-1'.");
        System.out.println();

        String command = c.readLine();
        if (command.equals(".exit")) {
            System.out.println("Returning to main menu.");
        } else if (command.equals(".guide")) {
            personalIDHelp();
            firstNameHelp();
            lastNameHelp();
            phoneNumberHelp();
            streetAddressHelp();
            streetNumberHelp();
            postcodeHelp();
            cityHelp();
            emailHelp();
            System.out.println("Returning to main menu.");
        }
    }

    public static void personalIDHelp() {
        System.out.println("");
    }

    public static void firstNameHelp() {
        System.out.println("");
    }

    public static void lastNameHelp() {
        System.out.println("");
    }

    public static void phoneNumberHelp() {
        System.out.println("");
    }

    public static void streetAddressHelp() {
        System.out.println("");
    }

    public static void streetNumberHelp() {
        System.out.println("");
    }

    public static void postcodeHelp() {
        System.out.println("");
    }

    public static void cityHelp() {
        System.out.println("");
    }
    public static void emailHelp() {
        System.out.println("");
    }

    /**
     * Help texts for the update function.
     */
    public static void updateHelp() {
        System.out.println();
        System.out.println("| Updating lines help |");
        System.out.println("    - You need to enter a number for a line you wish to update.");
        System.out.println("    - \"Number needs to be 1 or higher.\"");
        System.out.println("        - Since headlines can't be modified on the application (line 0).");
        System.out.println("        - However, you can manually edit the csv text file.");
        System.out.println("    - \"Line number out of range.\"");
        System.out.println("        - Your number exceeds the amount of current records."
                + " So there is nothing to update.");
        System.out.println();
        System.out.println("    - You will be shown the line your about to update.");
        System.out.println("        - You can show it again entering '.show'."
                + " It will be updated with any changes you have made so far.");
        System.out.println("    - Then you need to enter one of the nine fields you wish to update.");
        System.out.println("        - You can update as many fields as you want,"
                + " and do so as many times as needed.");
        System.out.println("    - REMEMBER TO SAVE!");
        System.out.println("        - Any changes you make are NOT saved automatically.");
        System.out.println("        - You will be reminded of this when you are exiting update.");
        System.out.println("        - When saving changes, you should see \"Line updated successfully.\"");
        System.out.println();
    }

/**
 * Help texts for the delete function.
 */
    public static void deleteHelp() {
        System.out.println();
        System.out.println("| Deleting lines help| ");
        System.out.println("    - You need to enter a number for a line you wish to delete.");
        System.out.println("    - \"Number needs to be 1 or higher.\"");
        System.out.println("        - Since headlines can't be deleted (line 0).");
        System.out.println("    - \"Line number out of range.\"");
        System.out.println("        - Your number exceeds the amount of current records."
                + " So there is nothing to delete.");
        System.out.println();
        System.out.println("    - You will be shown the line your about to delete.");
        System.out.println("    - You can't restore any deleted data."
                + " So your asked to confirm the delete.");
        System.out.println();
        System.out.println("    -After these steps your line will be deleted.");
        System.out.println("        -You should see \"Line deleted successfully.\" and"
                + " \"File has been updated.\" after which you are returned to main menu.");
        System.out.println();
    }
}
