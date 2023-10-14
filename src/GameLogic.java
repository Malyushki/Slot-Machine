import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GameLogic extends JPanel {
    JLabel[] barLabels = new JLabel[15];
    int RANDOM_BOUND = 10;
    int [] slotsBars; ;

    public GameLogic() {
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
        slotsBars = new int[15];
        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(RANDOM_BOUND);
            slotsBars[i] = randomInt;
            barLabels[i].setIcon(randomIcon(randomInt));

        }
        checkWin();
    }

    private ImageIcon randomIcon(int random) {
        BufferedImage img = null;
        String randomImgPath = "res/" + SlotIcons.values()[random] + ".jpg";

        try {
            img = ImageIO.read(new File(randomImgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(this.getWidth() / 5, this.getHeight() / 3,
                Image.SCALE_SMOOTH);


        ImageIcon imageIcon = new ImageIcon(dimg);
        return imageIcon;
    }

    public void checkWin(){
       int winValue;
       boolean winFirstLine = false;
       boolean winSecondLine = false;
       boolean winThirdLine = false;
       boolean winFourthLine = false;
       boolean winFifthLine = false;

       for (int i = 1; i < 5 ; i++) {
                 if (this.slotsBars[i-1] == this.slotsBars[i] ){
                    winFirstLine = true;
                 }else {
                     winFirstLine = false;
                     break;
                 }
        }

        for (int i = 5; i < 10 ; i++) {
            if (this.slotsBars[i-1] == this.slotsBars[i] ){
                winSecondLine = true;
            }else {
                winSecondLine = false;
                break;
            }
        }

        for (int i = 10; i < 15 ; i++) {
            if (this.slotsBars[i - 1] == this.slotsBars[i]) {
                winThirdLine = true;
            } else {
                winThirdLine = false;
                break;
            }
        }

            for (int i = 10; i < 15 ; i++) {
                if (this.slotsBars[i - 1] == this.slotsBars[i]) {
                    winFourthLine = true;
                } else {
                    winFourthLine = false;
                    break;
                }
            }

        }


    }


