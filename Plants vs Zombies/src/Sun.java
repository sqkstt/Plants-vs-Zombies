import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.Random;
import java.util.TimerTask;

public class Sun extends JLabel implements MouseListener {
    Random rand = new Random();
    static final int initialX = 200;//默认的阳光初始位置
    static final int initialY = -150;//默认的阳光初始位置
    int X;
    int Y;
    int fallingSpeed = 5;//阳光的下落速度
    int fallingTime;//阳光的下落时间
    static int SunDisappearTime = 25000;//阳光自然消失时间25s
    JLayeredPane layeredPane;
    boolean isRunning = true;
    public Sun (JLayeredPane layeredPane){
        this.layeredPane = layeredPane;
        this.addMouseListener(this);
        this.setIcon(new ImageIcon("resources\\src\\Sun.gif"));
        this.setOpaque(false);//设置边框为透明
        this.setSize(72,65);
        this.setVisible(true);
        this.X = rand.nextInt(500) + initialX;
        this.Y = initialY;
        this.setLocation(X,Y);
        layeredPane.add(this);
        layeredPane.setLayer(this,100);//设置为第100层
        fallingTime = rand.nextInt(100) + 40;//产生一个下落时间
        Falling(this);
        Disappear(this,this.layeredPane);//阳光自然消失
    }


    public void mouseClicked(MouseEvent e) {
        isRunning = false;
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

    public void Falling(Sun sun) {
        Timer timer = new Timer(true);
        TimerTask fall = new TimerTask() {
            @Override
            public void run() {
                if (!isRunning | sun.Y >= fallingTime * fallingSpeed + initialY | sun.Y >= 400) {
                    cancel();
                    return;
                }
                sun.Y += fallingSpeed;
                sun.setLocation(sun.X,sun.Y);
            }
        };
        timer.schedule(fall,100,100);
    }//阳光自动下落

    public void Disappear(Sun sun, JLayeredPane layerPane) {
        Timer timer = new Timer(true);
        TimerTask disappear = new TimerTask() {
            @Override
            public void run() {
                layerPane.remove(sun);
                layeredPane.repaint();
                isRunning = false;
                cancel();
            }
        };
        timer.schedule(disappear,SunDisappearTime);
    }//阳光自动消失
}
