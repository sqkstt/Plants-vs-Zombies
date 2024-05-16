import javax.swing.*;
import java.awt.*;

public class AppStart extends JLayeredPane {
    static ImageIcon imageIcon= new ImageIcon("resources\\src\\IconImage.png");// 导入图片;
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
        sunLabel.SunGenerate(this);//自然阳光生成
    }
    public static SunLabel getSunLabel() {
        return sunLabel;
    }
}
