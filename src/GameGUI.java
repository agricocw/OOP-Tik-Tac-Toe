import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame {
    private JButton[][] buttons;
    private Game game;

    public GameGUI() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new Game();

        JPanel panel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        ButtonListener listener = new ButtonListener();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
                buttons[row][col].addActionListener(listener);
                panel.add(buttons[row][col]);
            }
        }

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));

        add(panel, BorderLayout.CENTER);
        add(quitButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int row = -1, col = -1;


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j] == clickedButton) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }


            if (row != -1 && col != -1) {
                if (game.makeMove(row, col)) {
                    clickedButton.setText(game.getCurrentPlayerSymbol());
                    if (game.checkForWin()) {
                        JOptionPane.showMessageDialog(null, game.getCurrentPlayerSymbol() + " wins!");
                        resetGame();
                    } else if (game.isBoardFull()) {
                        JOptionPane.showMessageDialog(null, "It's a tie!");
                        resetGame();
                    } else {
                        game.switchPlayer();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid move. Try again.");
                }
            }
        }
    }

    private void resetGame() {
        game.reset();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}
