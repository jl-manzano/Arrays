package paquetearrays5;

import java.util.Random;

public class Ej3 {
	public static void main(String[] args) {
		int[][] tabla = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };

		System.out.println("Nºs DEL 1 AL 15 ORDENADOS");
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.print(tabla[i][j] + "\t");
			}
			System.out.println();
		}

		desordenarTabla(tabla);

		System.out.println("\nNºs DEL 1 AL 15 DESORDENADOS");
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.print(tabla[i][j] + "\t");
			}
			System.out.println();
		}

	}

	static int[][] desordenarTabla(int[][] tabla) {
		Random rand = new Random();

		int randomRow;
		int randomCol;
		int auxiliar;

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				randomRow = rand.nextInt(tabla.length);
				randomCol = rand.nextInt(tabla[i].length);
				auxiliar = tabla[i][j];
				tabla[i][j] = tabla[randomRow][randomCol];
				tabla[randomRow][randomCol] = auxiliar;

			}

		}

		return tabla;
	}

}
