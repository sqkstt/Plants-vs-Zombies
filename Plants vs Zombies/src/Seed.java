import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Seed extends JLabel  {
    static int CardNum = 0;//卡片数量
    JLayeredPane layeredPane;
    private int offsetX;
    private int offsetY;
    ImageIcon imageIcon;
    public Seed(ImageIcon Plant, int price, JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
        this.imageIcon = Plant;
        this.setIcon(Plant);
        this.setSize(Plant.getIconWidth(),Plant.getIconHeight());
        this.setVisible(true);
        this.setLocation(285+(int)(CardNum*100.0/2.15),23);//设置植物卡对应植物
        layeredPane.add(this);
        layeredPane.setLayer(this,2);
        CardNum++;
    }
}
