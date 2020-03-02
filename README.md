# vigenere-cipher

This java program provides an implementation of the [Vigenere cipher](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher).

## Description

The program accepts characters between [ASCII](https://www.ascii-code.com/) numbers 33 (corresponds to '!') And 122 
(corresponds to 'z').

## Usage

```bash
java Vigenere <key> <input_file> <output_file>
```

The above execution encrypts the message in the input file based on the key and saves the encrypted message in the 
output file.

## Example

```bash
java Vigenere QRSTUVWXYZ ./data/input.txt ./data/output.txt


Original text: ABCDEFGHIJKLMNOP

Encrypted text: qsuwy!#%')!#%')+

Decrypted text: ABCDEFGHIJKLMNOP

Encrypted and decrypted successfully!!!
```

## Author

Giorgos Argyrides (g.aryrides@outlook.com)
