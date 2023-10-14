import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {
    private ButtonPanel buttonPanel;
    private TitleBar titleBar;
    private GameFrame gameFrame;


    private JButton startButton;
    private JButton cashoutButton;

    public Frame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        buttonPanel = new ButtonPanel();
        gameFrame = new GameFrame();
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(gameFrame,BorderLayout.CENTER);

        startButton = buttonPanel.getStartButton();
        cashoutButton = buttonPanel.getCashoutButton();
        addListeners();
        revalidate();
    }

    public void addListeners() {
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                System.out.println("Pressed START");
                gameFrame.spinSlot();
                revalidate();
            }
        });
        cashoutButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Pressed CashOut");

                repaint();
            }
        });
    }

}
