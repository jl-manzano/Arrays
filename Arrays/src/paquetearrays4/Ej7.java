package paquetearrays4;

import java.util.Random;

public class Ej7 {
	public static void main(String[] args) {
		Random rand = new Random();

		int[][] tabla = new int[6][10];
		int[] tablaResultado;
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				tabla[i][j] = rand.nextInt(1001);
			}
		}
		
		tablaResultado = minMax(tabla);
		
		System.out.println("TABLA\nMin: " + tablaResultado[0] + "\nMax: " + tablaResultado[1]);

	}

	static int[] minMax(int[][] tabla) {
		int[] t = new int[2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				if (tabla[i][j] < min) {
					min = tabla[i][j];
				}

				if (tabla[i][j] > max) {
					max = tabla[i][j];
				}

			}
		}

		t[0] = min;
		t[1] = max;

		return t;

	}

}
