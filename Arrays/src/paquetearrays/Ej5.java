package paquetearrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ej5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] tabla = new double[10];
		double suma = 0;
		double min = Integer.MAX_VALUE;
		double max = Integer.MIN_VALUE;

		System.out.println("TABLA Nºs REALES\n===================");

		for (int i = 0; i < tabla.length; i++) {
			System.out.println("\nIntroduzca un nº: ");
			tabla[i] = sc.nextDouble();
		}
		
		for (int i = 0; i < tabla.length; i++) {
			suma += tabla[i];
			
			if (tabla[i] < min) {
				min = tabla[i];
			}
			
			if (tabla[i] > max) {
				max = tabla[i];
			}
			
		}
		
//		for (int i = 0; i < tabla.length; i++) {
//			
//			System.out.println("\nIntroduzca un nº: ");
//			tabla[i] = sc.nextDouble();
//			
//			suma += tabla[i];
//			
//			if (tabla[i] < min) {
//				min = tabla[i];
//			}
//			
//			if (tabla[i] > max) {
//				max = tabla[i];
//			}
//			
//		}

		System.out.println("\nTABLA:\n" + Arrays.toString(tabla));
		System.out.println("Suma: " + suma);
		System.out.println("Mínimo: " + min);
		System.out.println("Máximo: " + max);
		
		sc.close();

	}
}