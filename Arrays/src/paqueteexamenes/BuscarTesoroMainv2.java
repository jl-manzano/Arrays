package paqueteexamenes;

import static paqueteexamenes.BuscarTesorov2.*;

public class BuscarTesoroMainv2 {
	public static void main(String[] args) {
		int filas;
		int cols;
		int numO;
		int res;
		String movimiento;
		boolean tesoroEnc = false;

		System.out.println("INTRODUCCIÓN A BUSCAR TESORO\n============================");

		do {
			System.out.println("Introduce el nº de filas del tablero:");
			filas = sc.nextInt();
			System.out.println("Introduce el nº de columnas del tablero:");
			cols = sc.nextInt();

			sc.nextLine();

		} while (filas < 2 && cols < 2);

		numO = (int) Math.sqrt(filas * cols) / 2;
		
		System.out.println("\nBIENVENIDO AL JUEGO DE BUSCAR EL TESORO\n=======================================");
		inicializaTablero(filas, cols);
		generaPosicionTesoro();
		generaObstaculos(numO);
		generaPosicionJugador();

		while (!tesoroEnc) {
			pintaTablero();
			System.out.println("\nIntroduce un movimiento (ARRIBA-ABAJO-IZQUIERDA-DERECHA):");
			movimiento = sc.nextLine().toUpperCase();
			res = mueveJugador(movimiento);

			if (res == -2) {
				System.out.println("\nMovimiento no válido\n");
			} else if (res == -1) {
				System.out.println("\nMovimiento no permitido\n");
			} else {
				System.out.println("\nMovimiento realizado\n");
			}
			
			if (t[posI][posJ] == 'X') {
				System.out.println("\n¡Enhorabuena, ha encontrado el tesoro!");
				tesoroEnc = true;
			}

		}

	}
}
