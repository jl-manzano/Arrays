package paquetearrays4;

public class Ej1 {

	public static void main(String[] args) {
		int[] enteros = { 6, 22, 20, 19, 36, 7 };
		
		System.out.println("SUMA ENTEROS\n============");
		System.out.println(sumaEnteros(enteros));
	}
	
	static int sumaEnteros(int[] tabla) {
		int total = 0;
		
		for (int valor : tabla) {
			total += valor;
		}
		
		return total;
	}
}
