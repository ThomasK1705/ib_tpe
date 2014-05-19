package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe3.m1320565_m1332256.util;

public abstract class Alphabet {

	/**
	 * Alphabet build as an array of chars.
	 */
	protected char[] alphabet;

	/**
	 * Check if alphabet contains given character.
	 * 
	 * @param c
	 * @return true if character is contained in alphabet, else false is returned.
	 */
	public boolean contains(char c) {
		for (char element : alphabet) {
			if (element == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get character of alphabet at index.
	 * 
	 * @param index
	 * @return character
	 * @throws IndexOutOfBoundsException
	 */
	public char get(int index) {
		return alphabet[index];
	}

	/**
	 * Get complete alphabet. Is an array.
	 * 
	 * @return alphabet
	 */
	public char[] getAlphabet() {
		return alphabet;
	}

	/**
	 * Get index of given character in alphabet.
	 * 
	 * @param c
	 * @return index
	 * @throws CharacterNotFoundException
	 */
	public int indexOf(char c) throws CharacterNotFoundException {
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] == c) {
				return i;
			}
		}
		throw new CharacterNotFoundException("Character: \'" + c + "\' could not be found!");
	}

	public int length() {
		return alphabet.length;
	}

	@Override
	public String toString() {
		String result = "[ ";

		for (char c : alphabet) {
			result += c + " ";
		}
		result += "]";

		return result;
	}
}
