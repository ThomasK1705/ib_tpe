package de.hsmannheim.informatik.ib2.tpe.uebung3.aufgabe1.m1320565_m1332256;

/*
 * Question: Nennen Sie zwei Vorteile, warum Exceptions statt Fehlercodes verwendet werden sollten.
 * 
 * Answer: Durch die Nutzung von Exceptions wird der Code übersichtlicher und leichter zu verstehen.
 * Die Fehlerbehandlung wird isoliert durchgeführt. Dies bedeutet, dass nicht nach jedem Aufruf eine Fehlercodeprüfung erfolgen muss.
 * Dadurch wird die Fehlerbehandlung vom fehlerfreien Programmablauf getrennt.
 * Außerdem erlaubt das Arbeiten mit Exceptions, dass Fehler selbst definierbar sind. Damit ist auch die Fehlerbehandlung defenierbar.
 * 
 *
 */

/*
 * Question: Erklären Sie die catch-throw-Regel anhand eines einfachen, selbstentworfenen Beispiels.
 * 
 * Answer: Die catch-throw-Regel besagt, dass jede Ausnahme entweder behandelt oder weitergeben werden muss. Dabei gibt die throw-Anweisung die Exception an den umgebenden Block weiter.
 * Die try-catch-Anweisung behandelt dann den Fehler. Der try-Block enthält dabei eine oder mehrere Anweisungen, bei deren Ausführung ein Fehler des Typs Ausnahmetyp auftreten kann. 
 * In diesem Fall wird die normale Programmausführung unterbrochen, und der Programmablauf fährt mit der ersten Anweisung nach der catch-Klausel fort, die den passenden Ausnahmetyp deklariert hat.
 * Exceptions sind also auch als Objekte zu implementieren. In der Catch-Klausel kann nun Code untergebracht werden, der die Fehlerbehandlung realisiert. 
 * Wirft man mittels throw eine Exception nach oben, so wird im nächst höheren Block nach einer passenden catch-Klausel. Ist in den umgebenden Blöcken kein catch zu finden, dann wird die Exception an den Aufrufer weitergeben.
 * Ist auch in der Hauptmethode keine catch-Klausel zu finden, so bricht das Programm mit einem Fehler ab.
 * 
 * Das Prinzip wird an folgendem Beispiel verdeutlicht.
 */

public class Main {

	public static void main(String[] args) {
		
		/* 
		 * Hier wird versucht den String 60 zu verschiedenen Basen in einen int-Wert zu parsen. Ohne weitere Anweisung wird das Programm jedoch bei 60 zur Basis 6 eine Exception des Typs NumberFormatException ausgegeben.
		 * Wird dieser Fehler nicht behandelt so wird das Programm abgebrochen. Daher ist zur sicheren Ausführung des Programmes der Codeteil auskommentiert. Zum testen einfach wieder entkommenteiren.
		 */
		
		/*int i; 
		int base1 = 0;
		for (base1 = 12; base1 >= 2; base1--) {
			i = Integer.parseInt("60", base1);
			System.out.println("60 base " + base1 + " = " + i);
		}*/
		
		// Der Fehler kann nun an Ort und Stelle behandelt werden. Wie man sieht wird nach der Fehlerbehandlung die Mainmethode auch weiter ausgeführt und nicht abgebrochen.
		
		int b;
		int base2 = 0;
		try {
			for (base2 = 12; base2 >= 2; base2--) {
				b = Integer.parseInt("60", base2);
				System.out.println("60 base " + base2 + " = " + b);
			}
		} catch (NumberFormatException e) { //Hier wird nun die Exception gecatched und behandelt, indem ein Text ausgegeben wird. Schriebe man nun die catch-Klausel innerhalb der Schleife würde das Programm nicht abbrechen, sondern bis zur 2 Weiterlaufen
			System.out.println("60 ist keine Zahl zur Basis " + base2);
			// Außerdem kann man noch verschiedene Informationen aus der Exception abrufen.
			System.out.println("***Fehler aufgetreten***");
			System.out.println("Ursache: " + e.getMessage()); // Holt die Fehlernachricht der Exception 
			e.printStackTrace(); // Hiermit wird der Laufzeitstack zum Fehlerzeitpunkt ausgegeben. Damit kann man u.a. identifizieren an welcher Stelle die Exception auftritt.
		}
		
		/*
		 * Hier wird in der Klasse SampleForException eine Exception geworfen. Diese wird nicht in der Klasse selbst behandelt und damit an den Aufrufer weitergegeben. Damit muss die Ausnahme hier behandelt werden. Geschieht dies nicht wird mit einer Exception abgebrochen.
		 * Dies wird mit dem letzten Codeabschnitt dargestellt. Nach diesem wird Main dann auch abgebrochen, da eine Exception nicht behandelt wird und standardmäßig wird Exception.printStackTrace() genutzt. Würde nicht abgebrochen würden Sie lesen, dass für TPE ganz schon viel zu tun ist.
		 */
		
		SampleForExceptions ex = new SampleForExceptions();
		System.out.println("*****************************************************************************");
		try{
			ex.creatException();
		} catch (NumberFormatException e) {
			System.out.println("60 ist keine Zahl zur Basis " + ex.base3);
		}
		
		System.out.println("*****************************************************************************");
		
		ex.creatException();
		
		System.out.println("Für TPE muss man aber ganz schön was tun!");
		
	}

}
