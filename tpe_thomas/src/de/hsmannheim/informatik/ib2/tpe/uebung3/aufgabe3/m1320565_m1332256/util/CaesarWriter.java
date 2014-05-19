package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe3.m1320565_m1332256.util;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Class for writing characters using Caesar-encryption.
 */
public class CaesarWriter extends FilterWriter {

	private int rotation;
	private Alphabet alphabet;

	/**
	 * Creates a new CaesarWriter that allows Caesar-encryption.
	 * 
	 * @param out
	 * @param alphabet
	 * @param rotation
	 */
	public CaesarWriter(Writer out, Alphabet alphabet, int rotation) {
		super(out);

		this.alphabet = alphabet;
		this.rotation = convertRotation(rotation);
	}

	/*
	 * Because the FilterWriter extends from a standard Writer, a write(String sr) 
	 * and a write(char[] cbuf) will call either its own implementation of
	 * write(String str, int off, int len) or if there is an inheritance
	 * relationship, the more specific implementation of the more specific class
	 * will be called, therefore I only have to override those 3 methods.
	 * 
	 * For further reference refer to:
	 * http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/io/FilterWriter.java
	 */

	/**
	 * Converts the rotation that could be positive / negative to a general
	 * rotation that works in both cases. Since the modulo-operator in java can have a
	 * negative remainder this conversion is necessary.
	 * 
	 * @param rotation
	 * @return generalRotation
	 */
	private int convertRotation(int rotation) {
		return (rotation % alphabet.length()) + alphabet.length();
	}

	/**
	 * Encrypts the char if possible. Which means that a given char has to be part of
	 * the alphabet to be encryptable.
	 * 
	 * @param c
	 * @return enrypted char
	 */
	private char encrypt(char c) throws CharacterNotFoundException {
		int enryptedCharPostion = (alphabet.indexOf(c) + rotation) % alphabet.length();
		return alphabet.get(enryptedCharPostion);
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i = off; i < (off + len); i++) {
			write(cbuf[i]);
		}
	}

	@Override
	public void write(int c) throws IOException {
		char encryptedChar = (char) c;

		/*
		 *  Encrypt character of the alphabet, if not possible take the unencrypted character, and write it. This allows for additional characters and
		 *  punctuation marks to be written.
		 */
		try {
			encryptedChar = encrypt((char) c);
		} catch (CharacterNotFoundException e) {
		} finally {
			super.write(encryptedChar);
		}
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		write(str.toCharArray(), off, len);
	}
}