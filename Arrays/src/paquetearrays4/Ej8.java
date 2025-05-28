package paquetearrays4;

public class Ej8 {
	public static void main(String[] args) {
		int[][] tabla = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };
		int[][] tablaRes;

		tablaRes = transposicion(tabla);

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.print(tabla[i][j] + "\t");
			}

			System.out.print("||\t");

			for (int j = 0; j < tablaRes[i].length; j++) {
				System.out.print(tablaRes[i][j] + "\t");
			}
			
			System.out.println();

		}

	}

	static int[][] transposicion(int t[][]) {
		int[][] tabla = new int[t[0].length][t.length];

		for (int j = 0; j < t[0].length; j++) {
			for (int i = 0; i < t.length; i++) {
				tabla[j][i] = t[i][j];
			}
		}

		return tabla;

	}

}
