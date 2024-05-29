import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

public class Background extends JPanel implements MouseListener, MouseMotionListener {
    JLabel bg;
    JLabel seedBank;
    JLabel shovelBank;
    ImageIcon[] imageIcons = {new ImageIcon("resources\\src\\SunFlower.png"),
            new ImageIcon("resources\\src\\PeaShooter.png"),
            new ImageIcon("resources\\src\\Nut.png")};

    JLabel Plant = new JLabel();
    int X;
    int Y;
    JLayeredPane layeredPane;
    int clicked = 0;
    static ImageIcon[] imageplants = {new ImageIcon("resources\\src\\SunFlower_normal.gif")
            ,new ImageIcon("resources\\src\\PeaShooter_normal.gif")
            ,new ImageIcon("resources\\src\\Nut_normal.gif")};
    static int choice = -1;
    static Plant[][] plant = new Plant[5][9];//创建JLabel数组
    static int Width = 72;//格子宽度
    static int Height = 90;//格子高度
    static int initX = 224;
    static int initY = 94;
    public Background(JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;
        this.setSize(1256, 638);
        this.setVisible(true);
        this.setLayout(null);//取消默认布局
        //创建草地
        ImageIcon BackGround = new ImageIcon("resources\\src\\BG_grass_day.png"); //创建一个图像
        bg = new JLabel(BackGround);     //创建一个JLabel板
        bg.setBounds(0,20,BackGround.getIconWidth(),BackGround.getIconHeight());    //设置位置大小


        //创建种子栏
        ImageIcon SeedBank = new ImageIcon("resources\\src\\SeedBank.png");   //创建一个图像
        Image scaledSeedBank = SeedBank.getImage().getScaledInstance((int)(SeedBank.getIconWidth()/1.2),
                (int)(SeedBank.getIconHeight()/1.2), Image.SCALE_SMOOTH);
        SeedBank = new ImageIcon(scaledSeedBank);   // 调整种子栏图像大小
        seedBank = new JLabel(SeedBank);   //创建一个JLabel板
        seedBank.setBounds(224,20, SeedBank.getIconWidth(),SeedBank.getIconHeight());   //设置位置大小

        //创建铲子栏
        ImageIcon ShovelBank = new ImageIcon("resources\\src\\ShovelBank.png");   //创建一个图像
        Image scaledShovelBank = ShovelBank.getImage().getScaledInstance((int)(ShovelBank.getIconWidth()/1.1),
                (int)(ShovelBank.getIconHeight()/1.1), Image.SCALE_SMOOTH);
        ShovelBank = new ImageIcon(scaledShovelBank);   // 调整种子栏图像大小
        shovelBank = new JLabel(ShovelBank);   //创建一个JLabel板
        shovelBank.setBounds(600,20,ShovelBank.getIconWidth(),ShovelBank.getIconHeight());   //设置位置大小

        layeredPane.add(this);
        layeredPane.setLayer(this, -1);//设置标签为第-1层
        addMouseListener(this);
        addMouseMotionListener(this);
        this.add(shovelBank);
        this.add(seedBank);
        this.add(bg);

    }

    public void mouseClicked(MouseEvent e){
        X = e.getX();
        Y = e.getY();
        if (Y >= 23 && Y <= 87) {
            for (int i = 0; i < Seed.CardNum; i++) {
                if (X >= 285 + (int) (i * 100.0 / 2.15) & X <= 285 + (int) (i * 100.0 / 2.15) + 28) {
                    Plant.setIcon(AppStart.ChangeImageIcon(imageIcons[i], 1.25f, 1.25f));
                    Plant.setLocation(X, Y);
                    Plant.setSize(56, 56);
                    layeredPane.add(Plant);
                    layeredPane.setLayer(Plant, 3);
                    choice = i;
                    clicked = 1;
                    break;
                }
            }
        } else if (clicked == 1 & X >= 230 & X <= 876 & Y >= 92 & Y <= 532 & choice != -1) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    if (X >= 230 + j * Width & X <= 230 + (j + 1) * Width & Y >= 92 + i * Height & Y <= 92 + (i + 1) * Height & plant[i][j] == null) {
                        plant[i][j] = new Plant(Seed.Seeds.get(choice).HP,X,Y);
                        plant[i][j].setIcon(imageplants[choice]);
                        plant[i][j].setBounds(initX + j * Width, initY + i * Height,(int) (plant[i][j].getIcon().getIconWidth()/1.05),(int)(plant[i][j].getIcon().getIconHeight()/1.05));
                        plant[i][j].setVisible(true);
                        plant[i][j].setOpaque(false);//设置边框为透明
                        layeredPane.add(plant[i][j]);
                        layeredPane.setLayer(plant[i][j],2);
                        count = 1;
                        AppStart appStart = (AppStart)layeredPane;
                        appStart.getSunLabel().addCurrentSun(-Seed.Seeds.get(choice).Sun);
                        repaint();
                        break;
                    }
                }
                if(count == 1){
                    break;
                }
            }
            layeredPane.remove(Plant);
            clicked = 0;
            choice = -1;
            repaint();
        } else if (clicked == 1) {
            layeredPane.remove(Plant);
            clicked = 0;
            choice = -1;
            repaint();
        }
   }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
        if (Plant != null) {
            Plant.setLocation(X,Y);
        }
    }
}
