public class Game {
    private static final int BOARD_SIZE = 3;
    private static final String[] SYMBOLS = {"X", "O"};

    private String[][] board;
    private int currentPlayerIndex;

    public Game() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        currentPlayerIndex = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = " ";
            }
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || !board[row][col].equals(" ")) {
            return false;
        }
        board[row][col] = SYMBOLS[currentPlayerIndex];
        return true;
    }

    public boolean checkForWin() {
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(" ")) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(" ")) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(" ")) {
            return true;
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(" ")) {
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getCurrentPlayerSymbol() {
        return SYMBOLS[currentPlayerIndex];
    }

    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % SYMBOLS.length;
    }

    public void reset() {
        initializeBoard();
        currentPlayerIndex = 0;
    }
}
