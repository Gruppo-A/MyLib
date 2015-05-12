package mylib.math;

import java.util.Random;

/**
 * 
 * @author Marco Cadei, Luca Festoni, Antonello Zanini
 *
 */
public class MyMath {
	private static Random rand = new Random();

	/**
	 * Genera un valore casuale compreso tra un valore minimo e uno massimo
	 * (estremi inclusi)
	 * 
	 * @param min
	 *            il valore minimo che può assumere il valore generato
	 *            casualmente
	 * @param max
	 *            il valore massimo che può assumere il valore generato
	 *            casualmente
	 * @return il valore generato casualmente
	 */

	public static int randomIntero(int min, int max) {
		int intervallo = max + 1 - min;
		int casuale = rand.nextInt(intervallo);

		return casuale + min;
	}

	/**
	 * Produce il logaritmo in qualsiasi base
	 * 
	 * @param base
	 *            la base del logaritmo
	 * @param arg
	 *            l'argomento del logaritmo
	 * @return il logaritmo avente come base e argomento quelli specificati
	 */
	public static double log(double base, double arg) {
		return Math.log10(arg) / Math.log10(base);
	}

	/**
	 * Restituisce la media algebrica degli argomenti
	 * 
	 * @param args
	 *            i numeri di cui si vuole calcolare la media algebrica
	 * @return la media algebrica dei numeri passati come argomento
	 */
	public static double mediaAlgebrica(double... args) {
		double media = 0;

		for (double d : args)
			media += d;

		return media / args.length;
	}
}
