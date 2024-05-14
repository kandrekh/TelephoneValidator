import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidation {
    private String phoneNumber;

    // Constructor
    PhoneNumberValidation(){
    }

    // Getter
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // Setter
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @param phoneNumber accepts phone number from user for validation
     * checks the number pattern if matches, converts if not throws error
     */
    public void validation( String phoneNumber){

        if(phoneNumberPatternValidation(phoneNumber)){
            numericPhoneNumber(phoneNumber);
        }else if (!phoneNumberPatternValidation(phoneNumber)){
            JOptionPane.showMessageDialog(null,"Invalid");
        }
    }

    /**
     * Validate the user input to match xxx-xxx-xxxx
     * @param phoneNumber alphanumeric phone number inputted by user
     * @return boolean if phone number pattern matches
     */
    public boolean phoneNumberPatternValidation(String phoneNumber ){

        String numberPattern = "^[A-Za-z0-9]{3}-[A-Za-z0-9]{3}-[A-Za-z]{4}$";

        Pattern pattern = Pattern.compile(numberPattern);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
    /**
     * a Gets phoneNumber and displays the numeric values of the inputted number
     * @param phoneNumber alphanumeric phone number inputted by user to be converted
     */
    public void numericPhoneNumber(String phoneNumber) {
        long phoneNumberFinal =0;
        for (int i = 0; i < phoneNumber.length(); i++){
            char ch = phoneNumber.charAt(i);
            if (Character.isLetter(ch)) {
                // pattern matching switch
                phoneNumberFinal = switch (ch) {
                    case 'A', 'B', 'C' -> phoneNumberFinal * 10 + 2;
                    case 'D', 'E', 'F' -> phoneNumberFinal * 10 + 3;
                    case 'G', 'H', 'I' -> phoneNumberFinal * 10 + 4;
                    case 'J', 'K', 'L' -> phoneNumberFinal * 10 + 5;
                    case 'M', 'N', 'O' -> phoneNumberFinal * 10 + 6;
                    case 'P', 'Q', 'R', 'S' -> phoneNumberFinal * 10 + 7;
                    case 'T', 'U', 'V'      -> phoneNumberFinal * 10 + 8;
                    case 'W', 'X', 'Y', 'Z' -> phoneNumberFinal * 10 + 9;
                    default -> phoneNumberFinal;
                };
            }
            else if (Character.isDigit(ch)) {
                phoneNumberFinal = phoneNumberFinal * 10 + Character.getNumericValue(ch);
            }
        }
        // Convert long to string
        String numericPhoneNumber = Long.toString(phoneNumberFinal);

        // Insert hyphens
        String formattedNumber = numericPhoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");

        // Display converted telephone number
        JOptionPane.showMessageDialog(null,"Inputted: "+phoneNumber + " \nConverted Telephone Number " + formattedNumber);
    }
}
