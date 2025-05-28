package paquetearrays;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ej8 {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		int tabla[] = new int[100];
		int num = 0;
		boolean enc = false;

		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = rand.nextInt(1, 11);
		}

		System.out.println("TABLA:\n" + Arrays.toString(tabla) + "\n");

		do {
			try {
				System.out.println("Dime un valor para mostrar en qué posiciones del array aparece: ");
				num = sc.nextInt();
				assert num >= 1 && num <= 10 : "Debe introducir un nº dentro del rango.";
			} catch (AssertionError e) {
				System.out.println("El nº debe estar comprendido entre 1 y 10 (1 y 10 inclusive).");
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un nº entero.");
			} finally {
				sc.nextLine();
			}
		} while (num < 1 || num > 10);

		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] == num) {
				if (!enc) {
					System.out.println("\nEl nº " + num + " se encuentra en las posiciones:");
					enc = true;
				}

				System.out.print(i + " ");

			}
		}

		if (!enc) {
			System.out.println("El número " + num + " no se encuentra en la tabla.");
		}

		sc.close();

	}
}
