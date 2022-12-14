// Baillie Stang
// 2022

import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import org.junit.Test;

public class Caesar {

    // Cosc is awesome

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

    public static String decrypt(String input, int shiftAmt){
        // prepare return string
        String result = "";
        // simplify to lower case
        String lowInput = input.toLowerCase();
 
        for(int i=0; i < input.length(); i++){
            // get position of each character
            int index = ALPHA.indexOf(lowInput.charAt(i));
            
            // get decrypted char [ Encrypt with shift n = (x - n) % 26 ]
            int decryptPos = (index - shiftAmt) % 26;
 
            if(decryptPos < 0){
                decryptPos = ALPHA.length() + decryptPos;
            }

            char decChar = ALPHA.charAt(decryptPos);

            // add character to return string
            result += decChar;
        }
        return result;
    }

    public static void main(String args[]){

        // variable declaration
        Scanner scan = new Scanner(System.in);        
        String input;
        int shiftAmt;

        // get input
        System.out.println("Enter text to encrypt/decrypt: ");
        input= scan.nextLine();
        System.out.println("Enter the shift amount: ");
        shiftAmt = scan.nextInt();

        scan.close();

        // output
        System.out.println("\nEncrypted Value: " + encrypt(input, shiftAmt));
        System.out.println("Decrypted Value: " + decrypt(input, shiftAmt));
    }

    // JUnit Tests
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

    @Test
    public void testDecrypt(){
        // Test encrypt "test" with shift amount 3
        assertEquals("Testing", "test", decrypt("whvw", 3));
    }

    @Test
    public void testDecrypt2(){
        // Test encrypt "testing" with shift amount 5
        assertEquals("Testing", "testing", decrypt("yjxynsl", 5));
    }
}