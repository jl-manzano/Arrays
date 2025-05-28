package paquetearrays5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] resultado = new char[8][8];
		int posFila = -1;
		int posCol = -1;
		char pieza = ' ';

		do {
			try {
				System.out.print("Introduce la fila (0-7): ");
				posFila = sc.nextInt();
				assert posFila >= 0 && posFila <= 7 : "La fila debe estar entre 0 y 7.";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} finally {
				sc.nextLine();
			}
		} while (posFila < 0 || posFila > 7);

		do {
			try {
				System.out.print("Introduce la columna (0-7): ");
				posCol = sc.nextInt();
				assert posCol >= 0 && posCol <= 7 : "La columna debe estar entre 0 y 7.";
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} finally {
				sc.nextLine();
			}
		} while (posCol < 0 || posCol > 7);

		System.out.print("Introduce la pieza (T, A, D, C):");
		pieza = sc.next().toUpperCase().charAt(0);

		switch (pieza) {
		case 'T' -> {
			resultado = torre(posFila, posCol, pieza);
		}
		case 'A' -> {
			resultado = alfil(posFila, posCol, pieza);
		}
		case 'D' -> {
			resultado = dama(posFila, posCol, pieza);
		}
		case 'C' -> {
			resultado = caballo(posFila, posCol, pieza);
		}
		default -> {
			System.out.println("Pieza inválida, debe ser T, A, D o C");
		}

		}

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				System.out.print(resultado[i][j] + " ");
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
			if (t[i][posCol] == '*') {
				t[i][posCol] = 'X';
			}
			for (int j = 0; j < t[i].length; j++) {
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

		contador = 0;

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

		// tipo torre
		for (int i = 0; i < t.length; i++) {
			if (t[i][posCol] == '*') {
				t[i][posCol] = 'X';
			}
			for (int j = 0; j < t[i].length; j++) {
				if (t[posFila][j] == '*') {
					t[posFila][j] = 'X';
				}
			}
		}

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

		contador = 0;

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

		return t;

	}

}
