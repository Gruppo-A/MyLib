package mylib.util;

/**
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */

public class MyMenu {
	final private static String VOCE_USCITA = "Esci";
	final private static String PIU = "+";
	final private static String TRAT = "-";
	final private static String SBARRA = "|";
	final private static String TRATTINO = " - ";
	final private static String RICHIESTA_INSERIMENTO = "Inserisci il numero corrispondente all'azione desiderata:";

	private String titolo;
	private String[] voci;

	/**
	 * Crea un menu costituito da un titolo e dalle voci selezionabili
	 * 
	 * @param titolo
	 *            il titolo del menu
	 * @param voci
	 *            le voci selezionabili del menu
	 */

	public MyMenu(String titolo, String[] voci) {
		this.titolo = titolo;
		this.voci = voci;
	}
	
	/**
	 * Stampa il menu con una cornice e assegna un numero ad ogni voce	 
	 */

	public void stampa() {
		StringBuffer cornice = new StringBuffer("");
		cornice.append(PIU);
		for(int j = 0; j < titolo.length() + 2; j++)
		{
			cornice.append(TRAT);
		}
		cornice.append(PIU);
		
		/*Crea una del cornice del tipo
		 * +--------+
		 * | titolo |
		 * +--------+
		 * e la stampa
		*/
		
		System.out.println(cornice.toString());
		System.out.println(SBARRA + " " + titolo + " " + SBARRA);
		System.out.println(cornice.toString());
		
		int i = 0;
		//Stampo tutte le voci del menù
		for (i = 0; i < voci.length; i++) {
			System.out.println((i + 1) + TRATTINO + voci[i]);
		}
		//Indipendentemente dalle voci passate, ci sarà sempre 
		//la voce uscita come ultima opzione
		System.out.println((i + 1) + TRATTINO + VOCE_USCITA);
		System.out.println();
	}
	
	/**
	 * Stampa il menu e permette la selezione di una voce
	 * @return il numero selezionato
	 */
	
	public int seleziona() {
		stampa();
		//voci.length + 1 perchè c'è anche la voce di uscita
		return MyScanner.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.length + 1);
	}	
	
}
