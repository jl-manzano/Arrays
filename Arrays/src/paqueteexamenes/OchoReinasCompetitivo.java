package paqueteexamenes;

import java.util.Scanner;

public class OchoReinasCompetitivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JugadorOchoReinas jugador1 = new JugadorOchoReinas("Jugador 1");
        JugadorOchoReinas jugador2 = new JugadorOchoReinas("Jugador 2");
        JugadorOchoReinas turno = jugador1;
        boolean juegoTerminado = false;
        int columna;
        int fila = -1;

        while (!juegoTerminado) {
            System.out.println("\nTurno de " + turno.getNombre());
            System.out.println(turno);
            columna = turno.getReinaActual();

            if (columna >= 8) {
                System.out.println(turno.getNombre() + " ha colocado todas las reinas y gana!");
                juegoTerminado = true;
            } else {
                boolean valido = false;
                boolean entradaValida = false;

                while (!valido) {
                    System.out.println("Introduce la fila para colocar la reina en columna " + (columna + 1) + " (1-8): ");
                    try {
                        fila = sc.nextInt() - 1;
                        entradaValida = true;
                    } catch (Exception e) {
                        System.out.println("Entrada inválida. Introduce un número del 1 al 8.");
                        sc.nextLine();
                        entradaValida = false;
                    }

                    if (entradaValida) {
                        if (fila < 0 || fila >= 8) {
                            System.out.println("Fila fuera de rango.");
                        } else {
                            if (!esValidoColocar(turno.getTablero(), fila, columna)) {
                                System.out.println("No se puede colocar reina ahí, conflicto.");
                            } else {
                                valido = true;
                            }
                        }
                    }
                }

                turno.getTablero()[fila][columna] = 'R';
                turno.incrementarReina();

                if (turno == jugador1) {
                    turno = jugador2;
                } else {
                    turno = jugador1;
                }
            }
        }

        sc.close();
    }

    public static boolean esValidoColocar(char[][] tablero, int fila, int col) {
        boolean esValido = true;
        int c = 0;
        int filaDiagSup;
        int filaDiagInf;

        while (c < col && esValido) {
            if (tablero[fila][c] == 'R') {
                esValido = false;
            }

            filaDiagSup = fila - (col - c);
            if (filaDiagSup >= 0 && tablero[filaDiagSup][c] == 'R') {
                esValido = false;
            }

            filaDiagInf = fila + (col - c);
            if (filaDiagInf < 8 && tablero[filaDiagInf][c] == 'R') {
                esValido = false;
            }

            c++;
        }
        return esValido;
    }
}
