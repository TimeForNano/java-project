
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Simple contacts application. You can create, read, update and delete Finnish
 * contacts from a csv text file. It uses a command-line interface. Can be
 * started with "cd src/ &amp;&amp; javac *.java &amp;&amp; java ContactsApp"
 *
 * @author Mika Tuominen
 */
public class ContactsApp {

    /**
     * Used for exit where user input is integer.
     */
    public static final int COMMAND_EXIT = -1;
    /**
     * Used for opening help where user input is integer.
     */
    public static final int COMMAND_HELP = -2;

    /**
     * Initializez the file to be modified and opens the commands menu.
     *
     * @param args Not in use.
     */
    public static void main(final String[] args) {
        System.out.println("Welcome to the Contacts Application!");
        initialize();
        commands();
    }

    /**
     * Creates the Contacts.csv file. If not already found. On the first time
     * the file is created. It writes headlines for the file.
     */
    public static void initialize() {
        try {
            if (!new File("Contacts.csv").exists()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Contacts.csv"))) {
                    writer.write("Personal ID,First Name,Last Name,Phone Number,Street Address,"
                            + "Street Number,Postcode,City/Postoffice,E-mail,");
                    writer.newLine();
                }
                System.out.println("    Finished initializing the save file.");
            } else {
                System.out.println("    Save file already exists. No initialization needed.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Takes user given commands until the command is to exit. Command options:
     * <ul>
     * <li><code>.help</code> Opens more information on the type of input expected.</li>
     * <li><code>.readAll</code> Reads all lines in the file and prints them
     * into the command-line interface.</li>
     * <li><code>.readLine</code> Reads later specified line and prints it into
     * the command-line interface.</li>
     * <li><code>.create</code> Starts the process of creating a new contact information.</li>
     * <li><code>.update</code> Can modify later specified already existing lines.</li>
     * <li><code>.delete</code> Deletes later specified line.</li>
     * <li><code>.exit</code> Exits the program.</li>
     * </ul>
     */
    public static void commands() {
        Console c = System.console();

        while (true) {
            System.out.println("## Main menu ##");
            System.out.println("Command options: .help .readAll .readLine .create .update"
                    + " .delete .exit");
            String commandInput = c.readLine();

            switch (commandInput) {
                case ".help" -> {
                    System.out.println("Continuing to help.");
                    Help.showHelp();
                }
                case ".readAll" -> {
                    System.out.println("Continuing to readAll.");
                    Read.readAll();
                }
                case ".readLine" -> {
                    System.out.println("Continuing to readLine.");
                    Read.readLine();
                }
                case ".create" -> {
                    System.out.println("Continuing to create.");
                    Create.create();
                }
                case ".update" -> {
                    System.out.println("Continuing to update.");
                    Update.update();
                }
                case ".delete" -> {
                    System.out.println("Continuing to delete.");
                    Delete.delete();
                }
                case ".exit" -> {
                    System.out.print("Exiting program.");
                    return;
                }
                default -> {
                    System.out.println("Invalid command.");
                }
            }
        }
    }
}
