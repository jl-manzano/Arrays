package paqueteexamenes;

import java.util.Arrays;

public class PlayerFleet {
	private String nombre;
	private int numHundidos = 0;
	private char[][] t;

	public PlayerFleet(String nombre, int filas, int cols) {
		this.nombre = nombre;

		t = new char[filas][cols];

		for (char[] fila : t) {
			Arrays.fill(fila, '-');
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumHundidos() {
		return numHundidos;
	}
	
	public char[][] gett() {
		return t;
	}
	
	public int incrementarNumHundidos() {
		return numHundidos++;
	}
		
	public String toString() {
		char caracterA = 'A';
		String res = "\nTURNO DE " + nombre + "\n";

		for (int i = 0; i < t[0].length; i++) {
			res += "\t" + (i + 1);
		}

		res += "\n";

		for (int i = 0; i < t.length; i++) {
			res += (char) (caracterA + i) + "\t";
			for (int j = 0; j < t[i].length; j++) {
				res += t[i][j] + "\t";
			}

			res += "\n";

		}

		return res;

	}	

}
