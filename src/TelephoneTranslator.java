import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Program: Alphnumeric telelphone number translator
 * Author: K-Andre Harris
 * Date Created: April 10, 2024
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
            numuericPhoneNumber(phoneNumber);
        }else if (!phoneNumberPatternValidation(phoneNumber)){
            JOptionPane.showMessageDialog(null,"Invalid");
        }
    }
    /**
     * Validate the user input to match xxx-xxx-xxxx
     * @param phoneNumber
     * @return boolean if phone number pattern matches
     */
    public static boolean phoneNumberPatternValidation(String phoneNumber ){

        String numberPattern = "^[A-Za-z0-9]{3}-[A-Za-z0-9]{3}-[A-Za-z]{4}$";

        Pattern pattern = Pattern.compile(numberPattern);
        Matcher matcher = pattern.matcher(phoneNumber);

        return ((Matcher) matcher).matches();
    }
    /**
     * a Gets phoneNumber and displays the numeric values of the inputted number
     * @param phoneNumber
     */
    public  static void numuericPhoneNumber(String phoneNumber) {
        long phoneNumberFinal =0;
        for (int i = 0; i < phoneNumber.length(); i++){
            char ch = phoneNumber.charAt(i);
            if (Character.isLetter(ch)) {
                switch (ch) {
                    case 'A':
                    case 'B':
                    case 'C':
                        phoneNumberFinal = phoneNumberFinal * 10 + 2;
                        break;
                    case 'D':
                    case 'E':
                    case 'F':
                        phoneNumberFinal = phoneNumberFinal * 10 + 3;
                        break;
                    case 'G':
                    case 'H':
                    case 'I':
                        phoneNumberFinal = phoneNumberFinal * 10 + 4;
                        break;
                    case 'J':
                    case 'K':
                    case 'L':
                        phoneNumberFinal = phoneNumberFinal * 10 + 5;
                        break;
                    case 'M':
                    case 'N':
                    case 'O':
                        phoneNumberFinal = phoneNumberFinal * 10 + 6;
                        break;
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                        phoneNumberFinal = phoneNumberFinal * 10 + 7;
                        break;
                    case 'T':
                    case 'U':
                    case 'V':
                        phoneNumberFinal = phoneNumberFinal * 10 + 8;
                        break;
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                        phoneNumberFinal = phoneNumberFinal * 10 + 9;
                        break;
                }
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
