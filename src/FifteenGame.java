import javax.swing.*;
import java.awt.*;

public class FifteenGame extends JFrame {
    JButton[] buttonArray = new JButton[16]; // Creating an array that holds 16 JButtons


    public FifteenGame() {

        // Setting up the Layout for the game.
        setTitle("Fifteen game");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 4));
        JButton newGameButton = new JButton("New Game");

        // Using a for-loop for naming the buttons that are added to the GridLayout.
        for (int i = 0; i < buttonArray.length; i++) {

            buttonArray[i] = new JButton(String.valueOf(i + 1));
            gridPanel.add(buttonArray[i]);

        }
        buttonArray[15].setText(""); // Making sure the last tile for now is empty.

        //Adding the GridPanel and JButton for new game.
        add(newGameButton, BorderLayout.SOUTH);
        add(gridPanel, BorderLayout.CENTER);
        setVisible(true);

    }


}
