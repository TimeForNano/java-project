
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Validate {

    public static String PersonalID(String validatePersonalID) {
        Console c = System.console();

        while (true) {
            // Input is the right length
            while (validatePersonalID.length() != 11) {
                System.out.println("Personal ID length is invalid. Try again.");
                validatePersonalID = c.readLine();
            }
            // Split string to validatable parts

            String day = validatePersonalID.substring(0, 2);
            String month = validatePersonalID.substring(2, 4);
            String year = validatePersonalID.substring(4, 6);
            String century = validatePersonalID.substring(6, 7);
            String individual = validatePersonalID.substring(7, 10);
            String check = validatePersonalID.substring(10, 11);

            // Checking century matches
            String makeDate;
            switch (century) {
                case "+" -> {
                    makeDate = "18" + year + "-" + month + "-" + day;
                }
                case "-", "Y", "X", "W", "V", "U" -> {
                    makeDate = "19" + year + "-" + month + "-" + day;
                }
                case "A", "B", "C", "D", "E", "F" -> {
                    makeDate = "20" + year + "-" + month + "-" + day;
                }
                default -> {
                    System.out.println("The seventh character indicating the century is wrong.");
                    System.out.println("Please try again.");
                    validatePersonalID = c.readLine();
                    continue;
                }
            }

            // Date is valid and not in the future
            LocalDate birthDate = LocalDate.parse(makeDate);
            LocalDate dateToday = LocalDate.now();
            if (birthDate.isAfter(dateToday)) {
                System.out.println("ID birth date can't be in the future. Try again.");
                validatePersonalID = c.readLine();
                continue;
            }

            // Allowed 002-999 range
            Integer individualNumber = Integer.parseInt(individual);
            if (individualNumber < 2 && individualNumber > 999) {
                System.out.println("Individual number isn't in the allowed 002-999 range. Try again.");
                validatePersonalID = c.readLine();
                continue;
            }

            // If the check mark is valid
            Integer calculationCheck = Integer.parseInt(day + month + year + individual);
            Integer checkMark = calculationCheck % 31;

            switch (check) {
                case "0" -> {
                    if (checkMark != 0) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "1" -> {
                    if (checkMark != 1) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "2" -> {
                    if (checkMark != 2) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "3" -> {
                    if (checkMark != 3) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "4" -> {
                    if (checkMark != 4) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "5" -> {
                    if (checkMark != 5) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "6" -> {
                    if (checkMark != 6) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "7" -> {
                    if (checkMark != 7) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "8" -> {
                    if (checkMark != 8) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "9" -> {
                    if (checkMark != 9) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "A" -> {
                    if (checkMark != 10) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "B" -> {
                    if (checkMark != 11) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "C" -> {
                    if (checkMark != 12) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "D" -> {
                    if (checkMark != 13) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "E" -> {
                    if (checkMark != 14) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "F" -> {
                    if (checkMark != 15) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "H" -> {
                    if (checkMark != 16) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "J" -> {
                    if (checkMark != 17) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "K" -> {
                    if (checkMark != 18) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "L" -> {
                    if (checkMark != 19) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "M" -> {
                    if (checkMark != 20) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "N" -> {
                    if (checkMark != 21) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "P" -> {
                    if (checkMark != 22) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "R" -> {
                    if (checkMark != 23) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "S" -> {
                    if (checkMark != 24) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "T" -> {
                    if (checkMark != 25) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "U" -> {
                    if (checkMark != 26) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "V" -> {
                    if (checkMark != 27) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "W" -> {
                    if (checkMark != 28) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "X" -> {
                    if (checkMark != 29) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
                case "Y" -> {
                    if (checkMark != 30) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong or some of the number values.");
                        validatePersonalID = c.readLine();
                        continue;
                    }
                }
            }
            System.out.println("Personal ID is valid.");
            return validatePersonalID;
        }
    }

    public static String FirstName(String validateFirstName) {
        Console c = System.console();

        boolean validate;
        do {
            validate = validateFirstName.matches("^[A-ZÅÄÖ][a-zåäö]+$");
            if (!validate) {
                System.out.println("Invalid First Name. Please try again.");
                validateFirstName = c.readLine();
            }
        } while (!validate);
        return validateFirstName;
    }

    public static String LastName(String validateLastName) {
        Console c = System.console();

        boolean validate;
        do {
            validate = validateLastName.matches("^[A-ZÅÄÖ][a-zåäö]*(?:['][A-ZÅÄÖ][a-zåäö]+)?"
                    + "(?:[- ][A-ZÅÄÖ][a-zåäö]*(?:['][A-ZÅÄÖ][a-zåäö]+)?)?$");
            if (!validate) {
                System.out.println("Invalid Last Name. Please try again.");
                validateLastName = c.readLine();
            }
        } while (!validate);
        return validateLastName;
    }

    public static String PhoneNumber(String validatePhoneNumber) {
        Console c = System.console();

        boolean validate;
        do {
            validate = validatePhoneNumber.matches("^\\+358(40|41|42|43|44|45|46|50)\\d{4,10}$");
            if (validatePhoneNumber.length() < 10 || validatePhoneNumber.length() > 16) {
                System.out.println("Phone Number is either too short or too long. Try again.");
                validatePhoneNumber = c.readLine();
            } else if (!validate) {
                System.out.println("Invalid Phone Number. Please try again.");
                validatePhoneNumber = c.readLine();
            }
        } while (!validate);
        return validatePhoneNumber;
    }

    public static String StreetAddress(String validateStreetAddress) {
        Console c = System.console();

        if (validateStreetAddress.equals("*")) {
            String Null = "Null";
            validateStreetAddress = Null;
            return validateStreetAddress;
        }

        boolean validate;
        do {
            validate = validateStreetAddress.matches("^[A-ZÅÄÖ]{1}[a-zåäö ]+$");
            if (!validate) {
                System.out.println("Invalid Street Address. Please try again.");
                validateStreetAddress = c.readLine();
            }
        } while (!validate);
        return validateStreetAddress;
    }

    public static String StreetNumber(String validateStreetNumber) {
        Console c = System.console();

        if (validateStreetNumber.equals("*")) {
            String Null = "Null";
            validateStreetNumber = Null;
            return validateStreetNumber;
        }

        boolean validate;
        do {
            validate = validateStreetNumber.matches("^[1-9][0-9]{0,2}$");
            if (!validate) {
                System.out.println("Invalid Street Number. Please try again.");
                validateStreetNumber = c.readLine();
            }
        } while (!validate);
        return validateStreetNumber;
    }

    public static String Postcode(String validatePostcode) {
        Console c = System.console();

        if (validatePostcode.equals("*")) {
            String Null = "Null";
            validatePostcode = Null;
            return validatePostcode;
        }

        boolean validate;
        do {
            validate = validatePostcode.matches("^[0-9]{5}$");
            if (!validate) {
                System.out.println("Invalid Postcode. Please try again.");
                validatePostcode = c.readLine();
            }
            try {
                BufferedReader readerCSV;
                readerCSV = new BufferedReader(new FileReader("postcodes.csv"));
                boolean validPostcode = false;
                String line;
                while ((line = readerCSV.readLine()) != null) {
                    String[] split = line.split(",");
                    if (split[0].equals(validatePostcode)) {
                        System.out.println("Postcode: " + split[0] + " matches to " + split[1]);
                        validPostcode = true;
                        break;
                    }
                }

                if (!validPostcode) {
                    System.out.println("Postcode not found. Please try again.");
                    validatePostcode = c.readLine();
                }
                readerCSV.close();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!validate);

        return validatePostcode;
    }

    public static String City(String validateCity, String validPostcode) {
        Console c = System.console();

        if (validateCity.equals("*")) {
            String Null = "Null";
            validateCity = Null;
            return validateCity;
        }

        boolean validate;
        do {
            validate = validateCity.matches("^[A-ZÅÄÖ]{1}[a-zåäö]+$");
            if (!validate) {
                System.out.println("Invalid City/Postoffice. Please try again.");
                validateCity = c.readLine();
            }
            try {
                BufferedReader readerCSV;
                readerCSV = new BufferedReader(new FileReader("postcodes.csv"));
                boolean validCity = false;
                String line;
                while ((line = readerCSV.readLine()) != null) {
                    String[] split = line.split(",");
                    if (split[1].equals(validateCity) && split[0].equals(validPostcode)) {
                        System.out.println("City: " + split[1] + " matches to " + split[0]);
                        validCity = true;
                        break;
                    }
                }

                if (!validCity) {
                    System.out.println("City/Postoffice not found. Please try again.");
                    validateCity = c.readLine();
                }
                readerCSV.close();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!validate);

        return validateCity;
    }

    public static String Email(String validateEmail) {
        Console c = System.console();

        if (validateEmail.equals("*")) {
            String Null = "Null";
            validateEmail = Null;
            return validateEmail;
        }

        boolean validate;
        do {
            validate = validateEmail.matches("^[A-Za-z0-9]+(?:[!#$%&'*+-/=?^_`{|}~.][a-z0-9]+)*@[a-z0-9]+(?:[-][a-z0-9]+)*\\.[a-z]{2,}$");
            if (!validate) {
                System.out.println("Invalid E-mail. Please try again or type '.help' for rules.");
                validateEmail = c.readLine();
                if (validateEmail.equals(".help")) {
                    Help.emailHelp();
                    validateEmail = c.readLine();
                }
            }
        } while (!validate);
        return validateEmail;
    }
}
