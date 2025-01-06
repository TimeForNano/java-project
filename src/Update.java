
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Allows updating any value in the csv text file.
 */
public class Update {

    /**
     * User is prompted to give a line number that they want to update.
     * Line number is first validated to be 0 or higher and found in the text file.
     * If valid. User is asked which of the 9 values they want to update.
     * User can keep updating values until they <code>.exit</code>
     * However changes are not saved with out <code>.save</code>
     * Which proceeds to update said line to the text file.
     */
    public static void update() {
        Console c = System.console();

        int lineToUpdate;
        while (true) {
            System.out.println("(To exit type '-1' and for help type '-2'.)");
            System.out.println("What line number you want to update?");
            try {
                lineToUpdate = Integer.parseInt(c.readLine());
                if (lineToUpdate == ContactsApp.COMMAND_EXIT) {
                    break;
                } else if (lineToUpdate == ContactsApp.COMMAND_HELP) {
                    Help.updateHelp();
                } else if (lineToUpdate < 0) {
                    System.out.println("Number needs to be 0 or higher.");
                }
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        String currentLine = null;
        System.out.print("Current line: ");
        try {
            BufferedReader readerLine = new BufferedReader(new FileReader("Contacts.csv"));

            int currentLineIndex = 0;
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

            readerLine.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        if (currentLine != null) {
            ArrayList<String> currentUpdate = new ArrayList<String>();
            String[] split = currentLine.split(",");
            for (String index : split) {
                currentUpdate.add(index);
            }
            String newLine;

            while (true) {
                System.out.println("Enter the field number you wanna update.To save type '.save'. To exit update '.exit'. Or type '.help'.");
                System.out.print("1.Personal ID 2.First Name 3.Last Name 4.Phone Number 5.Street Address");
                System.out.println(" 6.Street Number 7.Postcode 8.City/Postoffice 9.E-mail");
                String commandInput = c.readLine();

                switch (commandInput) {
                    case "1" -> {
                        System.out.println("Current Personal ID: " + currentUpdate.get(0));
                        System.out.println("Enter New Personal ID");
                        String validatePersonalID = c.readLine();
                        String isValidPersonalID = Validate.PersonalID(validatePersonalID);
                        currentUpdate.set(0, isValidPersonalID);
                    }
                    case "2" -> {
                        System.out.println("Current First Name: " + currentUpdate.get(1));
                        System.out.println("Enter First Name");
                        String validateFirstName = c.readLine();
                        String isValidFirstName = Validate.FirstName(validateFirstName);
                        currentUpdate.set(1, isValidFirstName);
                    }
                    case "3" -> {
                        System.out.println("Current Last Name: " + currentUpdate.get(2));
                        System.out.println("Enter Last Name");
                        String validateLastName = c.readLine();
                        String isValidLastName = Validate.LastName(validateLastName);
                        currentUpdate.set(2, isValidLastName);
                    }
                    case "4" -> {
                        System.out.println("Current Phone Number: " + currentUpdate.get(3));
                        System.out.println("Enter Phone Number (+358 and 9 digits)");
                        String validatePhoneNumber = c.readLine();
                        String isValidPhoneNumber = Validate.PhoneNumber(validatePhoneNumber);
                        currentUpdate.set(3, isValidPhoneNumber);
                    }
                    case "5" -> {
                        System.out.println("(Optional, to skip type '*'.)");
                        System.out.println("Current Street Address: " + currentUpdate.get(4));
                        System.out.println("Enter Street Address (Street Number is after this)");
                        String validateStreetAddress = c.readLine();
                        String isValidStreetAddress = Validate.StreetAddress(validateStreetAddress);
                        currentUpdate.set(4, isValidStreetAddress);
                    }
                    case "6" -> {
                        System.out.println("(Optional, to skip type '*'.)");
                        System.out.println("Current Street Number: " + currentUpdate.get(5));
                        System.out.println("Enter Street Number");
                        String validateStreetNumber = c.readLine();
                        String isValidStreetNumber = Validate.StreetNumber(validateStreetNumber);
                        currentUpdate.set(5, isValidStreetNumber);
                    }
                    case "7" -> {
                        System.out.println("(Optional, to skip type '*'.)");
                        System.out.println("Current Postcode: " + currentUpdate.get(6));
                        System.out.println("Enter Postcode (5 digits)");
                        String validatePostcode = c.readLine();
                        String isValidPostcode = Validate.Postcode(validatePostcode);
                        currentUpdate.set(6, isValidPostcode);
                    }
                    case "8" -> {
                        System.out.println("(Optional, to skip type '*'.)");
                        System.out.println("Current City/Postoffice: " + currentUpdate.get(7));
                        System.out.println("Enter City/Postoffice");
                        String validatePostoffice = c.readLine();
                        String isValidPostoffice = Validate.City(validatePostoffice, currentUpdate.get(6));
                        currentUpdate.set(7, isValidPostoffice);
                    }
                    case "9" -> {
                        System.out.println("(Optional, to skip type '*'.)");
                        System.out.println("Current E-mail: " + currentUpdate.get(8));
                        System.out.println("Enter E-mail");
                        String validateEmail = c.readLine();
                        String isValidEmail = Validate.Email(validateEmail);
                        currentUpdate.set(8, isValidEmail);
                    }
                    case ".show" -> {
                        System.out.println(currentUpdate);
                        for (String Index : currentUpdate) {
                            System.out.printf("%-20s", "| " + Index);
                        }
                        System.out.println();
                    }
                    case ".save" -> {
                        System.out.println("Updating...");
                        newLine = String.join(",", currentUpdate);
                        try {
                            ArrayList<String> contactsList = new ArrayList<String>();
                            BufferedReader readerCSV = new BufferedReader(new FileReader("Contacts.csv"));
                            String line;
                            while ((line = readerCSV.readLine()) != null) {
                                contactsList.add(line);
                            }
                            readerCSV.close();

                            if (lineToUpdate >= 0 && lineToUpdate < contactsList.size()) {
                                contactsList.set(lineToUpdate, newLine);
                            } else {
                                System.out.println("Line number out of range.");
                                return;
                            }

                            BufferedWriter writer = new BufferedWriter(new FileWriter("Contacts.csv"));
                            for (String Index : contactsList) {
                                writer.write(Index);
                                writer.newLine();
                            }
                            writer.close();
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
                        System.out.println("Exiting update.");
                        return;
                    }
                    default -> {
                        System.out.println("Invalid command.");
                    }
                }
            }
        }
    }
}
