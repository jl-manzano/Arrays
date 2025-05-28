package paquetearrays4;

import java.util.Arrays;
import java.util.Scanner;

public class Ej5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tabla[] = { 1, 22, 24, 34, 1, 1, 7 };
		int resultadoBusq[];
		int num;

		System.out.println("TABLA BUSCAR ELEMENTOS Y ALMACENAR ÍNDICES DONDE SE ENCUENTRA EN TABLA");
		System.out.println("Introduce un número para comprobar en qué posiciones de la tabla se encuentra: ");
		num = sc.nextInt();

		resultadoBusq = buscarTodos(tabla, num);

		System.out.println("\nTABLA ORIGINAL:\n" + Arrays.toString(tabla));

		System.out.println("\nRESULTADO BÚSQUEDA:\n" + Arrays.toString(resultadoBusq));

		sc.close();
	}

	static int[] buscarTodos(int t[], int valor) {
		int[] tabla;
		int numVeces = 0;
		int indice = 0;

		for (int v : t) {
			if (v == valor) {
				numVeces++;
			}
		}

		tabla = new int[numVeces];

		for (int i = 0; i < t.length; i++) {
			if (t[i] == valor) {
				tabla[indice] = i;
				indice++;
			}
		}

		return tabla;

	}

}
