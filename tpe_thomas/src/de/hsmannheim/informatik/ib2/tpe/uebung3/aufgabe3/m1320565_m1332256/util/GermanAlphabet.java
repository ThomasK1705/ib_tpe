package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe3.m1320565_m1332256.util;

/**
 * German Alphabet. Contains the following characters: A-Z, a-z, �, �, ܂ �, �, �.
 */

public class GermanAlphabet extends Alphabet {

	public GermanAlphabet() {
		initialize();
	}

	private void initialize() {
		char asciiPointer = 'A';
		char[] alphabet = new char[58];

		// Capital letters.
		for (int i = 0; i < 27; i++) {
			alphabet[i] = asciiPointer++;
		}

		// Lowercase letters.
		asciiPointer = 'a';
		for (int i = 26; i < 53; i++) {
			alphabet[i] = asciiPointer++;
		}

		// Mutated Vowels
		alphabet[52] = '�';
		alphabet[53] = '�';
		alphabet[54] = '�';
		alphabet[55] = '�';
		alphabet[56] = '�';
		alphabet[57] = '�';

		this.alphabet = alphabet;
	}

}
