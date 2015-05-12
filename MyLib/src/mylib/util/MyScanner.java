package mylib.util;

import java.util.Scanner;

/**
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class MyScanner {

	private static Scanner scanner = creaScanner();

	private final static String ERRORE_FORMATO = "Attenzione! il dato inserito non è nel formato corretto";
	private final static String ERRORE_MINIMO = "Attenzione! E' richiesto un valore maggiore o uguale a ";
	private final static String ERRORE_STRINGA_VUOTA = "Attenzione! Non hai inserito alcun carattere";
	private final static String ERRORE_MASSIMO = "Attenzione! E' richiesto un valore minore o uguale a ";
	private final static String MESSAGGIO_AMMISSIBILI = "Attenzione! I caratteri ammissibili sono: ";
	private final static char SI = 'S';
	private final static char NO = 'N';

	/**
	 * Crea uno scanner con opzione automatica per la separazione delle righe in
	 * un testo
	 * 
	 * @return lo scanner
	 */

	private static Scanner creaScanner() {
		Scanner s = new Scanner(System.in);
		s.useDelimiter(System.getProperty("line.separator"));
		return s;
	}

	/**
	 * Stampa il messaggio ricevuto e gestisce l'acquisizione di una stringa da
	 * tastiera
	 * 
	 * @param messaggio
	 *            il messaggio da stampare prima di acquisire la stringa
	 * @return la stringa acquisita
	 */

	public static String leggiStringa(String messaggio) {

		System.out.print(messaggio);

		return scanner.next();
	}

	/**
	 * Stampa il messaggio ricevuto e gestisce l'acquisizione di una stringa non
	 * vuota da tastiera
	 * 
	 * @param messaggio
	 *            il messaggio da stampare prima di acquisire la stringa non
	 *            vuota
	 * @return la stringa acquisita non vuota
	 */

	public static String leggiStringaNonVuota(String messaggio) {

		boolean flag = false;
		String lettura = null;

		do {
			lettura = leggiStringa(messaggio);
			//Rimuvo gli spazi all'inizio e alla fine della stringa
			lettura = lettura.trim();
			//Se la stringa non è vuota ho finito la lettura
			if (lettura.length() > 0)
				flag = true;
			else
				System.out.println(ERRORE_STRINGA_VUOTA);

		} while (!flag);

		return lettura;
	}

	/**
	 * Stampa il messaggio ricevuto e gestisce l'acquisizione di un carattere da
	 * tastiera
	 * 
	 * @param messaggio
	 *            il messaggio da stampare prima di acquisire il carattere
	 * @return il carattere acquisito
	 */

	public static char leggiChar(String messaggio) {

		boolean flag = false;
		char charLetto = '\0';

		do {
			System.out.print(messaggio);
			String lettura = scanner.next();
			//Controllo solo che la stringa abbia lunghezza maggiore di 0 e che non sia composta da un solo carattere
			//(lunghezza = 1) perché suppongo che se vengano inseriti più caratteri, tutti i caratterei eccettuato
			//il primo siano errori di battitura. 
			//Esempio classico: sù (viene premuta ù per sbaglio al momento di premere INVIO)
			if (lettura.length() > 0) {
				charLetto = lettura.charAt(0);
				flag = true;
			} else {
				System.out.println(ERRORE_STRINGA_VUOTA);
			}

		} while (!flag);

		return charLetto;
	}

	/**
	 * Stampa il messaggio ricevuto e gestisce l'acquisizione di un carattere
	 * masiuscolo da tastiera
	 * 
	 * @param messaggio
	 *            il messaggio da stampare prima di acquisire il carattere
	 * @param ammissibili
	 *            la stringa contenente i caratteri ammissibili
	 * @return il carattere acquistio
	 */

	public static char leggiCharMaiuscolo(String messaggio, String ammissibili) {
		boolean finito = false;
		//Dato che per le variabili locali è obbligatoria un'inizializzazione
		//imposto il mio char ad un valore arbitrario
		char valoreLetto = '\0';
		do {
			valoreLetto = leggiChar(messaggio);
			valoreLetto = Character.toUpperCase(valoreLetto);
			//Se all'interno della stringa dei valori ammissibili trovo il carattere
			//appena letto ho finito la lettura
			if (ammissibili.indexOf(valoreLetto) != -1)
				finito = true;
			else
				System.out.println(MESSAGGIO_AMMISSIBILI + ammissibili);
		} while (!finito);
		return valoreLetto;
	}

	/**
	 * Stampa il messaggio ricevuto e gestisce la risposta positiva o negativa
	 * ad una domanda
	 * 
	 * @param messaggio
	 *            il messaggio da stampare prima di acquisire il carattere S o N
	 * @return true se stato acquisito S, false se è stato aquisito N
	 */

	public static boolean si_No(String messaggio) {
		String mioMessaggio = messaggio + "(" + SI + "/" + NO + ")";
		//Leggo un char i cui valori ammissibili sono definiti dalle costanti SI e NO  ('S' - 'N')
		char valoreLetto = leggiCharMaiuscolo(mioMessaggio, String.valueOf(SI)
				+ String.valueOf(NO));

		if (valoreLetto == SI)
			return true;
		else
			return false;
	}

	/**
	 * Stampa il messaggio ricevuto e gestisce l'acquisizione di un intero da
	 * tastiera
	 * 
	 * @param messaggio
	 *            il messaggio da stampare prima di acquisire l'intero
	 * @return l'intero acquisito
	 */

	public static int leggiIntero(String messaggio) {

		boolean flag = false;
		int intLetto = 0;

		do {
			System.out.print(messaggio);
			//Controllo se il prossimo valore dello scanner è un intero
			if (scanner.hasNextInt()) {
				intLetto = scanner.nextInt();
				flag = true;
			} else {
				//Se il valore non è un intero produco un messaggio di errore
				//e rimuovo il valore inutilizzato con il metodo next(); per liberare lo scanner
				System.out.println(ERRORE_FORMATO);
				scanner.next();
			}
		} while (!flag);

		return intLetto;
	}

	/**
	 * Stampa il messaggio ricevuto e gestisce l'acquisizione di un intero
	 * compreso tra un valore minimo e un valore massimo da tastiera
	 * 
	 * @param messaggio
	 *            il messaggio da stampare prima di acquisire l'intero
	 * @param min
	 *            il valore minimo accetato per l'intero da acquisire
	 * @param max
	 *            il valore massimo accetato per l'intero da acquisire
	 * @return l'intero acquisito
	 */

	public static int leggiIntero(String messaggio, int min, int max) {

		boolean flag = false;
		int intLetto = 0;

		do {
			intLetto = leggiIntero(messaggio);
			//Se l'intero letto è compreso nel range specificato ho finito la lettura
			//altrimenti produco un messaggio specificando se era sotto il limite inferiore
			//oppure se era sopra il limite superiore
			if (intLetto >= min && intLetto <= max)
				flag = true;
			else if (intLetto < min)
				System.out.println(ERRORE_MINIMO + min);
			else
				System.out.println(ERRORE_MASSIMO + max);

		} while (!flag);

		return intLetto;
	}
	
	/**
	 * Stampa il messaggio ricevuto e gestisce l'acquisizione di un double da
	 * tastiera
	 * 
	 * @param messaggio
	 *        il messaggio da stampare prima di acquisire l'intero
	 * @return il double acquisito
	 */

	public static double leggiDouble(String messaggio) {

		boolean flag = false;
		double doubleLetto = 0;

		do {
			System.out.print(messaggio);
			//Controllo se il prossimo valore dello scanner è un double
			if (scanner.hasNextDouble()) {
				doubleLetto = scanner.nextDouble();
				flag = true;
			} else {
				//Se il valore non è un double produco un messaggio di errore
				//e rimuovo il valore inutilizzato con il metodo next(); per liberare lo scanner
				System.out.println(ERRORE_FORMATO);
				scanner.next();
			}
		} while (!flag);

		return doubleLetto;
	}
	
	/**
	 * Stampa il messaggio ricevuto e gestisce l'acquisizione di un double
	 * compreso tra un valore minimo e un valore massimo da tastiera
	 * 
	 * @param messaggio
	 *            il messaggio da stampare prima di acquisire il double
	 * @param min
	 *            il valore minimo accetato per l'intero da acquisire
	 * @param max
	 *            il valore massimo accetato per l'intero da acquisire
	 * @return il double acquisito
	 */
	public static double leggiDouble(String messaggio, double min, double max) {

		boolean flag = false;
		double doubleLetto = 0;

		do {
			doubleLetto = leggiDouble(messaggio);
			//Se il double letto è compreso nel range specificato ho finito la lettura
			//altrimenti produco un messaggio specificando se era sotto il limite inferiore
			//oppure se era sopra il limite superiore
			if (doubleLetto >= min && doubleLetto <= max)
				flag = true;
			else if (doubleLetto < min)
				System.out.println(ERRORE_MINIMO + min);
			else
				System.out.println(ERRORE_MASSIMO + max);

		} while (!flag);

		return doubleLetto;
	}
}
