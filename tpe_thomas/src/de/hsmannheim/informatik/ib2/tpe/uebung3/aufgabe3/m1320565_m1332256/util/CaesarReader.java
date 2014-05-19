package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe3.m1320565_m1332256.util;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Class able to decode Ceasear-encrypted text.
 */

public class CaesarReader extends FilterReader {

	private int rotation;
	private Alphabet alphabet;

	/**
	 * Creates a new CaesarReader that supports Caesar-decoding.
	 * 
	 * @param in
	 * @param alphabet
	 * @param rotation
	 */
	
	public CaesarReader(Reader in, Alphabet alphabet, int rotation) {
		super(in);

		this.alphabet = alphabet;
		// Gives the inverse of the rotation that was used to encrypt. This way you can rotated in reverse order.
		this.rotation = convertRotation(rotation * -1);
	}

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
	 * Decodes the char if possible, which means that given char has to be part of
	 * the alphabet.
	 * 
	 * @param c
	 * @return c
	 * @throws CharacterNotFoundException
	 */
	private char decode(char c) throws CharacterNotFoundException {
		int decodedCharPosition = (alphabet.indexOf(c) + rotation) % alphabet.length();
		return alphabet.get(decodedCharPosition);
	}

	public int read() throws IOException {
		int i = super.read();
		char decodedChar = (char) i;

		// Abort if stream reached the end.
		if (i == -1) {
			return i;
		}

		/*
		 *  DEcrypt character of the alphabet, if not possible take the undecrypted character, and write it. This allows for additional characters and
		 *  punctuation marks to be written.
		 */
		try {
			decodedChar = decode(decodedChar);
		} catch (CharacterNotFoundException e) {
		}

		return decodedChar;
	}
}
