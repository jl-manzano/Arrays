package paquetearrays2;

import java.util.Arrays;

public class Ej7 {
	public static void main(String[] args) {
		int[] secuencia = new int[55];
		
		int inicio = 0;
		
		System.out.println("SECUENCIA DE VALORES");
		for (int i = 0; i <= 10; i++) {
			Arrays.fill(secuencia, inicio, inicio+i, i);
			inicio += i;
		}
		
		System.out.println(Arrays.toString(secuencia));
	}
}
