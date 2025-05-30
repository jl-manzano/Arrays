package paqueteexamenes;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TresEnRaya {

	static char[][] t;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final char O = 'O';
		final char X = 'X';

		Jugador3EnRaya jugador;
		Jugador3EnRaya maquina;
		Jugador3EnRaya jugP;

		int fila = -1;
		int col = -1;

		String resp;
		boolean continuarJuego = true;
		boolean ganador = false;
		boolean lleno = false;
		boolean valido = false;

		System.out.println("BIENVENIDO AL JUEGO DEL 3 EN RAYA\n=================================");

		while (continuarJuego) {
			t = new char[3][3];
			limpiarTablero();

			jugador = new Jugador3EnRaya("Usuario", X);
			maquina = new Jugador3EnRaya("Máquina", O);

			jugP = jugadorInicial() == 0 ? jugador : maquina;

			System.out.println(jugP);

			while (!ganador && !lleno) {
				if (jugP == jugador) {
					valido = false;

					while (!valido) {
						do {
							try {
								System.out.println("Introduce la fila");
								fila = sc.nextInt() - 1;

								assert fila >= 0 && fila < 3 : "Fila fuera de rango. Intenta de nuevo.";
							} catch (AssertionError e) {
								System.out.println(e.getMessage());
							} catch (InputMismatchException e) {
								System.out.println("Entrada inválida. Introduce un número.");
							} finally {
								sc.nextLine();
							}
						} while (fila < 0 || fila >= 3);

						do {
							try {
								System.out.println("Introduce la columna");
								col = sc.nextInt() - 1;

								assert col >= 0 && col < 3 : "Columna fuera de rango. Intenta de nuevo.";
							} catch (AssertionError e) {
								System.out.println(e.getMessage());
							} catch (InputMismatchException e) {
								System.out.println("Entrada inválida. Introduce un número.");
							} finally {
								sc.nextLine();
							}
						} while (col < 0 || col >= 3);

						valido = usuarioMueveFicha(fila, col, jugP);

						if (!valido) {
							System.out.println("Casilla ocupada, intenta otra posición.");
						}
					}
				} else {
					mueveFichaAleatoria(jugP);
				}

				ganador = esGanador(jugP);
				lleno = tableroLleno();

				if (!ganador && !lleno) {
					jugP = (jugP == jugador) ? maquina : jugador;
				}

				System.out.println("\n" + jugP);
			}

			if (ganador) {
				System.out.println("¡Ha ganado " + jugP.getNombre() + "!");
			} else {
				System.out.println("Empate.");
			}

			System.out.print("¿Quieres jugar otra vez? (s/n): ");
			resp = sc.next();
			continuarJuego = resp.equalsIgnoreCase("s");
		}

		System.out.println("¡ADIOS!");
		sc.close();
	}

	public static int jugadorInicial() {
		Random rand = new Random();

		return rand.nextInt(2);

	}

	public static void mueveFichaAleatoria(Jugador3EnRaya jug) {
		Random rand = new Random();
		int i;
		int j;

		do {
			i = rand.nextInt(t.length);
			j = rand.nextInt(t[0].length);
		} while (t[i][j] != '-');
		t[i][j] = jug.getFicha(); // actualizar tablero común
		jug.getT()[i][j] = jug.getFicha(); // actualizar tablero jugadors
		System.out.println("La máquina colocó ficha en fila " + (i + 1) + ", columna " + (j + 1));
	}

	public static boolean usuarioMueveFicha(int posI, int posJ, Jugador3EnRaya jug) {
		boolean res = false;
		if (t[posI][posJ] == '-') {
			t[posI][posJ] = jug.getFicha(); // actualizar tablero común
			jug.getT()[posI][posJ] = jug.getFicha(); // actualizar tablero jugador
			res = true;
		}
		return res;
	}

	public static void limpiarTablero() {
		for (char[] fila : t) {
			Arrays.fill(fila, '-');
		}
	}

	public static boolean esGanador(Jugador3EnRaya jug) {
		return comprobarFilas(jug) || diagonales1(jug) || diagonales2(jug);
	}

	public static boolean comprobarFilas(Jugador3EnRaya jug) {
		int i = 0;
		boolean res = false;
		boolean auxRes = true;
		int j;

		while (i < t.length && !res) {
			j = 0;
			while (j < t[i].length && auxRes) {
				if (t[i][j] != jug.getFicha()) {
					auxRes = false;
				}

				j++;

			}

			res = auxRes;
			auxRes = true;
			i++;
		}

		return res;

	}

	public static boolean comprobarCols(Jugador3EnRaya jug) {
		int j = 0;
		boolean res = false;
		boolean auxRes = true;
		int i;

		while (j < t[0].length && !res) {
			i = 0;
			while (i < t.length && !auxRes) {
				if (t[i][j] != jug.getFicha()) {
					auxRes = false;
				}

				i++;
			}

			res = auxRes;
			auxRes = true;
			j++;
		}

		return res;

	}

	public static boolean diagonales1(Jugador3EnRaya jug) {
		int i = 0;
		boolean res = true;

		while (i < t.length && res) {
			if (t[i][i] != jug.getFicha()) {
				res = false;
			}

			i++;
		}

		return res;

	}

	public static boolean diagonales2(Jugador3EnRaya jug) {
		int i = 0;
		boolean res = true;

		while (i < t.length && res) {
			if (t[i][t.length - i - 1] != jug.getFicha()) {
				res = false;
			}
			i++;
		}

		return res;
	}

	public static boolean tableroLleno() {
		boolean lleno = true;
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][j] == '-') {
					lleno = false;
				}
			}

		}

		return lleno;
	}

}
