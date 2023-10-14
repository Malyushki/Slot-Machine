import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton startButton;
    private JButton cashoutButton;
    private Border emptyBorder = BorderFactory.createEmptyBorder();


    public ButtonPanel() {
        this.setPreferredSize(new Dimension(400, 60));
        this.setBackground(Color.LIGHT_GRAY);

        startButton = new JButton();
        startButton.setBorder(emptyBorder);
        startButton.setPreferredSize(new Dimension(120, 40));
        startButton.setBackground(Color.BLUE);


        this.add(startButton);

        cashoutButton = new JButton();
        cashoutButton.setBorder(emptyBorder);
        cashoutButton.setPreferredSize(new Dimension(215, 40));
        cashoutButton.setBackground(Color.RED);

        this.add(cashoutButton);


    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getCashoutButton() {
        return cashoutButton;
    }
}
