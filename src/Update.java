
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Allows updating any value in the csv text file.
 */
public class Update {

    /**
     * User is prompted to give a line number that they want to update. Line
     * number is first validated to be 0 or higher and found in the text file.
     * If valid. Method <code>updateMenu</code> is started.
     */
    public static void update() {
        Console c = System.console();

        int lineToUpdate;
        while (true) {
            System.out.println("    (To exit type '-1' and for help type '-2'.)");
            System.out.println("What line number you want to update?");
            try {
                lineToUpdate = Integer.parseInt(c.readLine());
                if (lineToUpdate == Constants.COMMAND_EXIT) {
                    return;
                } else if (lineToUpdate == Constants.COMMAND_HELP) {
                    Help.updateHelp();
                } else if (lineToUpdate < Constants.INDEX_1) {
                    System.out.println("Number needs to be 1 or higher.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        String currentLine = "";
        System.out.print("Current line: ");
        try {
            try (BufferedReader readerLine = new BufferedReader(new FileReader("Contacts.csv"))) {
                int currentLineIndex = Constants.INDEX_0;
                boolean lineFound = false;
                while ((currentLine = readerLine.readLine()) != null) {
                    if (currentLineIndex == lineToUpdate) {
                        System.out.println(currentLine);
                        lineFound = true;
                        break;
                    }
                    currentLineIndex++;
                }
                if (!lineFound) {
                    System.out.println("Line number out of range.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        updateMenu(lineToUpdate, currentLine);
    }

    /**
     * User is asked which of the 9 values they want to update. User can keep
     * updating values until they <code>.exit</code> However changes are not
     * saved with out <code>.save</code> Which proceeds to update said line to
     * the text file.
     *
     * @param lineToUpdate Holds the value for line to be updated.
     * @param currentLine Holds the values currently in the text file on that line.
     */
    public static void updateMenu(final Integer lineToUpdate, final String currentLine) {
        Console c = System.console();

        ArrayList<String> currentUpdate = new ArrayList<>();
        String[] split = currentLine.split(",");
        currentUpdate.addAll(Arrays.asList(split));

        String newLine;
        while (true) {
            System.out.println("    (To save type '.save'. To exit type '.exit'.)");
            System.out.println("    (To show current line type '.show'. For help type '.help'.)");
            System.out.println("Enter the field number you wanna update.");
            System.out.println("1.Personal ID 2.First Name 3.Last Name 4.Phone Number"
                    + " 5.Street Address 6.Street Number 7.Postcode 8.City/Postoffice 9.E-mail");
            String commandInput = c.readLine();

            switch (commandInput) {
                case "1" -> {
                    System.out.println("Current Personal ID: " + currentUpdate.get(Constants.INDEX_0));
                    System.out.println("Enter New Personal ID");
                    String validatePersonalID = c.readLine();
                    String isValidPersonalID = Validate.personalID(validatePersonalID);
                    currentUpdate.set(Constants.INDEX_0, isValidPersonalID);
                }
                case "2" -> {
                    System.out.println("Current First Name: " + currentUpdate.get(Constants.INDEX_1));
                    System.out.println("Enter New First Name");
                    String validateFirstName = c.readLine();
                    String isValidFirstName = Validate.firstName(validateFirstName);
                    currentUpdate.set(Constants.INDEX_1, isValidFirstName);
                }
                case "3" -> {
                    System.out.println("Current Last Name: " + currentUpdate.get(Constants.INDEX_2));
                    System.out.println("Enter New Last Name");
                    String validateLastName = c.readLine();
                    String isValidLastName = Validate.lastName(validateLastName);
                    currentUpdate.set(Constants.INDEX_2, isValidLastName);
                }
                case "4" -> {
                    System.out.println("Current Phone Number: " + currentUpdate.get(Constants.INDEX_3));
                    System.out.println("Enter New Phone Number");
                    String validatePhoneNumber = c.readLine();
                    String isValidPhoneNumber = Validate.phoneNumber(validatePhoneNumber);
                    currentUpdate.set(Constants.INDEX_3, isValidPhoneNumber);
                }
                case "5" -> {
                    System.out.println("    (Optional, to skip type '*'.)");
                    System.out.println("Current Street Address: " + currentUpdate.get(Constants.INDEX_4));
                    System.out.println("Enter New Street Address"
                            + " (e.g., Hämeenkatu)(Street Number is next.)");
                    String validateStreetAddress = c.readLine();
                    String isValidStreetAddress = Validate.streetAddress(validateStreetAddress);
                    currentUpdate.set(Constants.INDEX_4, isValidStreetAddress);
                }
                case "6" -> {
                    System.out.println("(Optional, to skip type '*'.)");
                    System.out.println("Current Street Number: " + currentUpdate.get(Constants.INDEX_5));
                    System.out.println("Enter New Street Number (Between 1 and 999)");
                    String validateStreetNumber = c.readLine();
                    String isValidStreetNumber = Validate.streetNumber(validateStreetNumber);
                    currentUpdate.set(Constants.INDEX_5, isValidStreetNumber);
                }
                case "7" -> {
                    System.out.println("(Optional, to skip type '*'.)");
                    System.out.println("Current Postcode: " + currentUpdate.get(Constants.INDEX_6));
                    System.out.println("Enter New Postcode (e.g., 33100)");
                    String validatePostcode = c.readLine();
                    String isValidPostcode = Validate.postcode(validatePostcode);
                    currentUpdate.set(Constants.INDEX_6, isValidPostcode);
                }
                case "8" -> {
                    System.out.println("(Optional, to skip type '*'.)");
                    System.out.println("Current City/Postoffice: " + currentUpdate.get(Constants.INDEX_7));
                    System.out.println("Enter New City/Postoffice (e.g., Tampere)");
                    String validatePostoffice = c.readLine();
                    String isValidPostoffice = Validate.city(validatePostoffice, currentUpdate.get(Constants.INDEX_6));
                    currentUpdate.set(Constants.INDEX_7, isValidPostoffice);
                }
                case "9" -> {
                    System.out.println("(Optional, to skip type '*'.)");
                    System.out.println("Current E-mail: " + currentUpdate.get(Constants.INDEX_8));
                    System.out.println("Enter New E-mail (e.g., jaakko.virtanen@gmail.com)");
                    String validateEmail = c.readLine();
                    String isValidEmail = Validate.email(validateEmail);
                    currentUpdate.set(Constants.INDEX_8, isValidEmail);
                }
                case ".show" -> {
                    for (String index : currentUpdate) {
                        System.out.printf("%-20s", "| " + index);
                    }
                }
                case ".save" -> {
                    System.out.println("Updating...");
                    newLine = String.join(",", currentUpdate);
                    try {
                        ArrayList<String> contactsList = new ArrayList<>();
                        try (BufferedReader readerCSV = new BufferedReader(new FileReader("Contacts.csv"))) {
                            String line;
                            while ((line = readerCSV.readLine()) != null) {
                                contactsList.add(line);
                            }
                        }

                        if (lineToUpdate >= Constants.INDEX_0 && lineToUpdate < contactsList.size()) {
                            contactsList.set(lineToUpdate, newLine);
                        } else {
                            System.out.println("Line number out of range.");
                            return;
                        }

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Contacts.csv"))) {
                            for (String index : contactsList) {
                                writer.write(index);
                                writer.newLine();
                            }
                        }
                        System.out.println("Line updated successfully.");
                    } catch (IOException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                }
                case ".help" -> {
                    Help.updateHelp();
                }
                case ".exit" -> {
                    System.out.println("Did you remember to save? (Changes are not saved automatically.)");
                    System.out.println("Continue to exit? Type 'Yes'/'No'.");
                        String confirmExit = c.readLine();
                        if (confirmExit.equalsIgnoreCase("Yes")) {
                            System.out.println("Exiting update and returning to main menu.");
                            return;
                        } else {
                            System.out.println("Returning to update menu.");
                            break;
                        }
                }
                default -> {
                    System.out.println("Invalid command.");
                }
            }
        }
    }
}
