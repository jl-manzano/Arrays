package paquetearrays;

import java.util.Scanner;

public class Ej6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] tabla = new int[8];

		System.out.println("TABLA Nºs REALES\n===================");

		for (int i = 0; i < tabla.length; i++) {
			System.out.println("\nIntroduzca un nº entero: ");
			tabla[i] = sc.nextInt();
		}
		
		System.out.println("\nTABLA:\n");
		
		for (int valor : tabla) {
			if (valor % 2 == 0) {
				System.out.println(valor + " -> par");
			} else {
				System.out.println(valor + " -> impar");
			}
		}
		
		sc.close();
		
	}
}
