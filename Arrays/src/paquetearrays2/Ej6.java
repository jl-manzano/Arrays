package paquetearrays2;

import java.util.Arrays;
import java.util.Random;

public class Ej6 {
	public static void main(String[] args) {
		Random rand = new Random();

		int[] apuesta = new int[6];
		int[] apuestaGanadora = { 9, 17, 19, 20, 22, 36 };

		int contador = 0;
		int numAciertos = 0;
		int busqueda;
		int aleat;

		while (contador < 6) {
			aleat = rand.nextInt(1, 50);

			Arrays.sort(apuesta);

			busqueda = Arrays.binarySearch(apuesta, aleat);

			if (busqueda < 0) {
				apuesta[0] = aleat;
				contador++;
			}

		}
		
		for (int valor : apuesta) {
			busqueda = Arrays.binarySearch(apuestaGanadora, valor);
			
			if (busqueda >= 0) {
				numAciertos++;
			}
		}
		
		System.out.println("APUESTA GANADORA\n" + Arrays.toString(apuestaGanadora));
		System.out.println("\nAPUESTA\n" + Arrays.toString(apuesta));
		System.out.println("Nº DE ACIERTOS: " + numAciertos);

		

	}
}
