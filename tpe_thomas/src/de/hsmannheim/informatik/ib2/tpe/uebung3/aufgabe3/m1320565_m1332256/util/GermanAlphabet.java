package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe3.m1320565_m1332256.util;

/**
 * German Alphabet. Contains the following characters: A-Z, a-z, Ä, Ö, Ü‚ ä, ö, ü.
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
		alphabet[52] = 'Ä';
		alphabet[53] = 'Ö';
		alphabet[54] = 'Ü';
		alphabet[55] = 'ä';
		alphabet[56] = 'ö';
		alphabet[57] = 'ü';

		this.alphabet = alphabet;
	}

}
