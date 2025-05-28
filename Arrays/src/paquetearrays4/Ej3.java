package paquetearrays4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ej3 {
	public static void main(String[] args) {
		int[] t;
		int longitud;
		int valorFinalPosible;
		
		System.out.println("TABLA ALEATORIA PIDIENDO LONGITUD Y ÚLTIMO VALOR POSIBLE:");
		longitud = pedirNumeroEntero("\nIntroduzca la longitud de la tabla:");
		valorFinalPosible = pedirNumeroEntero("\nIntroduzca el valor final posible generado ('inclusive'):");
		t = rellenaPares(longitud, valorFinalPosible);
		
		System.out.println("\n" + Arrays.toString(t));
		
	}
	
	static int[] rellenaPares(int longitud, int fin) {
		Random rand = new Random();
		
		int[] t = new int[longitud];
		int aleat;
		int contador = 0;
		
		while (contador < t.length) {
			aleat = rand.nextInt(2, fin + 1);
			
			if (aleat % 2 == 0) {
				t[contador] = aleat;
				contador++;
			}
						
		}
		
		Arrays.sort(t);
		
		return t;
		
	}
	
	static int pedirNumeroEntero(String mensaje) {
		Scanner sc = new Scanner(System.in);
		int dato = 0;

		do {
			try {
				System.out.println(mensaje);
				dato = sc.nextInt();

				assert dato >= 2 : "Introduzca un número positivo >= 2";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número entero.");
			} finally {
				sc.nextLine();
			}
		} while (dato < 2);
		
		sc.close();
		
		return dato;

	}
	
}
