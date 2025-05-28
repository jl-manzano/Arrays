package paquetearrays;

import java.util.Scanner;

public class Ej7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] tabla = new double[12];

		System.out.println("TEMPERATURAS\n===================");

		for (int i = 0; i < tabla.length; i++) {
			System.out.println("\nIntroduzca la tª del mes " + (i + 1) + ":");
			tabla[i] = sc.nextDouble();
		}

		for (double valor : tabla) {
			for (int i = 0; i < valor; i++) {
				System.out.print(" * ");
			}

			System.out.println();
			
		}

		sc.close();

	}
}
