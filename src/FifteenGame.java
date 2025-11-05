import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class FifteenGame extends JFrame implements ActionListener {
    JButton[] buttonArray = new JButton[16]; // Creating an array that holds 16 JButtons
    int emptyIndex = 15; // Setting emptyIndex to 15, since that is where
    // it is when the progarm starts.

    public FifteenGame() {

        // Setting up the Layout for the game.
        setTitle("Fifteen game");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 4));
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> shuffleButtons());

        // Using a for-loop for naming the buttons that are added to the GridLayout.
        for (int i = 0; i < buttonArray.length; i++) {

            buttonArray[i] = new JButton(String.valueOf(i + 1));
            gridPanel.add(buttonArray[i]);
            buttonArray[i].addActionListener(this);

        }
        buttonArray[15].setText(""); // Making sure the last tile for now is empty.

        //Adding the GridPanel and JButton for new game.
        add(newGameButton, BorderLayout.SOUTH);
        add(gridPanel, BorderLayout.CENTER);
        setVisible(true);

    }

    //Setting upp what actionPerformed should do.

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource(); // e.getSource() returns object. Cast to JButton next.
        JButton clickedButton = (JButton) source;

        //Creating logic to see if it's next to the empty JButton.
        for (int i = 0; i < buttonArray.length; i++) {

            if (buttonArray[i] == clickedButton) {
                int clickedRow = i / 4;
                int clickedColumn = i % 4;

                int emptyRow = emptyIndex / 4;
                int emptyColumn = emptyIndex % 4;

                boolean isNextToEmptyButton = false;

                //Compare if ClickedRow is the same as EmptyRow
                //If same -> make sure it differs 1 (so we know it's next to it)
                if (clickedRow == emptyRow && Math.abs(clickedColumn - emptyColumn) == 1) {
                    isNextToEmptyButton = true;
                }

                //Compare if clickedColumn is the same as EmptyColumn
                //If same -> make sure it only differs 1.
                if (clickedColumn == emptyColumn && Math.abs(clickedRow - emptyRow) == 1) {
                    isNextToEmptyButton = true;
                }

                //If bool true, implement logic to switch text.
                if (isNextToEmptyButton) {
                    String textPressedButton = clickedButton.getText();
                    String emptyText = buttonArray[emptyIndex].getText();

                    clickedButton.setText(emptyText);
                    buttonArray[emptyIndex].setText(textPressedButton);

                    //Replace emptyIndex with new empty at i.
                    emptyIndex = i;
                }

            }

        }


    }

    private void shuffleButtons() {
        //Creating an ArrayList to be able to use Collections.shuffle
        ArrayList<String> textButtons = new ArrayList<>();
        //adding the buttonArray to the ArrayList

        for (int i = 0; i < buttonArray.length; i++) {
            textButtons.add(buttonArray[i].getText());
        }
        //Shuffling the buttons
        Collections.shuffle(textButtons);
        //For every iteration in buttonArray, setText from textButtons(i)(which are shuffled):
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].setText(textButtons.get(i));

            if (textButtons.get(i).equals("")) {
                emptyIndex = i;
            }

        }

    }


}
