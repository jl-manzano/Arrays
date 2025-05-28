package paquetearrays4;

public class Ej10 {
	public static void main(String[] args) {

		int tabla1[][] = { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };

		int tabla2[][] = { { 1, 2, 3 }, { 2, 4, 5 }, { 3, 5, 6 } };
		
		System.out.println("TABLA1");
		for (int i = 0; i < tabla1.length; i++) {
			for (int j = 0; j < tabla1[i].length; j++) {
				System.out.print(tabla1[i][j] + "\t");
			}

			System.out.println();

		}

		if (esMagica(tabla1)) {
			System.out.println("\nLa tabla 1 es mágica.");
		} else {
			System.out.println("\nLa tabla 1 no es mágica.");
		}

		System.out.println("\nTABLA2");
		for (int i = 0; i < tabla2.length; i++) {
			for (int j = 0; j < tabla2[i].length; j++) {
				System.out.print(tabla2[i][j] + "\t");
			}

			System.out.println();

		}
		
		if (esMagica(tabla2)) {
			System.out.println("\nLa tabla 2 es mágica.");
		} else {
			System.out.println("\nLa tabla 2 no es mágica.");
		}

		
	}

	static boolean esMagica(int tabla[][]) {
		boolean res = true;
		int sumaComparar = 0;
		int sumaFilas;
		int sumaCols;

		for (int j = 0; j < tabla[0].length; j++) {
			sumaComparar += tabla[0][j];
		}

		for (int i = 0; i < tabla.length; i++) {
			sumaFilas = 0;
			for (int j = 0; j < tabla[i].length; j++) {
				sumaFilas += tabla[i][j];
			}

			if (sumaFilas != sumaComparar) {
				res = false;
			}

		}

		for (int j = 0; j < tabla[0].length; j++) {
			sumaCols = 0;
			for (int i = 0; i < tabla.length; i++) {
				sumaCols += tabla[i][j];
			}

			if (sumaCols != sumaComparar) {
				res = false;
			}

		}

		return res;
	}

}
