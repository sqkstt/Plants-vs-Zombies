/*
这是项目的第一步场景的实现
 */

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;

/*
使用io来导入文件，并利用JPanel类来进行组装
 */
public class Scene extends JPanel {

    private BufferedImage background;
    private BufferedImage SeedBank;     //种子选择器
    private BufferedImage ShovelBank;
    // 这一步是声明一个BufferedImage对象；
    public void paintComponent(Graphics g) {
        try {
            background = ImageIO.read(new File("resources/src/BG_grass_day.png"));

            SeedBank = ImageIO.read(new File("resources/src/SeedBank.png"));

            ShovelBank = ImageIO.read(new File("resources/src/ShovelBank.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        // 读取图像
        if(background != null) {
            g.drawImage(background,0,20,1256,538,this);
        }

        if(SeedBank != null) {
            //原图（植物栏）缩放1.2倍
            g.drawImage(SeedBank,224,20,371,72,this);
        }

        if(ShovelBank != null) {
            //原图（铲子栏）缩放1.1倍
            g.drawImage(ShovelBank,600,20,63,65,this);
        }
        // 绘制图像
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Scene");
        // 创建一个顶级容器以往其中放置内容
        frame.setContentPane(new Scene());
        // 设置窗口的内容面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 是用户关闭窗口后程序停止
        frame.setSize(1256,638);
        // 设置窗口大小
        frame.setVisible(true);
        // 使窗口可见
    }
}
