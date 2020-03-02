/**
 * Implements a method for enciphering and a method for deciphering strings.
 * Caesar Cipher replaces every character of a string with another character by
 * shifting it a certain number of places down the ascii table.
 * 
 * @author Giorgos Argyrides
 */

public class CaesarCipher implements Cipher {

	private int shift;

	public CaesarCipher(int shift) {
		this.shift = shift;
	}

	public String encipher(String s) {
		String encipherS = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			c = (char) (c + shift);
			if (c > 122) {
				c = (char) (c - 90);
			}
			encipherS += c;
		}
		return encipherS;
	}

	public String decipher(String s) {
		String decipherS = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			c = (char) (c - shift);
			if (c < 33) {
				c = (char) (c + 90);
			}
			decipherS += c;
		}
		return decipherS;
	}
}