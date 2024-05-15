
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class Sun extends JLabel implements MouseListener {
    int X;
    int Y;
    JLayeredPane layeredPane;
    public Sun (int x,int y,JLayeredPane layeredPane){
        this.layeredPane = layeredPane;
        this.X = x;
        this.Y = y;
        this.addMouseListener(this);
        this.setIcon(new ImageIcon("D:\\Lab\\Plants vs Zombies\\resources\\src\\Sun.gif"));
        this.setSize(72,65);
        this.setVisible(true);
        this.setLocation(X,Y);
        layeredPane.add(this);
        layeredPane.setLayer(this,4);
    }


    public void mouseClicked(MouseEvent e) {
        layeredPane.remove(this);//点击后移除阳光图片
        AppStart appStart = (AppStart)layeredPane;
        appStart.getSunLabel().addCurrentSun(25);//增加当前阳光值
        layeredPane.repaint();
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
}
