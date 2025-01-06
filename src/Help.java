
public class Help {

    public static void showHelp() {
        // Check nmap or similar .help /help format on how to structure guide wisely
        // By typing a command while in help. Would show even more detail about how to use.
        // Commands would be written in the bottom of each one. So you can just go to the next one.
        // Typing .exit would get off the help portal.

        System.out.println("| Contacts Application Guide |");
        System.out.println("Available commands and how to use them.");
        System.out.println("You can always return to this with .help");
        System.out.println("");
        System.out.println("| .readAll |");
        System.out.println("Reads all rows in the file.");
        System.out.println("");
        System.out.println("| .readLine |");
        System.out.println("Example format '10'");
        System.out.println("");
        System.out.println("| .create |");
        System.out.println("Example format 'Personal ID,First Name,Last Name,Phone Number,Street Address,Postcode,City/Postoffice,E-mail'");
        System.out.println("Example format '131052-308T, Jack, Smith, +3584023423, Hämeenkatu 1, 33100, Tampere, jack.smith@gmail.com'");
        System.out.println("");
        System.out.println("| .update |");
        System.out.println("Example format 'row 10, n, n, n, n, Hämeenkatu 12, n, n, jack.smith@hotmail.com'");
        System.out.println("");
        System.out.println("| .delete |");
        System.out.println("Example format 'row 10'");
        System.out.println("");
    }

    public static void emailHelp() {
        System.out.println("Email rules text placeholder.");
        System.out.println("Enter E-mail");
    }

    public static void updateHelp() {
        System.out.println("Email rules text placeholder.");
        System.out.println("Enter E-mail");
    }

    public static void deleteHelp() {
        
    }
}
