package paqueteexamenes;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HundirLaFlota {

	static Scanner sc = new Scanner(System.in);

	static final char GUION = '-';
	static final char A = 'A';
	static final char B = 'B';

	public static void main(String[] args) {
		char[][] t;
		char[][] tJ1;
		char[][] tJ2;
		char[][] tActual;
		int filas;
		int cols;
		int numBarquitos;
		int turno = 1;
		int contJ1 = 0;
		int contJ2 = 0;
		boolean descubierto = false;

		System.out.println("HUNDIR LA FLOTA\n===============");
		System.out.println("Introduzca el número de filas de su tablero: ");
		filas = sc.nextInt();

		System.out.println("Introduzca el número de columnas de su tablero: ");
		cols = sc.nextInt();

		numBarquitos = (int) Math.sqrt(filas * cols);

		System.out.println("\nTABLERO JUEGO");
		System.out.println("Nº de barcos: " + numBarquitos + "\n");
		t = creaTablero(filas, cols);
		generarBarquitos(t, numBarquitos);
		pintaTablero(t);

		tJ1 = inicializaTablero(filas, cols);
		tJ2 = inicializaTablero(filas, cols);

		do {
			System.out.println("\nTurno del jugador " + turno + ":");
			tActual = (turno == 1) ? tJ1 : tJ2;
			descubierto = turnoJugador(t, tActual);

			if (descubierto) {
				if (turno == 1) {
					contJ1++;
				} else {
					contJ2++;
				}
			}

			pintaTablero(tActual);

			if (!descubierto) {
				turno = (turno == 1) ? 2 : 1;
			}
			
		} while (contJ1 < numBarquitos || contJ2 < numBarquitos);

        if (contJ1 == numBarquitos) {
            System.out.println("¡El Jugador 1 ha ganado!");
        } else {
            System.out.println("¡El Jugador 2 ha ganado!");
        }
		
	}

	static char[][] inicializaTablero(int filas, int columnas) {
		char[][] t = new char[filas][columnas];

		for (char[] fila : t) {
			Arrays.fill(fila, GUION);
		}

		return t;

	}

	static char[][] creaTablero(int filas, int columnas) {
		char[][] t = new char[filas][columnas];

		for (char[] fila : t) {
			Arrays.fill(fila, A);
		}

		return t;
	}

	static void generarBarquitos(char tablero[][], int numBarquitos) {
		Random rand = new Random();

		int contador = 0;
		int posFila;
		int posCol;

		while (contador < numBarquitos) {
			posFila = rand.nextInt(tablero.length);
			posCol = rand.nextInt(tablero[0].length);

			if (tablero[posFila][posCol] == 'A') {
				tablero[posFila][posCol] = 'B';
			}

			contador++;

		}
	}

	static void pintaTablero(char tableroJugador[][]) {
		for (int j = 0; j < tableroJugador[0].length; j++) {
			System.out.print("\t" + (j + 1));
		}

		System.out.println();

		for (int i = 0; i < tableroJugador.length; i++) {
			System.out.print((char) (A + i) + "\t");
			for (int j = 0; j < tableroJugador[i].length; j++) {
				System.out.print(tableroJugador[i][j] + "\t");
			}

			System.out.println();

		}

	}

	static boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
		char letraFila = ' ';
		int col = -1;
		int fila = -1;
		boolean descubierto = false;

		do {

			try {
				System.out.println(
						"\nIntroduce una fila mediante una letra (" + A + "-" + (char) (A + tablero.length - 1) + "):");
				letraFila = sc.next().toUpperCase().charAt(0);
				fila = letraFila - A;

				assert letraFila >= A && letraFila <= (char) (A + tablero.length - 1)
						: "\nERROR. Introduce una fila válida (" + A + "-" + (A + tablero.length - 1) + ").";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} finally {
				sc.nextLine();
			}
		} while (letraFila < A || letraFila > (char) (A + tablero.length - 1));

		do {
			try {
				System.out.println("\nIntroduce el número de columna (1" + "-" + (tablero.length) + "):");
				col = sc.nextInt() - 1;

				assert col >= 0 && col < tablero[0].length : "";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} finally {
				sc.nextLine();
			}
		} while (col < 0 || col >= tablero[0].length);

		if (tablero[fila][col] == B) {
			System.out.println("\nHUNDIDO\n");
			tableroJugador[fila][col] = B;
			descubierto = true;
		} else {
			System.out.println("\nAGUA\n");
			tableroJugador[fila][col] = A;

		}

		return descubierto;

	}

}
