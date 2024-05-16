import javax.swing.*;
import java.awt.*;

public class Background extends JPanel  {
    JLabel bg;
    JLabel seedBank;
    JLabel shovelBank;
    public Background(JLayeredPane layeredPane) {
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
        this.add(shovelBank);
        this.add(seedBank);
        this.add(bg);
    }
}
