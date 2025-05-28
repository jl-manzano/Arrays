package paquetearrays3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] tabla;
		int filas = 0;
		int cols = 0;

		System.out.println("EJERCICIO 3 BIDIMENSIONALES");

		do {
			try {
				System.out.println("\nIntroduce el nº de filas:");
				filas = sc.nextInt();
				System.out.println("\nIntroduce el nº de columnas:");
				cols = sc.nextInt();
				assert filas > 0 && cols > 0 : "Introduce un nº de filas y columnas válido (> 0).";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Introduce un nº real.");
			}
		} while (filas <= 0 || cols <= 0);

		tabla = new int[filas][cols];

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				tabla[i][j] = 10 * i + j;
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.print(tabla[i][j] + "\t");
			}
			
			System.out.println();
			
		}
		
		sc.close();
		
	}
}
