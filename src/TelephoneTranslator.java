import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Program: Alphanumeric telephone number translator
 * Author: K-Andre Harris
 * Date Created: April 10, 2024,
 * Date Modified: May 10, 2024

 * Course: CIT 111-Z02 Intro to Prog: Java
 * Spring 2024
 */

public class TelephoneTranslator {

    public static void main(String[] args){
//    Call getNumber Method
      validation();
    }

    /**
     * @return alphaNumericNumber initial number from user
     */
    public static String getNumber(){
        String phoneNumberInput;
        phoneNumberInput =  JOptionPane.showInputDialog("Enter the 10 digit phone number in format XXX-XXX-XXXX ").toUpperCase();
        return phoneNumberInput;
    }

    public static void validation(){
        String phoneNumber = getNumber();
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
    public static boolean phoneNumberPatternValidation(String phoneNumber ){

        String numberPattern = "^[A-Za-z0-9]{3}-[A-Za-z0-9]{3}-[A-Za-z]{4}$";

        Pattern pattern = Pattern.compile(numberPattern);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
    /**
     * a Gets phoneNumber and displays the numeric values of the inputted number
     * @param phoneNumber alphanumeric phone number inputted by user to be converted
     */
    public  static void numericPhoneNumber(String phoneNumber) {
        long phoneNumberFinal =0;
        for (int i = 0; i < phoneNumber.length(); i++){
            char ch = phoneNumber.charAt(i);
            if (Character.isLetter(ch)) {
                phoneNumberFinal = switch (ch) {
                    case 'A', 'B', 'C' -> phoneNumberFinal * 10 + 2;
                    case 'D', 'E', 'F' -> phoneNumberFinal * 10 + 3;
                    case 'G', 'H', 'I' -> phoneNumberFinal * 10 + 4;
                    case 'J', 'K', 'L' -> phoneNumberFinal * 10 + 5;
                    case 'M', 'N', 'O' -> phoneNumberFinal * 10 + 6;
                    case 'P', 'Q', 'R', 'S' -> phoneNumberFinal * 10 + 7;
                    case 'T', 'U', 'V' -> phoneNumberFinal * 10 + 8;
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

        // Insert hyphens at the right positions
        String formattedNumber = numericPhoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");

        // Display converted telephone number
        JOptionPane.showMessageDialog(null,"Inputted: "+phoneNumber + " \nConverted Telephone Number " + formattedNumber);
    }
}
