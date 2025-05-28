package paquetearrays5;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ej5 {
	static Scanner sc = new Scanner(System.in);
	static final char O = 'O';
	static final char X = 'X';
	static final char VACIO = '-';
	static final int TAM = 3;

	public static void main(String[] args) {
		char[][] tablero = new char[TAM][TAM];
		inicializarTablero(tablero);
		mostrarTablero(tablero);
		jugar(tablero);
		
	}

	static char[][] inicializarTablero(char[][] t) {
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				t[i][j] = VACIO;
			}
		}

		return t;
	}

	static char[][] mostrarTablero(char[][] t) {
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}

		return t;
	}

	static char asignarTurno() {
		Random rand = new Random();
		char turno;

		if (rand.nextInt(2) == 0) {
			turno = O;
		} else {
			turno = X;
		}

		return turno;

	}

	static char cambiarTurno(char turno) {
		if (turno == O) {
			turno = X;
		} else {
			turno = O;
		}

		return turno;
	}

	static boolean tableroLleno(char[][] t) {
		boolean res = true;

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				if (t[i][j] == VACIO) {
					res = false;
				}
			}
		}

		return res;
	}

	static boolean esGanador(char[][] t) {
		boolean res = false;

		for (int i = 0; i < t.length; i++) {
			if ((t[i][0] == t[i][1] && t[i][1] == t[i][2])
					&& (t[i][0] != VACIO && t[i][1] != VACIO && t[i][2] != VACIO)) {
				res = true;
			}
		}

		for (int i = 0; i < t[0].length; i++) {
			if ((t[0][i] == t[1][i] && t[1][i] == t[2][i])
					&& (t[0][i] != VACIO && t[1][i] != VACIO && t[2][i] != VACIO)) {
				res = true;
			}
		}

		if ((t[0][0] == t[1][1] && t[1][1] == t[2][2]) && (t[0][0] != VACIO && t[1][1] != VACIO && t[2][2] != VACIO)) {
			res = true;
		}

		if ((t[0][2] == t[1][1] && t[1][1] == t[2][0]) && (t[0][2] != VACIO && t[1][1] != VACIO && t[2][0] != VACIO)) {
			res = true;
		}

		return res;

	}

	static void ponerFicha(char turno, char[][] t) {
		int fila = -1;
		int col = -1;

		do {
			try {
				System.out.println("Introduce una fila:");
				fila = sc.nextInt();

				System.out.println("Introduce una columna:");
				col = sc.nextInt();
				
				assert (fila >= 1 && fila <= TAM) && (col >= 1 && col <= TAM) && t[fila - 1][col - 1] == VACIO
						: "Debe introducir una fila y/o columna válida (1-3):";
				
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} finally {
				sc.nextLine();
			}
		} while ((fila < 1 || fila > TAM) || (col < 1 || col > TAM) || t[fila - 1][col - 1] != VACIO);

		t[fila - 1][col - 1] = turno;
		
	}

	static void jugar(char[][] t) {
		boolean ganador = false;
		boolean lleno = false;
		char turno = asignarTurno();

		while (!ganador && !lleno) {
			System.out.println("Turno: " + turno);
			ponerFicha(turno, t);
			mostrarTablero(t);
			ganador = esGanador(t);

			if (!ganador) {
				turno = cambiarTurno(turno);

				lleno = tableroLleno(t);
			}

		}

		if (ganador) {
			System.out.println("Ganador: " + turno);
		}

		if (lleno) {
			System.out.println("Tablero lleno.");
		}

	}

}
