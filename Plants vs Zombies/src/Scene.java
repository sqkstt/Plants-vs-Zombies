/*
这是项目的第一步场景的实现
 */
import sun.java2d.pipe.DrawImage;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

/*
使用io来导入文件，并利用JPanel类来进行组装
 */
public class Scene extends JPanel {

    private BufferedImage background;
    // 这一步是声明一个BufferedImage对象；
    public void paintComponent(Graphics g) {
        try {
            background = ImageIO.read(new File("resources/src/BG_grass_day.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        // 读取图像
        if(background != null) {
            g.drawImage(background,0,0,1256,538,this);
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
        frame.setSize(1256,538);
        // 设置窗口大小
        frame.setVisible(true);
        // 使窗口可见
    }
}
