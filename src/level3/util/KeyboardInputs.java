package level3.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import static level3.menu.MenusTexts.*;
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
     * @param message
     * @param maximum
     * @param minimum
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
     * @param message
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
     * @param message
     * @return String
     */
    public static String readFormatDNI2(String message) {
        String dniStr = "", numbers = "";
        char letter = ' ', correctChar = ' ';
        int dniNumber = 0;
        boolean correct = false;
        ArrayList<Character> lettersDni = new ArrayList<>(Arrays.asList('T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P',
                'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'));
        do {
            System.out.print(message);
            try {
                dniStr = SC.nextLine().toUpperCase().trim().replaceAll("[^A-Z0-9]", "");
                // Validate length and basic format
                if (dniStr.length() == 9) {
                    numbers = dniStr.substring(0, 8);
                    letter = dniStr.charAt(8);
                    // Verify that the first 8 positions are numbers
                    if (numbers.chars().allMatch(Character::isDigit)) {
                        // Calculate the expected letter
                        dniNumber = Integer.parseInt(numbers);
                        correctChar = lettersDni.get(dniNumber % 23);
                        // Compare the entered letter with the calculated one
                        if (correctChar == letter) {
                            correct = true;
                        } else {
                            System.out.println("La letra del DNI introducido es incorrecta.");
                        }
                    } else {
                        System.out.println("Las primeras 8 posiciones del DNI deben ser números.");
                    }
                } else {
                    System.out.println("Un DNI debe tener 9 caracteres: 8 números y 1 letra.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error en el formato del DNI. Asegúrate de que sea válido.");
            }
        } while (!correct);
        return dniStr;
    }

}
