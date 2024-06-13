import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

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
        sunLabel.SunGenerate(this,1);//自然阳光生成

        Seed seed0 = new Seed(ChangeImageIcon(new ImageIcon("resources\\src\\SunFlowerCard.png"),
                2f,2.1f),ChangeImageIcon(new ImageIcon("resources\\src\\SunFlower.png"),
                1.25f,1.25f), 50,this,"SunFlower",50,300);
        Seed seed1 = new Seed(ChangeImageIcon(new ImageIcon("resources\\src\\PeaShooterCard.png"),
                2f,2.1f), ChangeImageIcon(new ImageIcon("resources\\src\\PeaShooter.png"),
                1.25f,1.25f),100,this,"PeaShooter",100,300);
        Seed seed2 = new Seed(ChangeImageIcon(new ImageIcon("resources\\src\\NutCard.png"),
                2f,2.1f),ChangeImageIcon(new ImageIcon("resources\\src\\Nut.png"),
                1.25f,1.25f),100,this,"Nut",50,4000);

        Seed.add(seed0);
        Seed.add(seed1);
        Seed.add(seed2);

        ZombieGenerate(this,1);
    }

    public static SunLabel getSunLabel() {
        return sunLabel;
    }

    public static ImageIcon InitialImage(String filename) {
        BufferedImage bufferedImage = null;
        ImageIcon imageIcon = null;
        try {
            bufferedImage = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bufferedImage != null) {
            imageIcon = new ImageIcon(bufferedImage);
        }
        return imageIcon;
    }

    public static ImageIcon ChangeImageIcon(ImageIcon picture, float multiple1,float multiple2) {
        if(multiple1 != 0 & multiple2 != 0){
            Image scaledPicture = picture.getImage().getScaledInstance((int)(picture.getIconWidth()/multiple1),
                    (int)(picture.getIconHeight()/multiple2), Image.SCALE_SMOOTH);
            picture = new ImageIcon(scaledPicture);   // 调整图像大小
        }
        return picture;
    }

    public static void ZombieGenerate(JLayeredPane layerPane,int a) {
        if (a == 1){
            Timer zombieTimer = new Timer(true);
            TimerTask generate = new TimerTask() {
                @Override
                public void run() {
                    Zombie zombie = new Zombie(100,layerPane);
                }
            };
            zombieTimer.schedule(generate,5000,25000);
        }
    }
}
