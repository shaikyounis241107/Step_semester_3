RockPaperScissors.java
package string.assigment_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int round = 0; round < 5; round++) {

            System.out.print("Round " + (round + 1) +
                    " - Enter Rock, Paper, or Scissors: ");

            String playerMove = scanner.nextLine();

            if (!playerMove.equalsIgnoreCase("Rock") &&
                !playerMove.equalsIgnoreCase("Paper") &&
                !playerMove.equalsIgnoreCase("Scissors")) {

                System.out.println("Invalid move. Try again.");
                round--;
                continue;
            }

            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("Final Summary");
        System.out.println("-----------------------------------------------");
        System.out.println("Round | Player Move | Computer Move | Result");

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "     | " +
                    playerMoves[i] + "       | " +
                    computerMoves[i] + "       | " +
                    results[i]);
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        scanner.close();
    }
}