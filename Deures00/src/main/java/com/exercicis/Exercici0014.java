package com.exercicis;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;

public class Exercici0014 {

    // Genera una jugada aleatoria para el PC (PEDRA, PAPER, TISORES)
    public static String getMovePC() {
        String[] moves = {"PEDRA", "PAPER", "TISORES"}; // Array de movimientos posibles
        return moves[new Random().nextInt(moves.length)]; // Selecciona aleatoriamente uno de los movimientos
    }

    // Obtiene la jugada del jugador desde la entrada del teclado
    public static String getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.print("Escriu PEDRA, PAPER, TISORES o SORTIR: "); // Mensaje para el jugador
            String move = scanner.nextLine().toUpperCase(); // Lee la entrada y la convierte a mayúsculas

            if (move.equals("SORTIR")) { // Si el jugador escribe SORTIR, termina el juego
                return null;
            }
            if (move.equals("PEDRA") || move.equals("PAPER") || move.equals("TISORES")) { // Verifica si el movimiento es válido
                return move;
            }
        }
    }

    // Determina el ganador de la ronda según las reglas del juego
    public static String getWinner(String playerMove, String pcMove) {
        if (playerMove.equals(pcMove)) { // Si ambos movimientos son iguales, es un empate
            return "DRAW";
        }
        // Determina el ganador según las combinaciones posibles
        switch (playerMove) {
            case "PEDRA":
                return pcMove.equals("TISORES") ? "PLAYER" : "PC";
            case "PAPER":
                return pcMove.equals("PEDRA") ? "PLAYER" : "PC";
            case "TISORES":
                return pcMove.equals("PAPER") ? "PLAYER" : "PC";
            default:
                return "ERROR"; // Esto no debería ocurrir si las entradas son válidas
        }
    }

    // Genera un mensaje con el marcador actual
    public static String getScoreMessage(int playerScore, int pcScore) {
        return String.format("MARCADOR -> JUGADOR: %d - PC: %d", playerScore, pcScore);
    }

    // Mensaje para anunciar el ganador final
    public static String getWinnerMessage(boolean playerWon) {
        return playerWon ? "Felicitats! Has guanyat la partida!" : "Ho sento! Ha guanyat el PC!";
    }

    // Actualiza las estadísticas basadas en el movimiento del jugador y si ganó
    public static void updateStats(HashMap<String, Integer> stats, String move, boolean win) {
        String contador = move + "_COUNT"; // Clave para contar el movimiento
        stats.put(contador, stats.get(contador) + 1); // Incrementa el contador del movimiento

        if (win) { // Si ganó, incrementa también el contador de victorias para el movimiento
            String winKey = move + "_WINS";
            stats.put(winKey, stats.get(winKey) + 1);
        }
    }

    // Genera un mensaje basado en el resultado de la ronda
    public static String getMessage(String winner, String playerMove, String pcMove) {
        if (winner.equals("DRAW")) {
            return "Empat! Els dos heu triat " + playerMove + "!";
        }
        else if (winner.equals("PLAYER")) {
            return "Molt bé! " + playerMove + " guanya a " + pcMove + "!";
        }
        else {
            return "Ho sento! " + pcMove + " guanya a " + playerMove + "!";
        }
    }

    // Muestra las estadísticas finales del juego
    public static void showStats(HashMap<String, Integer> stats) {
        Integer totalGames = stats.get("PEDRA_COUNT") + stats.get("PAPER_COUNT") + stats.get("TISORES_COUNT"); // Total de partidas jugadas
        Integer totalWins = stats.get("PEDRA_WINS") + stats.get("PAPER_WINS") + stats.get("TISORES_WINS"); // Total de partidas ganadas

        // Determina el movimiento más utilizado
        String moveMostUsed = "PEDRA";
        Integer maxCount = stats.get("PEDRA_COUNT");

        if (stats.get("PAPER_COUNT") > maxCount) {
            moveMostUsed = "PAPER";
            maxCount = stats.get("PAPER_COUNT");
        }
        if (stats.get("TISORES_COUNT") > maxCount) {
            moveMostUsed = "TISORES";
            maxCount = stats.get("TISORES_COUNT");
        }

        // Determina el movimiento con mejor tasa de victorias
        String bestMove = "PEDRA";
        Double bestWinRate = stats.get("PEDRA_COUNT") > 0 ? 
            (double)stats.get("PEDRA_WINS") / stats.get("PEDRA_COUNT") * 100 : 0;
        
        Double paperWinRate = stats.get("PAPER_COUNT") > 0 ? (double)stats.get("PAPER_WINS") / stats.get("PAPER_COUNT") * 100 : 0;
        if (paperWinRate > bestWinRate) {
            bestMove = "PAPER";
            bestWinRate = paperWinRate;
        }

        Double tisoresWinRate = stats.get("TISORES_COUNT") > 0 ? (double)stats.get("TISORES_WINS") / stats.get("TISORES_COUNT") * 100 : 0;
        if (tisoresWinRate > bestWinRate) {
            bestMove = "TISORES";
            bestWinRate = tisoresWinRate;
        }

        // Imprime las estadísticas finales
        System.out.println("Estadístiques finals:");
        System.out.println("------------------");
        System.out.println("Total partides: " + totalGames);
        System.out.printf(Locale.US, "Victòries: %.1f%%\n", totalWins > 0 ? (double)totalWins / totalGames * 100 : 0);
        System.out.println("Moviment més utilitzat: " +  moveMostUsed + " (" + maxCount + " vegades)");
        System.out.printf(Locale.US, "Moviment més victoriós: %s (%d%% victòries)\n", bestMove, Math.round(bestWinRate));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Inicializa el escáner para entrada del usuario
        try {
            HashMap<String, Integer> stats = new HashMap<>(); // Mapa para las estadísticas
            stats.put("PEDRA_COUNT", 0);
            stats.put("PAPER_COUNT", 0);
            stats.put("TISORES_COUNT", 0);
            stats.put("PEDRA_WINS", 0);
            stats.put("PAPER_WINS", 0);
            stats.put("TISORES_WINS", 0);

            Integer playerScore = 0; // Puntuación del jugador
            Integer pcScore = 0; // Puntuación del PC

            System.out.println("Benvingut a Pedra, Paper, Tisores!");
            System.out.println("El primer en arribar a 3 victòries guanya!\n");

            while (playerScore < 3 && pcScore < 3) { // Juega hasta que alguien gane 3 rondas
                String playerMove = getPlayerMove(scanner);
                if (playerMove == null) { // Si el jugador elige salir
                    break;
                }

                String pcMove = getMovePC(); // Obtiene la jugada del PC
                System.out.println("PC tria: " + pcMove);

                String winner = getWinner(playerMove, pcMove); // Determina el ganador de la ronda
                System.out.println(getMessage(winner, playerMove, pcMove)); // Muestra el mensaje de resultado

                if (winner.equals("PLAYER")) { // Incrementa puntuación según el ganador
                    playerScore++;
                }
                else if (winner.equals("PC")) {
                    pcScore++;
                }

                System.out.println(getScoreMessage(playerScore, pcScore)); // Muestra el marcador
                System.out.println();

                updateStats(stats, playerMove, winner.equals("PLAYER")); // Actualiza estadísticas
            }

            if (playerScore >= 3 || pcScore >= 3) { // Anuncia el ganador
                System.out.println(getWinnerMessage(playerScore >= 3));
                System.out.println();
            }

            showStats(stats); // Muestra estadísticas finales
        } 
        
        finally {
            scanner.close();  // Cierra el escáner al final
        }
    }
}
