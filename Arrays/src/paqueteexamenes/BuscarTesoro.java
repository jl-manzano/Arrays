package paqueteexamenes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscarTesoro {

	public static Scanner sc = new Scanner(System.in);

	public static char[][] t;
	public static int posI;
	public static int posJ;

	public static void inicializaTablero(int numFilas, int numColumnas) {
		t = new char[numFilas][numColumnas];

		for (char[] fila : t) {
			Arrays.fill(fila, ' ');
		}
	}

	public static void generaPosicionTesoro() {
		Random rand = new Random();
		int i = rand.nextInt(t.length);
		int j = rand.nextInt(t[0].length);

		t[i][j] = 'X';

	}

	public static void generaObstaculos(int numObstaculos) {
		Random rand = new Random();
		int contador = 0;
		int fila;
		int col;

		while (contador < numObstaculos) {
			fila = rand.nextInt(t.length);
			col = rand.nextInt(t[0].length);

			if (t[fila][col] == ' ' && !obstaculosAlrededor(fila, col)) {
				t[fila][col] = '*';
				contador++;
			}

		}

	}

	private static boolean obstaculosAlrededor(int filaO, int colO) {
		boolean res = false;
		int i = filaO - 1 < 0 ? 0 : filaO - 1;
		int j;

		while (i < t.length && i <= filaO + 1 && !res) {
			j = colO - 1 < 0 ? 0 : colO - 1;
			while (j < t[i].length && j <= colO + 1 && !res) {
				if (t[i][j] == '*') {
					res = true;
				}

				j += 2;
			}

			i += 2;

		}

		return res;

	}

	public static void generaPosicionJugador() {
		Random rand = new Random();

		do {
			posI = rand.nextInt(t.length);
			posJ = rand.nextInt(t[0].length);

		} while (t[posI][posJ] != ' ');

	}

	public static void pintaTablero() {

		for (int i = 0; i < t.length; i++) {
			System.out.print("\t" + (i + 1));
		}

		System.out.println();

		for (int i = 0; i < t.length; i++) {
			System.out.print((char) ('A' + i) + "\t");
			for (int j = 0; j < t[i].length; j++) {
				if (i == posI && j == posJ) {
					System.out.print("J\t");
				} else if (t[i][j] == 'X') {
					System.out.print(" " + "\t");
				} else {
					System.out.print(t[i][j] + "\t");
				}
			}

			System.out.println();

		}
	}

	public static int mueveJugador(String movimiento) {
		int res = 0;

		switch (movimiento) {
		case "ARRIBA" -> {
			if (posI - 1 >= 0 && t[posI - 1][posJ] != '*') {
				posI--;
			} else {
				res = -1;
			}
		}
		case "ABAJO" -> {
			if (posI + 1 < t.length && t[posI + 1][posJ] != '*') {
				posI++;
			} else {
				res = -1;
			}
		}
		case "IZQUIERDA" -> {
			if (posJ - 1 >= 0 && t[posI][posJ - 1] != '*') {
				posJ--;
			} else {
				res = -1;
			}
		}
		case "DERECHA" -> {
			if (posJ + 1 < t[0].length && t[posI][posJ + 1] != '*') {
				posJ++;
			} else {
				res = -1;
			}
		}
		default -> res = -2;

		}
		
		return res;
	}

}
