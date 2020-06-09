package shopify;

import java.util.Arrays;

public class ConnectFourGame {

    Board board;

    public ConnectFourGame(int r, int c) {
        this.board = new Board(r, c);
    }

    public void playTurn(Player player, int column) {
        board.playTurn(player, column);
        checkWinningStreak();
        board.print();
    }

    private void checkWinningStreak() {
        char lastPlayer = board.currentPlayer();
        String winningStreak = String.format("%c%c%c%c", lastPlayer, lastPlayer, lastPlayer, lastPlayer);
        if (board.currentRow().contains(winningStreak) || board.currentColumn().contains(winningStreak) ||
                board.currentForwardDiagonal().contains(winningStreak) || board.currentReverseDiagonal().contains(winningStreak)) {
            System.out.println("<----- Game Won ------>");
        }
    }

    public static void main(String[] args) {
        ConnectFourGame game = new ConnectFourGame(6, 6);
        game.playTurn(Player.RED, 3);
        game.playTurn(Player.YELLOW, 2);
        game.playTurn(Player.RED, 3);
        game.playTurn(Player.YELLOW, 1);
        game.playTurn(Player.RED, 3);
        game.playTurn(Player.RED, 3);
    }

}

enum Player {
    RED('R'), YELLOW('Y'), EMPTY('E');

    public final char value;

    private Player(char p) {
        this.value = p;
    }
}

class Board {

    static final char EMPTY = '.';

    char[][] board;
    int rows, columns;
    int currentRow = -1, currentCol = -1;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        board = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(board[i], EMPTY);
        }
    }

    public void playTurn(Player player, int column) {
        if (column > columns - 1) throw new RuntimeException("Invalid Move");
        System.out.printf("Player %s chose column %s %n", player.value, column);
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][column] == EMPTY) {
                board[row][column] = player.value;
                currentRow = row;
                currentCol = column;
                return;
            }
        }
    }

    public char currentPlayer() {
        return board[currentRow][currentCol];
    }

    public String currentRow() {
        return new String(board[currentRow]);
    }

    public String currentColumn() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++)
            sb.append(board[i][currentCol]);
        return sb.toString();
    }

    public String currentReverseDiagonal() {
        StringBuilder sb = new StringBuilder();
        for (int d = 0; d < columns; d++) {
            int r = currentRow - currentCol + d;
            if (r >= 0 && r < rows) sb.append(board[r][d]);
        }
        return sb.toString();
    }

    public String currentForwardDiagonal() {
        StringBuilder sb = new StringBuilder();
        for (int d = 0; d < columns; d++) {
            int r = currentRow + currentCol - d;
            if (r >= 0 && r < rows) sb.append(board[r][d]);
        }
        return sb.toString();
    }

    public void print() {
        System.out.println("-----------");
        for (int i = 0; i < rows; i++)
            System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
}