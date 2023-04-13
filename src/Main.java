import javax.swing.*;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int length = Integer.parseInt(JOptionPane.showInputDialog("Input length of password:"));
        String[] typeOptions = {"Letters and Numbers", "Letters, Numbers and Specials"};
        int type = JOptionPane.showOptionDialog(null, "Choose Type:", "Type", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, typeOptions, 0);
        boolean specials;
        specials = type == 0;

        JOptionPane.showMessageDialog(null, generate(length, specials));
    }

    public static String generate(int length, boolean specials) {
        String returnString = "";
        for (int i = 0; i < length; i++) {
            //Math.random()*(max-min+1)+min;
            double typeOfCharSelector = Math.random();
            Random r = new Random();
            String randomChar = "";
            if (specials) {
                if (typeOfCharSelector < 0.33) {
                    //number
                    randomChar += r.nextInt(9);
                } else if (typeOfCharSelector < 0.66) {
                    //small letter
                    randomChar += (char) (r.nextInt(26) + 'a');
                } else {
                    //big letter
                    randomChar += (char) (r.nextInt(26) + 'A');
                }
                System.out.println("test");
            } else {
                if (typeOfCharSelector < 0.25) {
                    //number
                    randomChar += r.nextInt(9);
                } else if (typeOfCharSelector < 0.5) {
                    //small letter
                    randomChar += (char) (r.nextInt(26) + 'a');
                } else if (typeOfCharSelector < 0.75) {
                    //big letter
                    randomChar += (char) (r.nextInt(26) + 'A');
                } else {
                    Random specialIndex = new Random();
                    char[] specialsArray = {'?', '!', '%', '$', '&'};
                    randomChar += specialsArray[specialIndex.nextInt(5)];
                }
            }

            returnString = returnString + randomChar;
        }
        return returnString;
    }
}