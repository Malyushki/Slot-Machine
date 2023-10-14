import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {
    public TitleBar() {
        this.setPreferredSize(new Dimension(800,100));
        this.setBackground(Color.DARK_GRAY);


        JLabel titleText = new JLabel();
        titleText.setPreferredSize(new Dimension(800,100));
       // titleText.setIcon(new ImageIcon(getClass().getClassLoader().getResource("todoList.png")));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        titleText.setText("BIG WINS SLOT MACHINE");

        this.add(titleText);
    }
}
