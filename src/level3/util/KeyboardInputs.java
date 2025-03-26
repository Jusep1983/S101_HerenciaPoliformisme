package level3.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import static level3.menuTexts.MenusTexts.*;

public class KeyboardInputs {

    /*Class to handle correct data input from the keyboard*/

    private static final Scanner SC = new Scanner(System.in);

    public static byte menu() {
        byte option;
        option = KeyboardInputs.readByteRange(MAIN_MENU, (byte) 0, (byte) 8);
        return option;
    }

    public static byte subMenuAddArticle() {
        byte option;
        option = KeyboardInputs.readByteRange(SUBMENU_ADD_ARTICLE, (byte) 0, (byte) 5);
        return option;
    }

    /**
     * This method is responsible for asking for a byte within a range,
     * checking that the data type is correct, it is within the range, and it will return a byte.
     *
     * @return byte
     */
    public static byte readByteRange(String message, byte minimum, byte maximum) {
        byte number = 0;
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                number = SC.nextByte();
                if (number < minimum || number > maximum) {
                    System.out.println("Error, el valor ha de estar entre " + minimum + " y " + maximum + ". ");
                } else {
                    correct = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error de formato.");
            }
            SC.nextLine();
        } while (!correct);
        return number;
    }

    /**
     * This method is responsible for reading a String from the keyboard, ensuring that no spaces are entered.
     *
     * @return String
     */
    public static String readANonEmptyString(String message) {
        String text = "";
        boolean correct = false;
        do {
            System.out.print(message);
            try {
                text = SC.nextLine().trim();
                if (text.isEmpty()) {
                    System.out.println("Error, no has introducido ninguna palabra.");
                } else {
                    correct = true;
                }
            } catch (Exception ex) {
                System.out.println("Error en la introducción del string.");
            }
        } while (!correct);
        return text;
    }

    /**
     * This method receives a String, evaluates and checks that it meets the Spanish DNI format,
     * and returns the DNI as a String in the correct format.
     *
     * @return String
     */
    public static String readFormatDNI(String message) {
        String dniStr;
            System.out.println("Ejemplos DNI correctos: 12345678Z 87654321X 11223344B 74246722P 55667788Z 39383352S 69967049Z");
        do {
            dniStr = KeyboardInputs.readANonEmptyString(message);
            dniStr = dniStr.toUpperCase().trim().replaceAll("[^A-Z0-9]", "");
        } while (!isValidDniFormat(dniStr));
        return dniStr;
    }

    private static boolean isValidDniFormat(String dniStr) {
        if (!isValidLengthDniFormat(dniStr)) return false;
        if (!isValidNumbersDniFormat(dniStr)) return false;
        if (!isValidLetterDniFormat(dniStr)) return false;
        return true;
    }

    private static boolean isValidLengthDniFormat(String dniStr) {
        boolean isValid = false;
        if (dniStr.length() != 9) {
            System.out.println("Un DNI debe tener 9 caracteres: 8 números y 1 letra.");
        } else {
            isValid = true;
        }
        return isValid;
    }

    private static boolean isValidNumbersDniFormat(String dniStr) {
        boolean isValid = false;
        String numbers = dniStr.substring(0, 8);
        if (!numbers.chars().allMatch(Character::isDigit)) {
            System.out.println("Un DNI debe tener 9 caracteres: 8 números y 1 letra.");
        } else {
            isValid = true;
        }
        return isValid;
    }

    private static boolean isValidLetterDniFormat(String dniStr) {
        boolean isValid = false;
        String numbers = dniStr.substring(0, 8);
        char letter = dniStr.charAt(8);
        if (getExpectedDniLetter(Integer.parseInt(numbers)) != letter) {
            System.out.println("La letra del DNI introducido es incorrecta.");
        } else {
            isValid = true;
        }
        return isValid;
    }

    private static char getExpectedDniLetter(int dniNumber) {
        final char[] lettersDni = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
                'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return lettersDni[dniNumber % 23];
    }


}
