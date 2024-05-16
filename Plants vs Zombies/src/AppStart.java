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

        Seed seed0 = new Seed(ChangeImageIcon(new ImageIcon("resources\\src\\PeaShooterCard.png"),
                2f), 100,this);
        Seed seed1 = new Seed(ChangeImageIcon(new ImageIcon("resources\\src\\SunFlowerCard.png"),
                2f), 50,this);
    }
    
    public static SunLabel getSunLabel() {
        return sunLabel;
    }

    public ImageIcon ChangeImageIcon(ImageIcon picture, float multiple) {
        Image scaledPicture = picture.getImage().getScaledInstance((int)(picture.getIconWidth()/multiple),
                (int)(picture.getIconHeight()/multiple), Image.SCALE_SMOOTH);
        picture = new ImageIcon(scaledPicture);   // 调整图像大小
        return picture;
    }
}
