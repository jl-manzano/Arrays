package paquetearrays;

import java.util.Scanner;

public class Ej3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float[] tabla = new float[10];

		System.out.println("TABLA Nºs\n===================");

		for (int i = 0; i < tabla.length; i++) {
			System.out.println("\nIntroduzca un nº: ");
			tabla[i] = sc.nextFloat();
		}

		System.out.println("\nTABLA:\n");

		for (int i = tabla.length - 1; i >= 0; i--) {
			System.out.println(tabla[i]);
		}

		sc.close();

	}
}
