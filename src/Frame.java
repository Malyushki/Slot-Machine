import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {
    private ButtonPanel buttonPanel;
    private TitleBar titleBar;
    private GameLogic gameLogic;


    private JButton startButton;
    private JButton cashoutButton;

    private JButton bet1;
    private JButton bet2;
    private JButton bet3;
    private JButton bet4;
    private JButton bet5;

    private JButton insertMoney;


    public Frame() {
        this.setSize(800, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setVisible(true);
        buttonPanel = new ButtonPanel();

        gameLogic = new GameLogic();
        titleBar = new TitleBar();


        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(gameLogic, BorderLayout.CENTER);
        this.add(titleBar, BorderLayout.NORTH);

        startButton = buttonPanel.getStartButton();
        cashoutButton = buttonPanel.getCashoutButton();
        insertMoney = buttonPanel.getInsertMoney();

        bet1 = buttonPanel.getBet1();
        bet2 = buttonPanel.getBet2();
        bet3 = buttonPanel.getBet3();
        bet4 = buttonPanel.getBet4();
        bet5 = buttonPanel.getBet5();


        addListeners();
        revalidate();
    }

    public void addListeners() {
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                System.out.println("Pressed START");
                gameLogic.spinSlot();
                revalidate();
            }
        });
        cashoutButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Pressed CashOut: " + gameLogic.getPlayerBalance());
                gameLogic.setPlayerBalance(0.00);
                repaint();
            }
        });

        insertMoney.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Insert money");
                gameLogic.setPlayerBalance(gameLogic.getPlayerBalance()+100.00);
                System.out.println(gameLogic.getPlayerBalance());
                repaint();
            }
        });
        bet1.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Bet 1");
                gameLogic.setPlayerBet(1);
                gameLogic.spinSlot();

                repaint();
            }
        });

        bet2.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Bet 2");
                gameLogic.setPlayerBet(2);
                gameLogic.spinSlot();
                repaint();
            }
        });
        bet3.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Bet 3");
                gameLogic.setPlayerBet(3);
                gameLogic.spinSlot();
                repaint();
            }
        });
        bet4.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Bet 4");
                gameLogic.setPlayerBet(4);
                gameLogic.spinSlot();
                repaint();
            }
        });

        bet5.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Bet 5");
                gameLogic.setPlayerBet(5);
                gameLogic.spinSlot();
                repaint();
            }
        });
    }

}
