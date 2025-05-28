package paquetearrays3;

public class Ej4 {
	public static void main(String[] args) {
		int[][] tabla = new int[10][10];

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				tabla[i][j] = (i + 1) * (j + 1);
			}
		}

		for (int i = 0; i < tabla.length; i++) {
			System.out.println("Tabla del " + (i + 1) + ":");
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.println((i + 1) + " * " + (j + 1) + " = " + tabla[i][j]);
			}

			System.out.println();

		}

	}
}
