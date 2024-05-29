import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Seed extends JLabel  {
    static int CardNum = 0;//卡片数量
    static Vector<Seed> Seeds = new Vector<>();//植物卡向量
    JLayeredPane layeredPane;
    String name;
    int offsetX;
    int offsetY;
    ImageIcon imageIconCard;
    ImageIcon imageIconPlant;
    int Sun;
    int HP;
    public Seed(ImageIcon PlantCard, ImageIcon Plant, int price, JLayeredPane layeredPane,String initname,int sun,int Hp) {
        this.layeredPane = layeredPane;
        this.imageIconPlant = Plant;
        this.imageIconCard = PlantCard;
        this.name = initname;
        this.Sun = sun;
        this.HP = Hp;
        this.setIcon(PlantCard);
        this.setSize(PlantCard.getIconWidth(),PlantCard.getIconHeight());
        this.setVisible(true);
        this.setLocation(285+(int)(CardNum*100.0/2.15),23);//设置植物卡对应植物
        layeredPane.add(this);
        layeredPane.setLayer(this,2);
        CardNum++;
    }
    public static void add (Seed seed) {
        Seeds.add(seed);
    }

}
