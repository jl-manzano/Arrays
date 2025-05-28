package paquetearrays2;

import java.util.Arrays;
import java.util.Random;

public class Ej3 {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] tabla = new int[30];
		
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = rand.nextInt(0, 10);
		}
		
		Arrays.sort(tabla);
		
		System.out.println("TABLA ORDENADA:\n" + Arrays.toString(tabla));
	}
}
