package paquetearrays4;

import java.util.Arrays;
import java.util.Scanner;

public class Ej4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t[] = { 1, 2, 3, 4, 5, 6};
		int numBuscar;
		int busqueda;
		
		System.out.println("Introduzca un número a buscar en la tabla: ");
		numBuscar = sc.nextInt();
		
		busqueda = buscar(t, numBuscar);
		
		if (busqueda == -1) {
			System.out.println("\nEl nº " + numBuscar + " no se encuentra en la tabla.");
			System.out.println(Arrays.toString(t));
		} else {
			System.out.println("\nEl nº " + numBuscar + " se encuentra en la posición " + busqueda + " de la tabla.");
			System.out.println(Arrays.toString(t));
		}

		sc.close();
		
	}
	
	static int buscar(int t[], int clave) {
		int pos = -1;
		int indiceBusqueda = 0;
		
		while (indiceBusqueda < t.length && clave != t[indiceBusqueda]) {
			indiceBusqueda++;
		}
		
		if (indiceBusqueda < t.length) {
			pos = indiceBusqueda;
		}
		
		return pos;
	}
	
}
