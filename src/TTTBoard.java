public class TTTBoard {
    private static final int SIZE = 3;
    private String[][] board;

    public TTTBoard() {
        board = new String[SIZE][SIZE];
        reset();
    }

    public void reset() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = "";
            }
        }
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }

    public void setCell(int row, int col, String symbol) {
        board[row][col] = symbol;
    }

    public boolean checkWin(String symbol) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0].equals(symbol) && board[i][1].equals(symbol) && board[i][2].equals(symbol))
                return true;
            if (board[0][i].equals(symbol) && board[1][i].equals(symbol) && board[2][i].equals(symbol))
                return true;
        }
        if (board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol))
            return true;
        if (board[0][2].equals(symbol) && board[1][1].equals(symbol) && board[2][0].equals(symbol))
            return true;
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
