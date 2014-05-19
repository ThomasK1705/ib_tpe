package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe3.m1320565_m1332256;

import de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe3.m1320565_m1332256.util.GermanAlphabet;
import de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe3.m1320565_m1332256.util.CaesarReader;
import de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe3.m1320565_m1332256.util.CaesarWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Alphabet: " + new GermanAlphabet().toString() + "\n");

		try {
			// Encrypt, see CeasarEncription.txt for encrypted text. The file is written to the Project folder of this java-project.
			CaesarWriter writer = new CaesarWriter(new FileWriter("CeasarEncription.txt"), new GermanAlphabet(), -333);

			writer.write("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. And to show that some stuff is not touched: !§$%&/()==?+#-#");
			writer.close();

			// Decode.
			System.out.println("Entschlüsselt: ");
			CaesarReader reader = new CaesarReader(new FileReader("CeasarEncription.txt"), new GermanAlphabet(), -333);
			int i;

			while ((i = reader.read()) > -1) {
				System.out.print((char) i);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
