package paqueteexamenes;

import java.util.Arrays;
import java.util.Random;

public class TresEnRayaV1 {

	public static char[][] t;
	public static final char FICHA_P = 'O';
	public static final char FICHA_J = 'X';
	public static final char VACIO = '-';

	public static void inicializaTablero() {
		for (char[] fila : t) {
			Arrays.fill(fila, VACIO);
		}
	}

	public static int jugadorInicial() {
		Random rand = new Random();
		return rand.nextInt(2);
	}

	public static void mueveFichaAleatoria() {
		Random rand = new Random();
		int i;
		int j;

		do {
			i = rand.nextInt(t.length);
			j = rand.nextInt(t[0].length);
		} while (t[i][j] != VACIO);

		t[i][j] = FICHA_P;

	}

	public static boolean usuarioMueveFicha(int posI, int posJ) {
		boolean res = false;

		if (t[posI][posJ] == VACIO) {
			res = true;
		}

		return res;

	}

	public static void limpiarTablero() {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = VACIO;
			}
		}
	}

	public static boolean comprobarFilas(char jug) {
		int cont = 0;
		int i = 0; 
		
		while (i < t.length && cont < 3) {
			for(char c : t[i]) {
				if (c == jug) {
					cont++;
				}
			}
			
			i++;
		}
		
		return cont == 3;
	}

	public static boolean comprobarCols(char jug) {
		int cont = 0;
		int j = 0;
		
		while (j < t[0].length && cont < 3) {
			for (int i = 0; i < t.length; i++) {
				if (t[i][j] == jug) {
					cont++;
				}
			}
			
			j++;
		}
		
		return cont == 3;
		
	}

	public static boolean diagonalIzqDer(char jug) {
		int cont = 0;
		
		for (int i = 0; i < t.length; i++) {
			if (t[i][i] == jug) {
				cont++;
			}
		}
		
		return cont == 3;
		
	}

	public static boolean diagonalDerIzq(char jug) {
		int cont = 0;
		
		for (int i = 0; i < t.length; i++) {
			if (t[i][t.length - i - 1] == jug) {
				cont++;
			}
		}
		
		return cont == 3;
		
	}

}
