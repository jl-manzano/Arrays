package paqueteexamenes;

import java.util.Arrays;

public class Jugador3EnRaya {
	private String nombre;
	private char ficha;
	private char[][] t;

	public Jugador3EnRaya(String nombre, char ficha, int filas, int cols) {
		this.nombre = nombre;
		this.ficha = ficha;

		t = new char[filas][cols];

		for (int i = 0; i < t.length; i++) {
			Arrays.fill(t[i], '-');
		}
	}

	public String getNombre() {
		return nombre;
	}

	public char[][] getT() {
		return t;
	}

	@Override
	public String toString() {
		String res = "TURNO DEL JUGADOR " + nombre + "\nFICHA: " + ficha + "\n";

		for (int i = 0; i < t[0].length; i++) {
			res += "\t" + (i + 1);
		}

		res += "\n";

		for (int i = 0; i < t.length; i++) {
			res += ((i + 1) + "\t");
			for (int j = 0; j < t[i].length; j++) {
				res += t[i][j] + "\t";
			}

			res += "\n";
		}

		return res;
	}

}
