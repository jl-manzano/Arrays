package paquetearrays2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] tabla = new int[8];
		int puntuacion = 0;
		int contador = 0;
		
		System.out.println("AJEDREZ PUNTUACIONES\n====================");
		for (int i = 0; i < tabla.length; i++) {
			
			do {
				try {
					
			System.out.println("\nIntroduce la puntuación del jugador " + (i+1) + ":");
			puntuacion = sc.nextInt();
			
			tabla[i] = puntuacion;
			
			assert puntuacion >= 1000 && puntuacion <= 2800 : "Debe introducir una puntuación entre 1000 y 2800.";
			
				} catch (AssertionError e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("Debe introducir un nº entero.");
				} finally {
					sc.nextLine();
				}
			} while (puntuacion < 1000 || puntuacion > 2800);
		}
		
		Arrays.sort(tabla);
		
		for (int i = tabla.length - 1; i >= 0; i--) {
			if (i == tabla.length - 1) {
				System.out.println("\nTABLA ORDENADA EN ORDEN DESCENDENTE");				
			}
			
			System.out.println("Puntuación J" + (contador+1) + ": " + tabla[i]);
			contador++;

		}
		
		sc.close();
	}
}
