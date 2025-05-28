package paquetearrays4;

public class Ej9 {
	public static void main(String[] args) {
		int tabla1[][] = { { 1, 2, 3 }, { 2, 4, 5 }, { 3, 5, 6 } };

		int tabla2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("TABLA1");
		for (int i = 0; i < tabla1.length; i++) {
			for (int j = 0; j < tabla1[i].length; j++) {
				System.out.print(tabla1[i][j] + "\t");
			}

			System.out.println();

		}

		if (esSimetrica(tabla1)) {
			System.out.println("\nLa tabla 1 es simétrica.");
		} else {
			System.out.println("\nLa tabla 1 no es simétrica.");
		}
	

		System.out.println("\nTABLA2");
		for (int i = 0; i < tabla2.length; i++) {
			for (int j = 0; j < tabla2[i].length; j++) {
				System.out.print(tabla2[i][j] + "\t");
			}
			
			System.out.println();

		}

		if (esSimetrica(tabla2)) {
			System.out.println("\nLa tabla 2 es simétrica.");
		} else {
			System.out.println("\nLa tabla 2 no es simétrica.");
		}

	}

	static boolean esSimetrica(int[][] t) {
		boolean res = true;

		if (t.length != t[0].length) {
			res = false;
		}

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][j] != t[j][i]) {
					res = false;
				}
			}
		}

		return res;
	}

}
