import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameFrame extends JPanel {
    JLabel[][] gameMatrix = new JLabel[3][5];
    int RANDOM_BOUND = 10;

    public GameFrame() {
        this.setLayout(new GridLayout(3, 5));

        this.setBorder(BorderFactory.createCompoundBorder());
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                gameMatrix[row][col] = new JLabel();
                gameMatrix[row][col].setFont(new Font("MV Boli", Font.BOLD, 12));
                gameMatrix[row][col].setBackground(Color.CYAN);
                gameMatrix[row][col].setHorizontalAlignment(SwingConstants.CENTER);
                gameMatrix[row][col].setVerticalAlignment(SwingConstants.CENTER);
                gameMatrix[row][col].setText(row + " " + col);
                gameMatrix[row][col].setBorder(BorderFactory.createLineBorder(Color.cyan));
                this.add(gameMatrix[row][col]);

            }
        }
    }

    public void spinSlot() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                gameMatrix[row][col].setIcon(randomIcon());

            }
        }
    }

    private ImageIcon randomIcon() {
        BufferedImage img = null;
        Random random = new Random();
        String randomImgPath = "res/" + SlotIcons.values()[random.nextInt(RANDOM_BOUND)] + ".jpg";

        //"res/" + SlotIcons.values()[random.nextInt(3)] + ".jpg";


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
}

