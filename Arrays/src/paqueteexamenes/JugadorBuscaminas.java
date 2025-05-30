package paqueteexamenes;

import java.util.Arrays;

public class JugadorBuscaminas {
	private String nombre;
	private char[][] t;
	private int numCasillasRes;

	public JugadorBuscaminas(String nombre, int filas, int columnas, int numMinas) {
		this.nombre = nombre;
		t = new char[filas][columnas];
		for (int i = 0; i < t.length; i++) {
			Arrays.fill(t[i], '-');
		}

		this.numCasillasRes = filas * columnas - numMinas;
	}

	public String getNombre() {
		return nombre;
	}

	public char[][] getT() {
		return t;
	}

	public int getNumCasillasRes() {
		return numCasillasRes;
	}

	public void decrementarNumCasillasRes() {
		if (numCasillasRes > 0) {
			numCasillasRes--;
		}
	}

	public String toString() {
		String res = "\t";
		for (int i = 0; i < t[0].length; i++) {
			res += (i + 1) + "\t";
		}

		res += "\n";

		for (int i = 0; i < t.length; i++) {
			res += (i + 1) + "\t";
			for (int j = 0; j < t[i].length; j++) {
				res += t[i][j] + "\t";

			}

			res += "\n";

		}

		return res;

	}

}
