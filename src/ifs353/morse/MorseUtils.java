package ifs353.morse;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Provides static utility fields and methods for encoding and decoding text
 * using the Morse Code.
 *
 * @author jeanty
 */
public class MorseUtils {

    /**
     * The array of chars that are represented by the codes in the Morse Code
     * alphabet. The chars run from A to Z plus the numerals 0 to 9.
     */
    public static final char[] MORSE_ALPHABET = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z'
    };

    /**
     * The array of Morse Codes used to encode and decode messages. The codes
     * are the official Morse codes from A to Z including the numerals 0 to 9.
     */
    public static final String[] MORSE_CODE = {"-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
        "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.."
    };

    /**
     * Encodes a message using the MorseUtils.MORSE_CODE array.
     *
     * @param message the text to be encoded.
     * @return a encoded string.
     */
    public static String encode(String message) {
        int pos = 0;
        String uppercaseMessage = (message.toUpperCase());
        String encodedMessage = "";
        for (int j = 0; j < message.length(); j++) {
            Arrays.sort(MORSE_ALPHABET);
            pos = Arrays.binarySearch(MORSE_ALPHABET, uppercaseMessage.charAt(j));
            if (pos >= 0) {
                encodedMessage += MORSE_CODE[pos] + " ";
            }
            if (message.charAt(j) == ' ') {
                encodedMessage += "  ";
            }
        }
        return encodedMessage;
    }

    /**
     * Decodes a message using the MorseUtils.MORSE_ALPHABET array.
     *
     * @param message the text to be decoded.
     * @return a decoded string.
     */
    public static String decode(String message) {
        String[] wordArr = message.split("   ");
        int pos = 0;
        String decodedMessage = "";

        ArrayList<String> stringList = new ArrayList<>();
        for (String s : MORSE_CODE) {
            stringList.add(s);
        }

        for (int i = 0; i < wordArr.length; i++) {
            String[] charArr = wordArr[i].split(" ");
            for (int j = 0; j < charArr.length; j++) {
                pos = stringList.indexOf(charArr[j]);
                if (pos >= 0) {
                    decodedMessage += MORSE_ALPHABET[pos];
                }
                if ((j + 1) == charArr.length && pos >= 0) {
                    decodedMessage += " ";
                }
            }
        }
        return decodedMessage;
    }
}
