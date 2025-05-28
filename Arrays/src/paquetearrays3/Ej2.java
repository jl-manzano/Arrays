package paquetearrays3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double[][] notas = new double[4][5];
		double nota;
		double max = Integer.MIN_VALUE;
		double min = Integer.MAX_VALUE;
		double suma = 0;
		
		System.out.println("IES NERVIÓN\n===========");
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				do {
					try {
						System.out.println("\nIntroduce la nota " + (j+1) + " del alumno " + (i+1) + ":");
						nota = sc.nextInt();
						notas[i][j] = nota;
						assert notas[i][j] >= 0 && notas[i][j] <= 10 : "Introduce una nota válida (0-10).";
					} catch(AssertionError e) {
						System.out.println(e.getMessage());
					} catch(InputMismatchException e) {
						System.out.println("Introduce un nº real.");
					}
				} while (notas[i][j] < 0 || notas[i][j] > 10);
			}
		}
		
		for (int i = 0; i < notas.length; i++) {
			System.out.print("Alumno " + (i+1) + "\t");
			for (int j = 0; j < notas[i].length; j++) {
				System.out.print(notas[i][j] + "\t");
				
				suma += notas[i][j];
				
				if (min > notas[i][j]) {
					min = notas[i][j];
				}
				
				if (max < notas[i][j]) {
					max = notas[i][j];
				}
			}
		
			System.out.println();
			
		}
		
		System.out.println("\nNota mínima: " + min);
		System.out.println("Nota máxima: " + max);
		System.out.println("Promedio: " + (suma / 20));
		
		sc.close();
		
	}
}
