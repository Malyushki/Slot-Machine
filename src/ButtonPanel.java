import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton insertMoney;
    private JButton startButton;
    private JButton bet1;
    private JButton bet2;
    private JButton bet3;
    private JButton bet4;
    private JButton bet5;
    private JButton cashoutButton;
    private Border emptyBorder = BorderFactory.createEmptyBorder();

    public JButton getInsertMoney() {
        return insertMoney;
    }

    public JButton getBet1() {
        return bet1;
    }

    public JButton getBet2() {
        return bet2;
    }

    public JButton getBet3() {
        return bet3;
    }

    public JButton getBet4() {
        return bet4;
    }

    public JButton getBet5() {
        return bet5;
    }

    public ButtonPanel() {
        this.setPreferredSize(new Dimension(800, 100));
        this.setBackground(Color.LIGHT_GRAY);

        insertMoney = new JButton();
        insertMoney.setBorder(emptyBorder);
        insertMoney.setPreferredSize(new Dimension(100, 50));
        insertMoney.setBackground(Color.BLUE);
        insertMoney.setText("Insert money");


        startButton = new JButton();
        startButton.setBorder(emptyBorder);
        startButton.setPreferredSize(new Dimension(100, 80));
        startButton.setBackground(Color.BLUE);
        startButton.setText("START");

        bet1 = new JButton();
        bet1.setBorder(emptyBorder);
        bet1.setPreferredSize(new Dimension(80, 80));
        bet1.setBackground(Color.BLUE);
        bet1.setText("Bet 1");

        bet2 = new JButton();
        bet2.setBorder(emptyBorder);
        bet2.setPreferredSize(new Dimension(80, 80));
        bet2.setBackground(Color.BLUE);
        bet2.setText("Bet 2");

        bet3 = new JButton();
        bet3.setBorder(emptyBorder);
        bet3.setPreferredSize(new Dimension(80, 80));
        bet3.setBackground(Color.BLUE);
        bet3.setText("Bet 3");

        bet4 = new JButton();
        bet4.setBorder(emptyBorder);
        bet4.setPreferredSize(new Dimension(80, 80));
        bet4.setBackground(Color.BLUE);
        bet4.setText("Bet 4");

        bet5 = new JButton();
        bet5.setBorder(emptyBorder);
        bet5.setPreferredSize(new Dimension(80, 80));
        bet5.setBackground(Color.BLUE);
        bet5.setText("Bet 5");

        cashoutButton = new JButton();
        cashoutButton.setBorder(emptyBorder);
        cashoutButton.setPreferredSize(new Dimension(100, 50));
        cashoutButton.setBackground(Color.RED);
        cashoutButton.setText("Cash out");




        this.add(insertMoney,BorderLayout.NORTH);
        this.add(startButton);
        this.add(bet1);
        this.add(bet2);
        this.add(bet3);
        this.add(bet4);
        this.add(bet5);
        this.add(cashoutButton);


    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getCashoutButton() {
        return cashoutButton;
    }
}
