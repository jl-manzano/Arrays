package paqueteexamenes;

import java.util.Arrays;

public class JugadorOchoReinas {
    private String nombre;
    private char[][] tablero;
    private int reinaActual;

    public JugadorOchoReinas(String nombre) {
        this.nombre = nombre;
        this.tablero = new char[8][8];
        this.reinaActual = 0;

        for (int i = 0; i < 8; i++) {
            Arrays.fill(tablero[i], '-');
        }
    }

    public String getNombre() {
        return nombre;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public int getReinaActual() {
        return reinaActual;
    }

    public void incrementarReina() {
        reinaActual++;
    }

    public String toString() {
        String res = "Jugador: " + nombre + "\n";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                res += tablero[i][j] + " ";
            }
            res += "\n";
        }
        return res;
    }
}
