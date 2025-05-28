package paquetearrays;

import java.util.Arrays;
import java.util.Random;

public class Ej1 {
	public static void main(String[] args) {
		Random rand = new Random();
		
		int tabla[] = new int[10];

		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = rand.nextInt(1, 101);
		}
		
		System.out.println(Arrays.toString(tabla));
		
	}
}
