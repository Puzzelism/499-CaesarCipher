// Baillie Stang
// 2022

import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import org.junit.Test;

public class Caesar {

    // alphabet for character matching
    public static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String input, int shiftAmt){
        // prepare return string
        String result = "";
        // simplify to lower case
        String lowInput = input.toLowerCase();

        for(int i=0; i < input.length(); i++){
            // get position of each character
            int index = ALPHA.indexOf(lowInput.charAt(i));
            
            // get encrypted char [ Encrypt with shift n = (x + n) % 26 ]
            int encryptPos = (index + shiftAmt) % 26;
            char encChar = ALPHA.charAt(encryptPos);

            // add character to return string
            result += encChar;
        }
        return result;
    }

    public static void main(String args[]){

        // variable declaration
        Scanner scan = new Scanner(System.in);        
        String input;
        int shiftAmt;

        // get input
        System.out.println("Enter text to encrypt: ");
        input= scan.nextLine();
        System.out.println("Enter amount to shift: ");
        shiftAmt = scan.nextInt();

        /*
         * 
         * Advanced algorithms :o
         * 
         */

        scan.close();

        // output
        System.out.println(encrypt(input, shiftAmt));
    }

    // tests
    @Test
    public void testEncrypt(){
        // Test encrypt "test" with shift amount 3
        assertEquals("Testing", "whvw", encrypt("test", 3));
    }

    @Test
    public void testEncrypt2(){
        // Test encrypt "testing" with shift amount 5
        assertEquals("Testing", "yjxynsl", encrypt("testing", 5));
    }
}