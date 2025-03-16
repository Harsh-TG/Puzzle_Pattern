import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class PuzzleSolver extends JFrame {
    private final JButton[][] buttons = new JButton[3][3];
    private int[][] pieces = {
            {1, 2, 3, 4}, {3, 4, 1, 2}, {2, 3, 4, 1},
            {4, 1, 2, 3}, {1, 3, 2, 4}, {3, 2, 4, 1},
            {2, 4, 1, 3}, {4, 3, 1, 2}, {1, 2, 3, 4}
    };

    public PuzzleSolver() {
        setTitle("Puzzle Solver");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int index = i * 3 + j;
                buttons[i][j] = new JButton(getPieceText(pieces[index]));
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 12));
                int finalIndex = index;
                buttons[i][j].addActionListener(_ -> rotatePiece(finalIndex));
                add(buttons[i][j]);
            }
        }
    }

    private void rotatePiece(int index) {
        int[] piece = pieces[index];
        int temp = piece[0];
        piece[0] = piece[3];
        piece[3] = piece[2];
        piece[2] = piece[1];
        piece[1] = temp;
        buttons[index / 3][index % 3].setText(getPieceText(piece));
    }

    private String getPieceText(int[] piece) {
        return piece[0] + "\n" + piece[3] + "  " + piece[1] + "\n" + piece[2];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PuzzleSolver().setVisible(true));
    }
}


