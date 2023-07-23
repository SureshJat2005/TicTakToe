import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTakToe implements ActionListener {

    String turn = "X";
    int moves = 0;
    boolean isWin = false;

    JFrame frame = new JFrame();
    JPanel bodyPanel = new JPanel();
    JPanel headPanel = new JPanel();
    JLabel label = new JLabel();
    JButton[] buttons = new JButton[9];

    TicTakToe() {

        label.setText("Player X turn.");
        label.setFont(new Font("Ink Free", Font.BOLD, 50));
        label.setForeground(Color.green);

        headPanel.setBounds(0, 0, 450, 60);
        headPanel.setBackground(Color.BLACK);
        headPanel.add(label);

        bodyPanel.setBounds(0, 60, 450, 450);
        bodyPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            bodyPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        frame.setSize(465, 550);
        frame.add(bodyPanel);
        frame.add(headPanel);
        frame.setLayout(null);
        frame.setTitle("TicTikToe-\"Suresh Jat\"");
        frame.setVisible(true);

    }

    void checkForWin(int a, int b, int c) {
        if (isWin == false) {

            if (buttons[a].getText() == "X" &&
                buttons[b].getText() == "X" &&
                buttons[c].getText() == "X") {
                    isWin = true;
                    label.setText("Player X win");

            } 
            else if (buttons[a].getText() == "O" &&
                    buttons[b].getText() == "O" &&
                    buttons[c].getText() == "O") {
                    label.setText("Player O win");
                    isWin = true;
            } 
            else if (moves == 9) {
                label.setText("It's tie");
            }
        }

    }

    public static void main(String[] args) {
        new TicTakToe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {

                if (isWin == false) {

                    if (turn == "X") {
                        buttons[i].setFont(new Font("Comic Sense", Font.BOLD, 60));
                        buttons[i].setText("X");
                        buttons[i].setEnabled(false);
                        label.setText("Player O turn");
                        turn = "O";
                        break;

                    } 
                    else {
                        buttons[i].setFont(new Font("Comic Sense", Font.BOLD, 60));
                        buttons[i].setText("O");
                        buttons[i].setEnabled(false);
                        label.setText("Player X turn");
                        turn = "X";
                        break;
                    }
                }

            }
        }
        moves++;

        checkForWin(0, 1, 2);
        checkForWin(3, 4, 5);
        checkForWin(6, 7, 8);
        checkForWin(0, 3, 6);
        checkForWin(1, 4, 7);
        checkForWin(2, 5, 8);
        checkForWin(0, 4, 8);
        checkForWin(2, 4, 6);

    }
}
