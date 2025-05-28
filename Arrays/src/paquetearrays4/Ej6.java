package paquetearrays4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] tabla = { 10, 1, 5, 8, 9, 2 };
		int[] tablaRes;
		int numElementos = 0;
		
		do {
			try {
				System.out.println("Introduce de cuánto en cuánto agrupar los elementos de la tabla:");
				numElementos = sc.nextInt();
				assert numElementos >= 2 : "Debe introducir un entero >= 2.";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} finally {
				sc.nextLine();
			}
		} while (numElementos < 2);
		
		tablaRes = suma(tabla, numElementos);
		
		System.out.println(Arrays.toString(tablaRes));
		
		sc.close();
		
	}
	
	static int[] suma(int t[], int numElementos) {
		int[] res = new int[t.length - numElementos + 1];
		
		for (int i = 0; i < res.length; i++) {
			for (int j = i; j < i + numElementos; j++) {
				res[i] += t[j];  
			}
		}
		
		return res;
	}
	
}
