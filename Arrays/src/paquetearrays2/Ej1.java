package paquetearrays2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamaño = 0;
		double valor;
		double[] tabla;
		
		do {
			try {
				System.out.println("Introduce el tamaño de la tabla:");
				tamaño = sc.nextInt();
				assert tamaño > 0 : "Debe introducir un nº entero > 0.";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Debe introducir un nº entero.");
			} finally {
				sc.nextLine();
			}
		} while (tamaño < 0);
		
		tabla = new double[tamaño];
		
		for (int i = 0; i < tabla.length; i++) {
			System.out.println("Introduce un valor:");
			valor = sc.nextDouble();
			tabla[i] = valor;
		}
		
		System.out.println(Arrays.toString(tabla));
		
		sc.close();
	}
}
