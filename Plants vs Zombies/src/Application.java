import javax.swing.*;
import java.awt.*;

public class Application extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame("PVZ");

        //创建草地
        ImageIcon BackGround = new ImageIcon("resources/src/BG_grass_day.png"); //创建一个图像
        JLabel bg = new JLabel(BackGround);     //创建一个JLabel板
        bg.setBounds(0,20,BackGround.getIconWidth(),BackGround.getIconHeight());    //设置位置大小
        frame.getLayeredPane().add(bg ,Integer.valueOf(0));  //导入到窗体

        //创建种子栏
        ImageIcon SeedBank = new ImageIcon("resources/src/SeedBank.png");   //创建一个图像
        Image scaledSeedBank = SeedBank.getImage().getScaledInstance((int)(SeedBank.getIconWidth()/1.2),
                (int)(SeedBank.getIconHeight()/1.2), Image.SCALE_SMOOTH);
        SeedBank = new ImageIcon(scaledSeedBank);   // 调整种子栏图像大小
        JLabel seedBK = new JLabel(SeedBank);   //创建一个JLabel板
        seedBK.setBounds(224,20, SeedBank.getIconWidth(),SeedBank.getIconHeight());   //设置位置大小
        frame.getLayeredPane().add(seedBK,Integer.valueOf(1));  //导入到窗体

        //创建铲子栏
        ImageIcon ShovelBank = new ImageIcon("resources/src/ShovelBank.png");   //创建一个图像
        Image scaledShovelBank = ShovelBank.getImage().getScaledInstance((int)(ShovelBank.getIconWidth()/1.1),
                (int)(ShovelBank.getIconHeight()/1.1), Image.SCALE_SMOOTH);
        ShovelBank = new ImageIcon(scaledShovelBank);   // 调整种子栏图像大小
        JLabel shovelBK = new JLabel(ShovelBank);   //创建一个JLabel板
        shovelBK.setBounds(600,20,ShovelBank.getIconWidth(),ShovelBank.getIconHeight());   //设置位置大小
        frame.getLayeredPane().add(shovelBK, Integer.valueOf(1));  //导入到窗体

        //将JPanel板设为透明
        JPanel panel = (JPanel)frame.getContentPane();
        panel.setOpaque(false);  //设置透明
        panel.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //是用户关闭窗口后程序停止
        frame.setSize(1256,638);   //设置窗口大小
        frame.setLocationRelativeTo(null);      //设置窗口位置
        frame.setVisible(true);                 // 使窗口可见
    }
}
