package paquetearrays2;

import java.util.Arrays;
import java.util.Scanner;

public class Ej2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] tabla1 = new int[10];
		int[] tabla2 = new int[10];
		
		int num;
		
		System.out.println("PEDIR 20 NºS");
		
		for (int i = 0; i < 20; i++) {
			System.out.println("\nIntroduce un nº:");
			num = sc.nextInt();
			
			if (i < 10) {
				tabla1[i] = num;
			} else {
				tabla2[i - 10] = num;
			}
		}
		
		System.out.println("\nTabla 1: \n" + Arrays.toString(tabla1));
		
		System.out.println("\nTabla 2: \n" + Arrays.toString(tabla2));

		
		if (Arrays.equals(tabla1, tabla2)) {
			System.out.println("\nAmbas tablas son iguales");
		} else {
			System.out.println("\nLas tablas no son iguales");
		}
		
		sc.close();
		
	}
}
