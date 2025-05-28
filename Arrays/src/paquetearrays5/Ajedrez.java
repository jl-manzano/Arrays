package paquetearrays5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ajedrez {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		char[][] tableroAjedrez = new char[8][8];
		int posFila = -1;
		int posCol = -1;
		char pieza = ' ';

		System.out.println("AJEDREZ");
		posFila = pedirEntero("Introduce la fila (0-7):", 0, 7);
		posCol = pedirEntero("Introduce la columna (0-7):", 0, 7);

		menu();

		System.out.print("\nIntroduce la pieza (T, A, D, C):");
		pieza = sc.next().toUpperCase().charAt(0);

		switch (pieza) {
		case 'T' -> {
			tableroAjedrez = torre(posFila, posCol, pieza);
		}
		case 'A' -> {
			tableroAjedrez = alfil(posFila, posCol, pieza);
		}
		case 'D' -> {
			tableroAjedrez = dama(posFila, posCol, pieza);
		}
		case 'C' -> {
			tableroAjedrez = caballo(posFila, posCol, pieza);
		}
		default -> {
			System.out.println("\nPieza inválida, debe ser T, A, D o C");
		}
		}

		System.out.println();

		for (int i = 0; i < tableroAjedrez.length; i++) {
			for (int j = 0; j < tableroAjedrez[i].length; j++) {
				System.out.print(tableroAjedrez[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();

	}

	static char[][] torre(int posFila, int posCol, char pieza) {
		char[][] t = new char[8][8];

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = '*';
			}
		}

		t[posFila][posCol] = 'T';

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][posCol] == '*') {
					t[i][posCol] = 'X';
				}

				if (t[posFila][j] == '*') {
					t[posFila][j] = 'X';
				}

			}
		}

		return t;

	}

	static char[][] alfil(int posFila, int posCol, char pieza) {
		char[][] t = new char[8][8];
		int contador = 0;

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = '*';
			}
		}

		t[posFila][posCol] = 'A';

		// parte superior
		for (int i = posFila; i >= 0; i--) {
			for (int j = 0; j < t[i].length; j++) {
				if (j != posCol) {
					if (j == (posCol - contador) || j == (posCol + contador)) {
						t[i][j] = 'X';
					}
				}
			}

			contador++;

		}

		contador = 0;

		for (int i = posFila; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if (j != posCol) {
					if (j == (posCol - contador) || j == (posCol + contador)) {
						t[i][j] = 'X';
					}
				}
			}

			contador++;

		}

		return t;

	}

	static char[][] dama(int posFila, int posCol, char pieza) {
		char[][] t = new char[8][8];
		int contador = 0;

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = '*';
			}
		}

		t[posFila][posCol] = 'D';

		// movimiento torre
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][posCol] == '*') {
					t[i][posCol] = 'X';
				}

				if (t[posFila][j] == '*') {
					t[posFila][j] = 'X';
				}
			}

		}

		// parte superior
		for (int i = posFila; i >= 0; i--) {
			for (int j = 0; j < t[i].length; j++) {
				if (j != posCol) {
					if (j == (posCol - contador) || j == (posCol + contador)) {
						t[i][j] = 'X';
					}
				}
			}
			contador++;
		}

		contador = 0;

		// parte inferior
		for (int i = posFila; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if (j != posCol) {
					if (j == (posCol - contador) || j == (posCol + contador)) {
						t[i][j] = 'X';
					}
				}
			}
			contador++;
		}

		return t;

	}

	static char[][] caballo(int posFila, int posCol, char pieza) {
		char[][] t = new char[8][8];

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = '*';
			}
		}

		t[posFila][posCol] = 'C';

		// parte superior
		for (int i = posFila; i >= 0; i--) {
			for (int j = 0; j < t[i].length; j++) {
				if ((i == posFila - 1 && j == posCol + 2) || (i == posFila - 2 && j == posCol + 1)) {
					t[i][j] = 'X';
				} else if ((i == posFila - 1 && j == posCol - 2) || (i == posFila - 2 && j == posCol - 1)) {
					t[i][j] = 'X';

				}
			}
		}

		// parte inferior
		for (int i = posFila; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if ((i == posFila + 1 && j == posCol + 2) || (i == posFila + 2 && j == posCol + 1)) {
					t[i][j] = 'X';
				} else if ((i == posFila + 1 && j == posCol - 2) || (i == posFila + 2 && j == posCol - 1)) {
					t[i][j] = 'X';

				}
			}
		}

		return t;

	}

	static void menu() {
		System.out.println("\nMOVIMIENTOS DE AJEDREZ\n======================");
		System.out.println("T. Movimientos Torre");
		System.out.println("A. Movimientos Alfil");
		System.out.println("D. Movimientos Dama");
		System.out.println("C. Movimientos Caballo");
		System.out.println("Elije una pieza:");
	}

	static int pedirEntero(String mensaje, int valorMin, int valorMax) {
		int valor = -1;

		do {
			try {
				System.out.println(mensaje);
				valor = sc.nextInt();
				assert valor >= valorMin && valor <= valorMax
						: "El valor debe estar entre " + valorMin + " y " + valorMax + ".";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} finally {
				sc.nextLine();
			}

		} while (valor < valorMin || valor > valorMax);

		return valor;

	}

}
