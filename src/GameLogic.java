import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class GameLogic extends JPanel {
    private JLabel[] barLabels = new JLabel[15];
    private int RANDOM_BOUND = 10;
    private int[] slotsBars;
    private Double playerBalance;
    private int playerBet;

    public void setPlayerBalance(Double playerBalance) {
        this.playerBalance = playerBalance;
    }

    public Double getPlayerBalance() {
        return playerBalance;
    }

    public void setPlayerBet(int playerBet) {
        this.playerBet = playerBet;
    }

    public GameLogic() {
        playerBalance = 100.00;
        playerBet = 1;


        this.setLayout(new GridLayout(3, 5));
        this.setBorder(BorderFactory.createCompoundBorder());
        for (int i = 0; i < 15; i++) {

            barLabels[i] = new JLabel();
            barLabels[i].setFont(new Font("MV Boli", Font.BOLD, 50));
            barLabels[i].setBackground(Color.BLACK);
            barLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            barLabels[i].setVerticalAlignment(SwingConstants.CENTER);
            barLabels[i].setBorder(BorderFactory.createLineBorder(Color.getColor("RED")));
            this.add(barLabels[i]);


        }
    }

    public void spinSlot() {
        if (checkBalance()){
            System.out.println("Insufficient amount. Insert money");
        }else {
            playerBalance-=playerBet;

            slotsBars = new int[15];
            int[] line1 = new int[5];
            int[] line2 = new int[5];
            int[] line3 = new int[5];
            int[] line4 = new int[5];
            int[] line5 = new int[5];

            for (int i = 0; i < 15; i++) {
                Random random = new Random();
                int randomInt;
                if (i % 5 == 0) {
                    randomInt = random.nextInt(RANDOM_BOUND - 1);
                } else {
                    randomInt = random.nextInt(RANDOM_BOUND);
                }
                slotsBars[i] = randomInt;
                barLabels[i].setIcon(randomIcon(randomInt));

            }
            line1 = fillBasicLines(slotsBars, 0);
            line2 = fillBasicLines(slotsBars, 1);
            line3 = fillBasicLines(slotsBars, 2);
            line4 = fillForthLine(slotsBars);
            line5 = fillFifthLine(slotsBars);

            replaceWilds(line1);
            replaceWilds(line2);
            replaceWilds(line3);
            replaceWilds(line4);
            replaceWilds(line5);


         /*   System.out.println(Arrays.toString(line1));
            System.out.println(Arrays.toString(line2));
            System.out.println(Arrays.toString(line3));
            System.out.println(Arrays.toString(line4));
            System.out.println(Arrays.toString(line5));

          */

            checkWins(line1, playerBet);
            checkWins(line2, playerBet);
            checkWins(line3, playerBet);
            checkWins(line4, playerBet);
            checkWins(line5, playerBet);

            // checkWin();

            System.out.println(playerBalance);
        }

    }

    private ImageIcon randomIcon(int random) {
        BufferedImage img = null;
        String randomImgPath = "res/" + SlotIcons.values()[random] + ".jpg";

        try {
            img = ImageIO.read(new File(randomImgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

  //      Image dimg = img.getScaledInstance(this.getWidth() / 5, this.getHeight() / 3,Image.SCALE_SMOOTH);


        ImageIcon imageIcon = new ImageIcon(img);
        return imageIcon;
    }

    private int[] fillBasicLines(int[] slotsBars, int row) {
        int[] returnLine = new int[5];
        for (int i = 0; i < 5; i++) {
            returnLine[i] = slotsBars[i + row * 5];
        }
        return returnLine;
    }

    private int[] fillForthLine(int[] slotsBars) {
        int[] returnLine = new int[5];
        returnLine[0] = slotsBars[0];
        returnLine[1] = slotsBars[6];
        returnLine[2] = slotsBars[12];
        returnLine[3] = slotsBars[8];
        returnLine[4] = slotsBars[4];
        return returnLine;
    }

    private int[] fillFifthLine(int[] slotsBars) {
        int[] returnLine = new int[5];
        returnLine[0] = slotsBars[10];
        returnLine[1] = slotsBars[6];
        returnLine[2] = slotsBars[2];
        returnLine[3] = slotsBars[8];
        returnLine[4] = slotsBars[14];
        return returnLine;
    }

    private void replaceWilds(int[] line) {
        for (int i = 1; i < 5; i++) {
            if (line[i] == 9 && line[i - 1] != 2) {
                line[i] = line[i - 1];
            }
        }
    }

    private void checkWins(int[] line, int bet) {
        int countElements = 1;

        for (int i = 1; i < line.length; i++) {
            if (line[i] == line[i - 1]) {
                countElements++;
            } else {
                break;
            }
        }
        playerBalance+=rewardMutilpayer(line[0], countElements);
        //  System.out.println(rewardMutilpayer(line[0], countElements));

      //  System.out.println(freeSpinsBonus(line[0], countElements));

    }

    private int rewardMutilpayer(int type, int count) {

        switch (type) {
            case 0:
            case 1:
            case 2:
            case 3:
                if (count < 3) {
                    break;
                } else if (count == 3) {
                    return 2;
                } else if (count == 4) {
                    return 6;
                } else if (count == 5) {
                    return 30;
                }
                break;
            case 4:
            case 5:
                if (count < 3) {
                    break;
                } else if (count == 3) {
                    return 8;
                } else if (count == 4) {
                    return 24;
                } else if (count == 5) {
                    return 140;
                }
                break;
            case 6:
            case 7:
                if (count < 2) {
                    break;
                } else if (count == 2) {
                    return 3;
                } else if (count == 3) {
                    return 10;
                } else if (count == 4) {
                    return 50;
                } else if (count == 5) {
                    return 1000;
                }
                break;
            default:
                return 0;

        }
        return 0;
    }

    private int freeSpinsBonus(int type, int count) {
        if (type == 8) {
            switch (count) {
                case 3:
                    return 3;
                case 4:
                    return 9;
                case 5:
                    return 15;


            }

        }

        return 0;
    }
    private boolean checkBalance(){
        return playerBalance < playerBet;
    }
}


