import javax.swing.*;
import java.awt.*;
import java.awt.Menu;

public class AppStart extends JLayeredPane {
    static ImageIcon imageIcon= new ImageIcon("D:\\Lab\\Plants vs Zombies\\resources\\src\\IconImage.png");// 导入图片;
    static SunLabel sunLabel;
    AppStart() {
        this.setSize(1000,618);
        this.setVisible(true);
        MyMenu myMenu = new MyMenu(this);
    }
    AppStart(boolean a) {
        this.setSize(1256,638);
        this.setVisible(true);
        Background background = new Background(this);
        sunLabel = new SunLabel(this);
        Sun sun = new Sun(200,200,this);
    }
    public static SunLabel getSunLabel() {
        return sunLabel;
    }
}
