package paqueteexamenes;

import java.util.Scanner;

import static paqueteexamenes.TresEnRaya.*;

public class MainTresEnRaya {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean	juegoCont = true;
		boolean movValido = false;
		boolean ganador = false;
		int turno;
		int fila;
		int col;
		
	}
	
	public static boolean tableroLleno() {
	    boolean lleno = true;
	    for (int i = 0; i < t.length && lleno; i++) {
	        for (int j = 0; j < t[i].length && lleno; j++) {
	            if (t[i][j] == VACIO) {
	                lleno = false;
	            }
	        }
	    }
	    return lleno;
	}
	
    private static void imprimirTablero() {
        System.out.println("Estado actual del tablero:");
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
