package paqueteexamenes;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BuscaMinas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int filas;
		int cols;
		int numMinas;
		int fila = -1;
		int col = -1;
		boolean juegoTerminado = false;

		JugadorBuscaminas maquina;
		JugadorBuscaminas jug1;
		JugadorBuscaminas jug2;
		JugadorBuscaminas turno;

		do {
			System.out.println("Introduce el número de filas (>=3): ");
			filas = sc.nextInt();
			sc.nextLine();
		} while (filas < 3);

		do {
			System.out.println("Introduce el número de columnas (>=3): ");
			cols = sc.nextInt();
			sc.nextLine();
		} while (cols < 3);


		numMinas = (int) Math.sqrt(filas * cols) / 2;
		
		maquina = new JugadorBuscaminas("Máquina", filas, cols, numMinas);
		insertarMinas(maquina.getT(), numMinas);
		comprobarMinasAlrededor(maquina.getT());

		jug1 = new JugadorBuscaminas("Jose", filas, cols, numMinas);
		jug2 = new JugadorBuscaminas("Luis", filas, cols, numMinas);

		System.out.println("¡Comienza el juego Buscaminas competitivo!");
		turno = jug1;

		while (!juegoTerminado) {
			System.out.println("\nTurno de " + turno.getNombre());
			System.out.println(turno); // imprime tablero jugador actual

			do {
				try {
					System.out.println("\nIntroduce la fila");
					fila = sc.nextInt() - 1;

					assert fila >= 0 && fila < maquina.getT().length : "\nFila fuera de rango. Intenta de nuevo.";
				} catch (AssertionError e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("\nEntrada inválida. Introduce un número.");
				} finally {
					sc.nextLine();
				}
			} while (fila < 0 || fila >= maquina.getT().length);

			do {
				try {
					System.out.println("\nIntroduce la columna");
					col = sc.nextInt() - 1;

					assert col >= 0 && col < maquina.getT()[0].length : "\nColumna fuera de rango. Intenta de nuevo.";
				} catch (AssertionError e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("\nEntrada inválida. Introduce un número.");
				} finally {
					sc.nextLine();
				}
			} while (col < 0 || col >= maquina.getT()[0].length);

			turno.getT()[fila][col] = maquina.getT()[fila][col];

			if (maquina.getT()[fila][col] == '*') {
			    System.out.println("¡BOOM!");
			    System.out.println("Gana " + (turno == jug1 ? jug2.getNombre() : jug1.getNombre()));
			    juegoTerminado = true;
			} else {
			    turno.decrementarNumCasillasRes();
			    if (turno.getNumCasillasRes() == 0) {
			        System.out.println("¡Ha ganado " + turno.getNombre() + "!");
			        juegoTerminado = true;
			    } else {
			        turno = (turno == jug1 ? jug2 : jug1);
			    }
			}


		}

		System.out.println("\nSOLUCIÓN");
		System.out.println(maquina);
		sc.close();
	}

	static void insertarMinas(char[][] tablero, int numMinas) {
		Random rand = new Random();

		int iMina;
		int jMina;

		while (numMinas > 0) {
			iMina = rand.nextInt(tablero.length);
			jMina = rand.nextInt(tablero[0].length);

			if (tablero[iMina][jMina] == '-' && !minasEnDiagonal(tablero, iMina, jMina)) {
				tablero[iMina][jMina] = '*';
				numMinas--;
			}

		}

	}

	private static boolean minasEnDiagonal(char[][] tablero, int posFilaMina, int posColumnaMina) {
		int i = posFilaMina - 1 < 0 ? 0 : posFilaMina - 1;
		int j = 0;
		boolean enc = false;

		while (i <= posFilaMina + 1 && i < tablero.length && !enc) {
			j = posColumnaMina - 1 < 0 ? 0 : posColumnaMina - 1;
			while (j <= posFilaMina + 1 && j < tablero[i].length && !enc) {
				if (tablero[i][j] == '*') {
					enc = true;
				}

				j += 2;

			}

			i += 2;

		}

		return enc;

	}

	static void comprobarMinasAlrededor(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] != '*') {
					tablero[i][j] = (char) ('0' + contarNumeroMinas(tablero, i, j));
				}
			}
		}
	}

	private static int contarNumeroMinas(char[][] tablero, int posCasillaI, int posCasillaJ) {
		int contador = 0;

		for (int i = posCasillaI - 1 < 0 ? 0 : posCasillaI - 1; i < tablero.length && i <= posCasillaI + 1; i++) {
			for (int j = posCasillaJ - 1 < 0 ? 0 : posCasillaJ - 1; j < tablero[i].length
					&& j <= posCasillaJ + 1; j++) {
				if (tablero[i][j] == '*') {
					contador++;
				}
			}
		}

		return contador;

	}

}
