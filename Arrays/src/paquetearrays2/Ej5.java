package paquetearrays2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ej5 {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		int[] tabla = new int[1000];
		int valor = -1;
		int contador = 0;
		boolean enc = false;

		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = rand.nextInt(0, 100);
		}

		System.out.println("BUSCAR VALOR EN ARRAY");
		
		do {
			try {
				System.out.println("\nIntroduce un valor a buscar en la tabla (0-99):");
				valor = sc.nextInt();
				assert valor >= 0 && valor <= 99 : "Debe introducir un valor entre 0 y 99 inclusives.";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Debe introducir un nº entero.");
			} finally {
				sc.nextLine();
			}
		} while (valor < 0 || valor > 99);
		
		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] == valor) {
				contador++;
				
				if (!enc) {
					System.out.println("\nEl valor " + valor + " se encuentra en las posiciones:");
					enc = true;
				}
				
				System.out.print(i + " ");
				
			}
		}
		
		System.out.println("\n\nEl valor " + valor + " se encuentra en la tabla " + contador + " veces.");
		
		sc.close();

	}
}
