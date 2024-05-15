import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//菜单类
public class MyMenu extends JPanel implements MouseListener {
    JLabel start;
    JLabel Menu;
    //菜单类构造方法
    public MyMenu(JLayeredPane layeredPane) {
        this.setSize(1000, 618);
        this.setVisible(true);
        this.setLayout(null);//取消默认布局
        addMouseListener(this);//加入鼠标监听
        ImageIcon menu = new ImageIcon("D:\\Lab\\Plants vs Zombies\\resources\\src\\menu.png");   //创建一个图像
        Image scaledMenu = menu.getImage().getScaledInstance(1000, 618, Image.SCALE_SMOOTH);
        menu = new ImageIcon(scaledMenu);
        Menu = new JLabel(menu);
        Menu.setBounds(0,0, menu.getIconWidth(),menu.getIconHeight());


        ImageIcon Start = new ImageIcon("D:\\Lab\\Plants vs Zombies\\resources\\src\\start.png");   //创建一个图像
        Image scaledStart = Start.getImage().getScaledInstance(350, 148, Image.SCALE_SMOOTH);
        Start = new ImageIcon(scaledStart);
        start = new JLabel(Start);
        start.setBounds(530,90,Start.getIconWidth(),Start.getIconHeight());
        this.add(start);
        this.add(Menu);
        layeredPane.add(this);//加入此标签到面板
        layeredPane.setLayer(this, 0);//设置标签为第0层
    }

    @Override
    //点击指定区域即可开始游戏
    public void mouseClicked(MouseEvent e) {
        if (e.getX() > 470 && e.getX() < 750 && e.getY() > 90 && e.getY() < 240) {
            ApplicationWindows.gameplay();
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
    /*这四个都是鼠标监听器中的方法必须实现*/
}
