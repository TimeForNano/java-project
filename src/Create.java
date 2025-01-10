
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles the creation of new contact informations.
 */
public class Create {

    /**
     * Asks for user inputs for different fields to be filled.
     * Forwards the information to <code>Validate</code> for validation.
     * Returned values are saved into an <code>ArrayList</code> and in the end
     *  written to a new line in the text file.
     */
    public static void create() {
        Console c = System.console();

        System.out.println();
        System.out.println("All Address fields and E-mail are optional.");
        ArrayList<String> newContact = new ArrayList<>();

        System.out.println();
        System.out.println("    (Type .help for format details or .exit to exit.)");
        System.out.println("Enter Personal ID (e.g., 131052-308T)");
        String validatePersonalID = c.readLine();
        String isValidPersonalID = Validate.personalID(validatePersonalID);
        newContact.add(isValidPersonalID);

        System.out.println();
        System.out.println("    (Type .help for format details.)");
        System.out.println("Enter First Name (e.g., Jaakko)");
        String validateFirstName = c.readLine();
        String isValidFirstName = Validate.firstName(validateFirstName);
        newContact.add(isValidFirstName);

        System.out.println();
        System.out.println("    (Type .help for format details.)");
        System.out.println("Enter Last Name (e.g., Virtanen)");
        String validateLastName = c.readLine();
        String isValidLastName = Validate.lastName(validateLastName);
        newContact.add(isValidLastName);

        System.out.println();
        System.out.println("    (Type .help for format details.)");
        System.out.println("Enter Phone Number (+358 and 6 to 12 digits)");
        String validatePhoneNumber = c.readLine();
        String isValidPhoneNumber = Validate.phoneNumber(validatePhoneNumber);
        newContact.add(isValidPhoneNumber);

        System.out.println();
        System.out.println("    (Type .help for format details.)");
        System.out.println("    (Optional, to skip type '*'.)");
        System.out.println("Enter Street Address (e.g., Hämeenkatu)(Street Number is next.)");
        String validateStreetAddress = c.readLine();
        String isValidStreetAddress = Validate.streetAddress(validateStreetAddress);
        newContact.add(isValidStreetAddress);

        System.out.println();
        System.out.println("    (Type .help for format details.)");
        System.out.println("    (Optional, to skip type '*'.)");
        System.out.println("Enter Street Number (Between 1 and 999)");
        String validateStreetNumber = c.readLine();
        String isValidStreetNumber = Validate.streetNumber(validateStreetNumber);
        newContact.add(isValidStreetNumber);

        System.out.println();
        System.out.println("    (Type .help for format details.)");
        System.out.println("    (Optional, to skip type '*'.)");
        System.out.println("Enter Postcode (e.g., 33100)");
        String validatePostcode = c.readLine();
        String isValidPostcode = Validate.postcode(validatePostcode);
        newContact.add(isValidPostcode);

        System.out.println();
        System.out.println("    (Type .help for format details.)");
        System.out.println("    (Optional, to skip type '*'.)");
        System.out.println("Enter City/Postoffice (e.g., Tampere)");
        String validatePostoffice = c.readLine();
        String isValidPostoffice = Validate.city(validatePostoffice, isValidPostcode);
        newContact.add(isValidPostoffice);

        System.out.println();
        System.out.println("    (Type .help for format details.)");
        System.out.println("    (Optional, to skip type '*'.)");
        System.out.println("Enter E-mail (e.g., jaakko.virtanen@gmail.com)");
        String validateEmail = c.readLine();
        String isValidEmail = Validate.email(validateEmail);
        newContact.add(isValidEmail);

        System.out.println();
        System.out.println("Adding a new contact information: " + newContact);
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Contacts.csv", true))) {
                for (String index : newContact) {
                    writer.write(index + ",");
                }   writer.newLine();
            }
            System.out.println("Finished adding a new contact information.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
