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

        while (true) {
            String command = c.readLine();
            switch (command) {
                case ".exit" -> {
                    System.out.println("Returning to main menu.");
                    return;
                }
                case ".guide" -> {
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
                    return;
                }
                default -> {
                    System.out.println("Invalid command.");
                    continue;
                }
            }
        }
    }

    /**
     * Help texts for the Personal ID validation format.
     */
    public static void personalIDHelp() {
        System.out.println();
        System.out.println("    | Personal ID help | ");
        System.out.println("    - Length needs to be 11 characters.");
        System.out.println("    - Birthdate needs to be valid and not in the future.");
        System.out.println("        - (e.g. February 31th doesn't exists. It can only have 29 or 28 days.)");
        System.out.println("    - Century mark (after birthdate) matches the format.");
        System.out.println("        - (1800s: '+')");
        System.out.println("        - (1900s: '-', 'Y', 'X', 'W', 'V', 'U')");
        System.out.println("        - (2000s: 'A', 'B', 'C', 'D', 'E', 'F')");
        System.out.println("    - Individual number is between 002 and 999.");
        System.out.println("    - ID check mark (last character) is correct.");
        System.out.println("        - (Calculated from the numbers and that result is converted into the check mark.)");
        System.out.println();
    }

    /**
     * Help texts for the First Name validation format.
     */
    public static void firstNameHelp() {
        System.out.println();
        System.out.println("    | First Name help |");
        System.out.println("    - First character needs to be uppercase and the rest lowercase.");
        System.out.println();
    }

    /**
     * Help texts for the Last Name validation format.
     */
    public static void lastNameHelp() {
        System.out.println();
        System.out.println("    | Last Name help |");
        System.out.println("    - First character needs to be uppercase and the rest lowercase.");
        System.out.println("    - Its possible to have double last names. In the style of:");
        System.out.println("        - With hyphen 'Virtanen-Heikkilä' or space 'Virtanen Heikkilä'");
        System.out.println("    - O'Connor style of last name is accept as well. Needs uppercase on both sides of: ' .");
        System.out.println();
    }

    /**
     * Help texts for the Phonenumber validation format.
     */
    public static void phoneNumberHelp() {
        System.out.println();
        System.out.println("    | Phonenumber help |");
        System.out.println("    - Phonenumber needs to be started with '+358'.");
        System.out.println("    - Followed by one of:");
        System.out.println("        - '40', '41', '42', '43', '44', '45', '46' or '50'.");
        System.out.println("    - Followed by 4 to 10 more digits.");
        System.out.println("    - These are all private numbers. Corporate numbers are not accepted.");
        System.out.println();
    }

    /**
     * Help texts for the Street Address validation format.
     */
    public static void streetAddressHelp() {
        System.out.println();
        System.out.println("    | Street Address help |");
        System.out.println("    - Optional to fill (Skipping in this part works by typing '*').");
        System.out.println("    - First character needs to be uppercase and the rest lowercase.");
        System.out.println("    - It can have spaces (e.g. 'Mossin puistotie').");
        System.out.println("    - There is no database to compare to.");
        System.out.println("    - Street Number is given in the next step in '.create'.");
        System.out.println();
    }

    /**
     * Help texts for the Street Number validation format.
     */
    public static void streetNumberHelp() {
        System.out.println();
        System.out.println("    | Street Number help |");
        System.out.println("    - Optional to fill (Skipping in this part works by typing '*').");
        System.out.println("    - Number between 1 and 999.");
        System.out.println();
    }

    /**
     * Help texts for the Postcode validation format.
     */
    public static void postcodeHelp() {
        System.out.println();
        System.out.println("    | Postcode help |");
        System.out.println("    - Optional to fill (Skipping in this part works by typing '*').");
        System.out.println("    - Postcode needs to be 5 digits long.");
        System.out.println("    - Application needs to find a match for it from a .csv file.");
        System.out.println();
    }

    /**
     * Help texts for the City/Postoffice validation format.
     */
    public static void cityHelp() {
        System.out.println();
        System.out.println("    | City/Postoffice help |");
        System.out.println("    - Optional to fill (Skipping in this part works by typing '*').");
        System.out.println("    - First character needs to be uppercase and the rest lowercase.");
        System.out.println("    - You will be printed the city/postoffice matching the postcode.");
        System.out.println("    - Application needs to find a match between the city and the postcode from a .csv file.");
        System.out.println();
    }

    /**
     * Help texts for the E-mail validation format.
     */
    public static void emailHelp() {
        System.out.println();
        System.out.println("    | E-mail help |");
        System.out.println("    - Optional to fill (Skipping in this part works by typing '*').");
        System.out.println("    - E-mail consists of Local Part (Username), @ symbol and Domain name.");
        System.out.println("    - Local Part Rules");
        System.out.println("        - Letters (A-Z, a-z)");
        System.out.println("        - Numbers (0-9)");
        System.out.println("        - Special characters (!#$%&'*+-/=?^_`{|}~.)");
        System.out.println("            - Can't have two in a row or as the first character.");
        System.out.println("            - Needs to be followed by at least one letter or number before @ symbol.");
        System.out.println("    - @ symbol in between");
        System.out.println("    - Domain name Rules");
        System.out.println("        - Letters (a-z)");
        System.out.println("        - Numbers (0-9)");
        System.out.println("        - Special character hyphen - is allowed.");
        System.out.println("            - Needs to be followed by at least one letter or number before '.' dot.");
        System.out.println("        - . (dot) in between");
        System.out.println("        - Letters (a-z)");
        System.out.println("            - Needs to have at least 2 letters after the dot.");
        System.out.println();
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
