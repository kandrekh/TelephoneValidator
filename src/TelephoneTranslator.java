import javax.swing.*;

/**
 * Program: Alphanumeric telephone number translator
 * Author: K-Andre Harris
 * Date Created: April 10, 2024,
 * Date Modified: May 13, 2024

 * Course: CIT 111-Z02 Intro to Prog: Java
 * Spring 2024
 */

public class TelephoneTranslator {
    public static void main(String[] args){
      // Call getNumber() Method which calls the getNumber() method
      getNumber();
    }
    public static void getNumber(){
        String phoneNumberInput;
        phoneNumberInput =  JOptionPane.showInputDialog("Enter the 10 digit alphanumeric phone number in format XXX-XXX-XXXX ").toUpperCase();
        PhoneNumberValidation validateNumber = new PhoneNumberValidation();
        validateNumber.validation(phoneNumberInput);
    }
}
