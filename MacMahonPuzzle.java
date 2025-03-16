import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

class MacMahonPuzzle {
    static class Piece {
        char top, right, bottom, left;
        int rotation = 0; // Rotation state (0°, 90°, 180°, 270°)

        public Piece(char top, char right, char bottom, char left) {
            this.top = top;
            this.right = right;
            this.bottom = bottom;
            this.left = left;
        }

        public void rotate() {
            char temp = top;
            top = left;
            left = bottom;
            bottom = right;
            right = temp;
            rotation = (rotation + 90) % 360;
        }

        @Override
        public String toString() {
            return "[" + top + right + bottom + left + "]";
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MacMahon Puzzle");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        // Create pieces
        Piece[][] pieces = {
                { new Piece('+', '-', '+', '-'), new Piece('-', '+', '-', '+'), new Piece('+', '-', '+', '-') },
                { new Piece('-', '+', '-', '+'), new Piece('+', '-', '+', '-'), new Piece('-', '+', '-', '+') },
                { new Piece('+', '-', '+', '-'), new Piece('-', '+', '-', '+'), new Piece('+', '-', '+', '-') }
        };

        JButton[][] buttons = new JButton[3][3];

        // Initialize buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton(pieces[i][j].toString());
                button.setFont(new Font("Arial", Font.BOLD, 18));
                int row = i, col = j;

                button.addActionListener(_ -> {
                    pieces[row][col].rotate();
                    button.setText(pieces[row][col].toString());
                });

                buttons[i][j] = button;
                frame.add(button);
            }
        }

        frame.setVisible(true);
    }
}

