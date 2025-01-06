
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

        System.out.println("All Address fields and E-mail are optional.");
        ArrayList<String> newContact = new ArrayList<>();

        System.out.println("Enter Personal ID (e.g., 131052-308T)");
        String validatePersonalID = c.readLine();
        String isValidPersonalID = Validate.PersonalID(validatePersonalID);
        newContact.add(isValidPersonalID);

        System.out.println("Enter First Name (e.g., Jaakko");
        String validateFirstName = c.readLine();
        String isValidFirstName = Validate.FirstName(validateFirstName);
        newContact.add(isValidFirstName);

        System.out.println("Enter Last Name (e.g., Virtanen");
        String validateLastName = c.readLine();
        String isValidLastName = Validate.LastName(validateLastName);
        newContact.add(isValidLastName);

        System.out.println("Enter Phone Number (+358 and 6 to 12 digits)");
        String validatePhoneNumber = c.readLine();
        String isValidPhoneNumber = Validate.PhoneNumber(validatePhoneNumber);
        newContact.add(isValidPhoneNumber);

        System.out.println("(Optional, to skip type '*'.)");
        System.out.println("Enter Street Address (e.g., Hämeenkatu)(Street Number is next.)");
        String validateStreetAddress = c.readLine();
        String isValidStreetAddress = Validate.StreetAddress(validateStreetAddress);
        newContact.add(isValidStreetAddress);

        System.out.println("(Optional, to skip type '*'.)");
        System.out.println("Enter Street Number");
        String validateStreetNumber = c.readLine();
        String isValidStreetNumber = Validate.StreetNumber(validateStreetNumber);
        newContact.add(isValidStreetNumber);

        System.out.println("(Optional, to skip type '*'.)");
        System.out.println("Enter Postcode (e.g., 33100)");
        String validatePostcode = c.readLine();
        String isValidPostcode = Validate.Postcode(validatePostcode);
        newContact.add(isValidPostcode);

        System.out.println("(Optional, to skip type '*'.)");
        System.out.println("Enter City/Postoffice (e.g., Tampere");
        String validatePostoffice = c.readLine();
        String isValidPostoffice = Validate.City(validatePostoffice, isValidPostcode);
        newContact.add(isValidPostoffice);

        System.out.println("(Optional, to skip type '*'.)");
        System.out.println("Enter E-mail (e.g., jaakko.virtanen@gmail.com)");
        String validateEmail = c.readLine();
        String isValidEmail = Validate.Email(validateEmail);
        newContact.add(isValidEmail);

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
