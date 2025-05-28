package paquetearrays4;

public class Ej2 {
	public static void main(String[] args) {
		int[] tabla = { 22, 10, 6, 7, 4 }; 
		
		System.out.println("VALOR MÁXIMO TABLA\n==================");
		System.out.println(maximo(tabla));
	}
	
	static int maximo(int t[]) {
		int max = Integer.MIN_VALUE;
		
		for (int valor : t) {
			if (valor > max) {
				max = valor;
			}
		}
		
		return max;
	}
}
