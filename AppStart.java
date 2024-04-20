import javax.swing.*;
import java.awt.*;
import java.awt.Menu;

public class AppStart extends JLayeredPane {
    ImageIcon imageIcon;
    AppStart() {
        this.setSize(1000,618);
        this.setVisible(true);
        MyMenu myMenu = new MyMenu();
        this.add(myMenu, Integer.valueOf(0)); // 添加myMenu到JLayeredPane，并设置深度为0,作用是监听器
        this.add(myMenu.start, Integer.valueOf(2)); // 添加start到JLayeredPane，并设置深度为2
        this.add(myMenu.Menu, Integer.valueOf(1)); // 添加Menu到JLayeredPane，并设置深度为1
        imageIcon = new ImageIcon("D:\\Lab\\Plants vs Zombies\\resources\\src\\IconImage.png");// 导入图片
    }
    AppStart(boolean a) {
        this.setSize(1256,638);
        this.setVisible(true);
        Background background = new Background();
        this.add(background,Integer.valueOf(-1));
        this.add(background.bg,Integer.valueOf(0));
        this.add(background.seedBank,Integer.valueOf(1));
        this.add(background.shovelBank,Integer.valueOf(2));
        imageIcon = new ImageIcon("D:\\Lab\\Plants vs Zombies\\resources\\src\\IconImage.png");// 导入图片
    }
}
