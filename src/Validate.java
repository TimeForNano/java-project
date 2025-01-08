
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Validates all the inputs before they can be saved into the text file.
 * @return Validated value off the method called.
 */
public class Validate {

    /**
     * Validates personal ID on century mark, birthdate, individual number range
     * and math created check mark.
     * @param validatePersonalID
     * @return Validated personal ID value.
     */
    public static String personalID(final String validatePersonalID) {
        Console c = System.console();
        String checkPersonalID = validatePersonalID;

        while (true) {
            // Input is the right length.
            while (checkPersonalID.length() != Constants.INDEX_11) {
                System.out.println("Personal ID length is invalid. Try again.");
                checkPersonalID = c.readLine();
            }

            // Split string to validatable parts.
            String day = checkPersonalID.substring(Constants.INDEX_0, Constants.INDEX_2);
            String month = checkPersonalID.substring(Constants.INDEX_2, Constants.INDEX_4);
            String year = checkPersonalID.substring(Constants.INDEX_4, Constants.INDEX_6);
            String century = checkPersonalID.substring(Constants.INDEX_6, Constants.INDEX_7);
            String individual = checkPersonalID.substring(Constants.INDEX_7, Constants.INDEX_10);
            String check = checkPersonalID.substring(Constants.INDEX_10, Constants.INDEX_11);

            // Checking century matches.
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
                    checkPersonalID = c.readLine();
                    continue;
                }
            }

            // Date is valid and not in the future.
            LocalDate birthDate = LocalDate.parse(makeDate);
            LocalDate dateToday = LocalDate.now();
            try {
                if (birthDate.isAfter(dateToday)) {
                    System.out.println("ID birthdate can't be in the future. Try again.");
                    checkPersonalID = c.readLine();
                    continue;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid birthdate.");
            }

            // Allowed 002-999 range.
            Integer individualNumber = Integer.valueOf(individual);
            if (individualNumber < Constants.INDEX_2 && individualNumber > Constants.INDEX_999) {
                System.out.println("Individual number isn't in the allowed 002-999 range.");
                System.out.println("Please try again.");
                checkPersonalID = c.readLine();
                continue;
            }

            // If the check mark is valid.
            Integer calculationCheck = Integer.valueOf(day + month + year + individual);
            Integer checkMark = calculationCheck % Constants.INDEX_31;
            switch (check) {
                case "0" -> {
                    if (checkMark != Constants.INDEX_0) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "1" -> {
                    if (checkMark != Constants.INDEX_1) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "2" -> {
                    if (checkMark != Constants.INDEX_2) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "3" -> {
                    if (checkMark != Constants.INDEX_3) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "4" -> {
                    if (checkMark != Constants.INDEX_4) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "5" -> {
                    if (checkMark != Constants.INDEX_5) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "6" -> {
                    if (checkMark != Constants.INDEX_6) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "7" -> {
                    if (checkMark != Constants.INDEX_7) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "8" -> {
                    if (checkMark != Constants.INDEX_8) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "9" -> {
                    if (checkMark != Constants.INDEX_9) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "A" -> {
                    if (checkMark != Constants.INDEX_10) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "B" -> {
                    if (checkMark != Constants.INDEX_11) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "C" -> {
                    if (checkMark != Constants.INDEX_12) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "D" -> {
                    if (checkMark != Constants.INDEX_13) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "E" -> {
                    if (checkMark != Constants.INDEX_14) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "F" -> {
                    if (checkMark != Constants.INDEX_15) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "H" -> {
                    if (checkMark != Constants.INDEX_16) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "J" -> {
                    if (checkMark != Constants.INDEX_17) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "K" -> {
                    if (checkMark != Constants.INDEX_18) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "L" -> {
                    if (checkMark != Constants.INDEX_19) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "M" -> {
                    if (checkMark != Constants.INDEX_20) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "N" -> {
                    if (checkMark != Constants.INDEX_21) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "P" -> {
                    if (checkMark != Constants.INDEX_22) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "R" -> {
                    if (checkMark != Constants.INDEX_23) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "S" -> {
                    if (checkMark != Constants.INDEX_24) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "T" -> {
                    if (checkMark != Constants.INDEX_25) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "U" -> {
                    if (checkMark != Constants.INDEX_26) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "V" -> {
                    if (checkMark != Constants.INDEX_27) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "W" -> {
                    if (checkMark != Constants.INDEX_28) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "X" -> {
                    if (checkMark != Constants.INDEX_29) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                case "Y" -> {
                    if (checkMark != Constants.INDEX_30) {
                        System.out.println("Check mark calculation result invalid.");
                        System.out.println("Either your last character is wrong");
                        System.out.println(" or some of the number values.");
                        checkPersonalID = c.readLine();
                        continue;
                    }
                }
                default -> {
                    System.out.println("Invalid check mark. (Last character on Personal ID.)");
                }
            }
            System.out.println("Personal ID is valid.");
            return checkPersonalID;
        }
    }

    /**
     * Validates first name to have first character uppercase and rest lowercase.
     * @param validateFirstName
     * @return Validated firs name value.
     */
    public static String firstName(final String validateFirstName) {
        Console c = System.console();
        String checkFirstName = validateFirstName;

        boolean validate;
        do {
            validate = checkFirstName.matches("^[A-ZÅÄÖ][a-zåäö]+$");
            if (!validate) {
                System.out.println("Invalid First Name. Please try again.");
                checkFirstName = c.readLine();
            }
        } while (!validate);
        return checkFirstName;
    }

    /**
     * Validates last name to have first character uppercase and rest lowercase.
     * Additionally allows ' mark to be used on certain conditions and double last names.
     * @param validateLastName
     * @return Validated last name value.
     */
    public static String lastName(final String validateLastName) {
        Console c = System.console();
        String checkLastName = validateLastName;

        boolean validate;
        do {
            validate = checkLastName.matches("^[A-ZÅÄÖ][a-zåäö]*(?:['][A-ZÅÄÖ][a-zåäö]+)?"
                    + "(?:[- ][A-ZÅÄÖ][a-zåäö]*(?:['][A-ZÅÄÖ][a-zåäö]+)?)?$");
            if (!validate) {
                System.out.println("Invalid Last Name. Please try again.");
                checkLastName = c.readLine();
            }
        } while (!validate);
        return checkLastName;
    }

    /**
     * Validates entered phonenumber format. Must start with +358.
     * Next two are also checked to match used phonenumber ranges in Finland.
     * Checked that phonenumber isn't too short or too long.
     * @param validatePhoneNumber
     * @return Validated phonenumber value.
     */
    public static String phoneNumber(final String validatePhoneNumber) {
        Console c = System.console();
        String checkPhoneNumber = validatePhoneNumber;

        boolean validate;
        do {
            validate = checkPhoneNumber.matches("^\\+358(40|41|42|43|44|45|46|50)\\d{4,10}$");
            if (checkPhoneNumber.length() < Constants.INDEX_10
                || checkPhoneNumber.length() > Constants.INDEX_16) {
                System.out.println("Phone Number is either too short or too long. Try again.");
                checkPhoneNumber = c.readLine();
            } else if (!validate) {
                System.out.println("Invalid Phone Number. Please try again.");
                checkPhoneNumber = c.readLine();
            }
        } while (!validate);
        return checkPhoneNumber;
    }

    /**
     * Validate street address to have first character uppercase and rest lowercase.
     * There is no database to check against if the street address actually exists.
     * Optional information to add.
     * @param validateStreetAddress
     * @return Validated street address value.
     */
    public static String streetAddress(final String validateStreetAddress) {
        Console c = System.console();
        String checkStreetAddress = validateStreetAddress;

        if (checkStreetAddress.equals("*")) {
            String nullValue = "Null";
            checkStreetAddress = nullValue;
            return checkStreetAddress;
        }

        boolean validate;
        do {
            validate = checkStreetAddress.matches("^[A-ZÅÄÖ]{1}[a-zåäö ]+$");
            if (!validate) {
                System.out.println("Invalid Street Address. Please try again.");
                checkStreetAddress = c.readLine();
            }
        } while (!validate);
        return checkStreetAddress;
    }

    /**
     * Validate street number to be between 1 to 999.
     * There is no database to check against if the street number actually exists.
     * Optional information to add.
     * @param validateStreetNumber
     * @return Validated street number value.
     */
    public static String streetNumber(String validateStreetNumber) {
        Console c = System.console();
        String checkStreetNumber = validateStreetNumber;

        if (checkStreetNumber.equals("*")) {
            String nullValue = "Null";
            checkStreetNumber = nullValue;
            return checkStreetNumber;
        }

        boolean validate;
        do {
            validate = checkStreetNumber.matches("^[1-9][0-9]{0,2}$");
            if (!validate) {
                System.out.println("Invalid Street Number. Please try again.");
                checkStreetNumber = c.readLine();
            }
        } while (!validate);
        return checkStreetNumber;
    }

    /**
     * Validate postcode against a csv file of Finnish postcodes.
     * @param validatePostcode
     * @return Validated postcode value.
     */
    public static String postcode(final String validatePostcode) {
        Console c = System.console();
        String checkPostcode = validatePostcode;

        if (checkPostcode.equals("*")) {
            String nullValue = "Null";
            checkPostcode = nullValue;
            return checkPostcode;
        }

        boolean validate;
        do {
            validate = checkPostcode.matches("^[0-9]{5}$");
            if (!validate) {
                System.out.println("Invalid Postcode. Please try again.");
                checkPostcode = c.readLine();
            }
            try {
                BufferedReader readerCSV;
                readerCSV = new BufferedReader(new FileReader("postcodes.csv"));
                boolean validPostcode = false;
                String line;
                while ((line = readerCSV.readLine()) != null) {
                    String[] split = line.split(",");
                    if (split[0].equals(checkPostcode)) {
                        System.out.println("Postcode: " + split[0] + " matches to " + split[1]);
                        validPostcode = true;
                        break;
                    }
                }
                if (!validPostcode) {
                    System.out.println("Postcode not found. Please try again.");
                    checkPostcode = c.readLine();
                }
                readerCSV.close();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!validate);
        return checkPostcode;
    }

    /**
     * Validate city against a csv file of Finnish postcodes and to match given postcode.
     * @param validateCity
     * @param validPostcode
     * @return Validated city value.
     */
    public static String city(final String validateCity, final String validPostcode) {
        Console c = System.console();
        String checkCity = validateCity;
        String checkPostcode = validPostcode;

        if (checkCity.equals("*")) {
            String nullValue = "Null";
            checkCity = nullValue;
            return checkCity;
        }

        boolean validate;
        do {
            validate = checkCity.matches("^[A-ZÅÄÖ]{1}[a-zåäö]+$");
            if (!validate) {
                System.out.println("Invalid City/Postoffice. Please try again.");
                checkCity = c.readLine();
            }
            try {
                BufferedReader readerCSV;
                readerCSV = new BufferedReader(new FileReader("postcodes.csv"));
                boolean validCity = false;
                String line;
                while ((line = readerCSV.readLine()) != null) {
                    String[] split = line.split(",");
                    if (split[1].equals(checkCity) && split[0].equals(checkPostcode)) {
                        System.out.println("City: " + split[1] + " matches to " + split[0]);
                        validCity = true;
                        break;
                    }
                }
                if (!validCity) {
                    System.out.println("City/Postoffice not found. Please try again.");
                    checkCity = c.readLine();
                }
                readerCSV.close();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!validate);
        return checkCity;
    }

    /**
     * Validate email address based on format rules and standards.
     * Covers most common rules for local part / username (before @)
     * and for domain name (after @).
     * @param validateEmail
     * @return Validated email value.
     */
    public static String email(final String validateEmail) {
        Console c = System.console();
        String checkEmail = validateEmail;

        if (checkEmail.equals("*")) {
            String nullValue = "Null";
            checkEmail = nullValue;
            return checkEmail;
        }

        boolean validate;
        do {
            validate = checkEmail.matches("^[A-Za-z0-9]+(?:[!#$%&'*+-/=?^_`{|}~.][a-z0-9]+)*"
                    + "@[a-z0-9]+(?:[-][a-z0-9]+)*\\.[a-z]{2,}$");
            if (!validate) {
                System.out.println("Invalid E-mail. Please try again or type '.help' for rules.");
                checkEmail = c.readLine();
                if (checkEmail.equals(".help")) {
                    Help.emailHelp();
                    checkEmail = c.readLine();
                }
            }
        } while (!validate);
        return checkEmail;
    }
}
