package paquetearrays5;

import java.util.Scanner;

public class Ej1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] tabla = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int valor;
		boolean res = false;
		
		System.out.println("Introduce un valor a buscar en la tabla de enteros:");
		valor = sc.nextInt();
		
		res = buscar(tabla, valor);
		
		if(!res) {
			System.out.println("El valor " + valor + " se encuentra en la tabla.");
		} else {
			System.out.println("El valor " + valor + " no se encuentra en la tabla.");

		}
		
		sc.close();
		
	}

	static boolean buscar(int[][] tabla, int valor) {
		boolean found = false;
		int i = 0;

		while (i < tabla.length && !found) {
			int j = 0;
			while (j < tabla[i].length && !found) {
				if (tabla[i][j] == valor) {
					found = true;
				}

				j++;

			}

			i++;

		}

		return found;
	}

}
