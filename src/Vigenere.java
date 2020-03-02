
/**
 * Main class of the program. User can run it in this format: 
 * "java Vigenere <key> <input_file> <output_file>". The program
 * reads a text from input_file.txt, enciphers it using 
 * Vigenere's cipher and the given key as the table-key and saves the enciphered 
 * message in output_file.txt. If the users gives wrong arguments or
 * if there are any errors with the files, it prints the proper messages
 * and terminates the program. Finally, it prints the initial text, the encrypted text
 * and the decrypted text along with a message of success or failure.
 * 
 * @author Giorgos Argyrides
 *
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Vigenere {
	private static String text;
	private static String encryptedText;
	private static String decryptedText;

	static void readFile(String fileName) {
		char c;
		boolean empty = true;
		text = "";
		try {
			File file = new File(fileName);
			FileInputStream input = new FileInputStream(file);
			while (input.available() > 0) {
				empty = false;
				c = (char) (input.read());
				if ((c < 33) || (c > 122)) {
					System.err.println("Error! The input file must include only ascii characters between 33 and 122!");
					System.exit(1);
				}
				text += c;
			}
			if (empty) {
				System.err.println("Error! The input file is empty!");
				System.exit(1);
			}
			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error! " + fileName + " file not found!");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void writeFile(String fileName) {
		try {
			File file = new File(fileName);
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(encryptedText);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error! failed to write in " + fileName);
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("Error! Wrong argument input! Please give the arguments in this format:\n"
					+ "java VigenereEncrypt key input_file.txt output_file.txt");
		} else {
			for (int i = 0; i < args[0].length(); i++) {
				if ((args[0].charAt(i) < 33) || (args[0].charAt(i) > 122)) {
					System.err.println("Error! the key must include only ascii characters between 33 and 122!");
					System.exit(1);
				}
			}
			readFile(args[1]);
			VigenereCipher vc = new VigenereCipher(args[0]);
			encryptedText = vc.encipher(text);
			writeFile(args[2]);
			decryptedText = vc.decipher(encryptedText);
			System.out.println("\n\nOriginal text: " + text + "\n\nEncrypted text: " + encryptedText
					+ "\n\nDecrypted text: " + decryptedText + "\n");
			if (text.equals(decryptedText)) {
				System.out.println("Encrypted and decrypted successfully!!!\n");
			} else {
				System.out.println("Failed to encrypt and decrypt!\n");
			}
		}
	}
}