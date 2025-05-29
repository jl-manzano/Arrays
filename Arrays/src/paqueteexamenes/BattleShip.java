package paqueteexamenes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BattleShip {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		char[][] tMaquina;
		int filas;
		int cols;
		int numBarquitos;
		boolean hundido = false;

		PlayerFleet j1;
		PlayerFleet j2;
		PlayerFleet jugP;

		System.out.println("BIENVENIDO AL HUNDIR LA FLOTA\n=============================");
		System.out.println("Introduzca el número de filas del tablero");
		filas = sc.nextInt();
		System.out.println("Introduzca el número de columnas del tablero");
		cols = sc.nextInt();

		numBarquitos = (int) Math.sqrt(filas * cols) / 2;

		j1 = new PlayerFleet("Jose", filas, cols);
		j2 = new PlayerFleet("Luis", filas, cols);

		tMaquina = creaTablero(filas, cols);
		generarBarquitos(tMaquina, numBarquitos);
		jugP = j1;

		while (jugP.getNumHundidos() < numBarquitos) {
			System.out.println(jugP);
			hundido = turnoJugador(tMaquina, jugP);

			if (!hundido) {
				jugP = (jugP == j1) ? j2 : j1;
			}
		}

		System.out.println("\nENHORABUENA! HA GANADO " + jugP.getNombre());
		sc.close();

	}

	public static char[][] creaTablero(int filas, int cols) {
		char[][] t = new char[filas][cols];

		for (int i = 0; i < t.length; i++) {
			Arrays.fill(t[i], 'A');
		}

		return t;
	}

	public static void generarBarquitos(char[][] tablero, int numBarquitos) {
		Random rand = new Random();
		int cont = 0;
		int i = 0;
		int j = 0;

		while (cont < numBarquitos) {
			i = rand.nextInt(tablero.length);
			j = rand.nextInt(tablero[0].length);

			if (tablero[i][j] != 'B') {
				tablero[i][j] = 'B';
				cont++;
			}
		}

	}

	public static boolean turnoJugador(char[][] tablero, PlayerFleet jug) {
		char fila;
		int col;
		boolean hundido = false;

		System.out.println("Introduce una fila como letra:");
		fila = sc.next().toUpperCase().charAt(0);
		System.out.println("Introduce una columna como número:");
		col = sc.nextInt();

		jug.gett()[fila - 'A'][col - 1] = tablero[fila - 'A'][col - 1];

		if (tablero[fila - 'A'][col - 1] == 'B') {
			hundido = true;
			System.out.println("HUNDIDO");
			jug.incrementarNumHundidos();
		} else {
			System.out.println("AGUA");
		}

		return hundido;

	}

}
