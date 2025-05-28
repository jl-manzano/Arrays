package paquetearrays5;

import java.util.Arrays;
import java.util.Random;

public class Ej2 {
	public static void main(String[] args) {
		int[] tabla = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Nºs DEL 1 AL 10 ORDENADOS");
		System.out.println(Arrays.toString(tabla));

		desordenarTabla(tabla);

		System.out.println("\nNºs DEL 1 AL 10 DESORDENADOS");
		System.out.println(Arrays.toString(tabla));
	}

	static int[] desordenarTabla(int[] tabla) {
		Random rand = new Random();

		int random;
		int auxiliar;

		for (int i = 0; i < tabla.length; i++) {
			random = rand.nextInt(tabla.length);
			auxiliar = tabla[i];
			tabla[i] = tabla[random];
			tabla[random] = auxiliar;

		}

		return tabla;
	}

}
