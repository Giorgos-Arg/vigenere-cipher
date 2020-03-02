/**
 * Implements a method for enciphering and a method for deciphering strings.
 * Vigenere Cipher uses the Caesar Cipher along with table-key cipher. It uses a
 * 90 x 90 table (ascii characters between 33-122). Every row of the table
 * shifts 1 place left using the Caesar Cipher. Every character of the string is
 * replaced with the character at the slot (X,Y) of the table. X is the row that
 * corresponds to the table-key character and Y is the column that corresponds
 * to the String character.
 * 
 * @author Giorgos Argyrides
 *
 */
public class VigenereCipher implements Cipher {

	/**
	 * A 90 x 90 table of characters used to define the ciphered character that will
	 * replace each character in the initial string. Every row has 90 characters
	 * (ascii characters between 33-122) and it's shifted 1 place left using Caesar
	 * Cipher.
	 */
	private char[][] vigenereTable;

	/**
	 * Table-key used to define the column of the enciphered character.
	 */
	private String key;

	/**
	 * Initializes the table and uses Caesar Cipher to shift every row by 1 place.
	 * 
	 * @param key Table-key used to define the column of the enciphered character.
	 */
	VigenereCipher(String key) {
		vigenereTable = new char[90][90];
		this.key = key;
		for (int j = 0; j < 90; j++) {
			vigenereTable[0][j] = (char) (33 + j);
		}
		for (int i = 1; i < 90; i++) {
			CaesarCipher caesarCypher = new CaesarCipher(i);
			for (int j = 0; j < 90; j++) {
				vigenereTable[i][j] = caesarCypher.encipher(String.valueOf(vigenereTable[0][j])).charAt(0);
			}
		}
	}

	/**
	 * Enciphers the string by replacing every character with the character at row X
	 * and column Y of the Vigenere Table. X and Y are calculated as described
	 * above.
	 * 
	 */
	public String encipher(String s) {
		String encipherS = "";
		int x, y;
		char c;
		for (int i = 0; i < s.length(); i++) {
			x = ((int) this.key.charAt(i % key.length())) - 33;
			y = ((int) s.charAt(i)) - 33;
			c = vigenereTable[x][y];
			encipherS += c;
		}
		return encipherS;
	}

	/**
	 * Deciphers the string by replacing every character with the character that
	 * corresponds to the header of the column of the table-key letter at row X
	 * 
	 * @param s the string to be deciphered.
	 * @return the deciphered string.
	 */
	public String decipher(String s) {
		String decipherS = "";
		int x, y;
		char c;
		for (int i = 0; i < s.length(); i++) {
			x = ((int) this.key.charAt(i % key.length())) - 33;
			for (y = 0; y < 90; y++) {
				if (vigenereTable[x][y] == s.charAt(i)) {
					break;
				}
			}
			c = (char) (y + 33);
			decipherS += c;
		}
		return decipherS;
	}
}