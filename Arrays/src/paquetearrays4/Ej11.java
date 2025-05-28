package paquetearrays4;

public class Ej11 {
	public static void main(String[] args) {
		int tabla[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };
		int tabla90[][];
		
		for (int i = 0 ; i < tabla.length ; i++) {
			for (int j = 0 ; j < tabla[i].length ; j++) {
				System.out.print(tabla[i][j] + "\t");
			}
			System.out.println();
		}
		
		tabla90 = gira90(tabla);
		
		System.out.println();
		
		for (int i = 0 ; i < tabla90.length ; i++) {
			for (int j = 0 ; j < tabla90[i].length ; j++) {
				System.out.print(tabla90[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

	static int[][] gira90(int tablaInicio[][]) {
		int[][] tabla90 = new int[tablaInicio.length][tablaInicio[0].length];

		for (int j = 0; j < tablaInicio[0].length; j++) {
			for (int i = tablaInicio.length - 1; i >= 0; i--) {
				tabla90[j][tablaInicio.length - i - 1] = tablaInicio[i][j];
			}
		}

		return tabla90;
	}

}
