package paquetearrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ej2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] tabla = new double[5];
		
		System.out.println("TABLA Nºs DECIMALES\n===================");
		
		for (int i = 0; i < tabla.length; i++) {
			System.out.println("\nIntroduzca un nº decimal: ");
			tabla[i] = sc.nextDouble();
		}
		
		System.out.println("\nTABLA:\n" + Arrays.toString(tabla));
		
		sc.close();

	}
}
