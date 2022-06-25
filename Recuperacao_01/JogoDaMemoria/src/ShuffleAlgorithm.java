/*
 * Autor: Henrique Felipe
 * Site: https://blogcyberini.blogspot.com/
 * Janeiro de 2015
 * 
 * "Algoritmo de embaralhamento"
 */

import java.util.Random;

/*
 * Classe com o método "shuffle" que permite embaralhar
 * um array de objetos. 
 */
public class ShuffleAlgorithm {
	//embaralhamento de Fisher-Yates
	public static void shuffle(Object[] a){
		Random rnd = new Random();
		for(int i = a.length - 1; i > 0; i--){
			int randomNumber = rnd.nextInt(i + 1);
			swap(a, i, randomNumber);
		}
	}
	//troca a posição entre dois objetos no array
	private static void swap(Object[] a, int i, int j){
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
