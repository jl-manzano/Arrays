package paquetearrays3;

import java.util.Random;

public class Ej5 {
	public static void main(String[] args) {
		Random rand = new Random();

		int[][] tabla = new int[4][5];
		int sumaFila = 0;
		int sumaCol = 0;
		int total = 0;

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
				tabla[i][j] = rand.nextInt(100, 1000);
			}
		}
		
		System.out.println("TABLA\n=====\n");

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
					System.out.print(tabla[i][j] + "\t");
					sumaFila += tabla[i][j];
			}
			
			System.out.println(sumaFila);
			total += sumaFila;
			sumaFila = 0;
			
		}

		for (int j = 0; j < tabla[0].length; j++) {
			for (int i = 0; i < tabla.length; i++) {
				sumaCol += tabla[i][j];
			}

				System.out.print(sumaCol + "\t");
				total += sumaCol;
				sumaCol = 0;
			
		}
		
		System.out.print(total);
		
	}

}