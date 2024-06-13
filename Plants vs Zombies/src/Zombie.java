import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.Random;
import java.util.TimerTask;

public class Zombie extends JLabel implements ZombieAction{
    Random rand = new Random();
    static final int zombie_initialX = 1000;
    static final int zombie_initialY = 94;
    static ImageIcon zombie_Picture = AppStart.InitialImage("resources\\src\\Zombie.gif");
    static ImageIcon[] zombiePicture = {AppStart.ChangeImageIcon(new ImageIcon(
                                    "resources\\src\\Zombie.gif"),1.4f,1.4f),
                                        AppStart.ChangeImageIcon(new ImageIcon(
                                    "resources\\src\\ConeHeadZombie.gif"),1.2f,1.6f),
                                        AppStart.ChangeImageIcon(new ImageIcon(
                                    "resources\\src\\BucketHeadZombie.gif"),1.1f,1.6f)};
    int X;
    int Y;
    int lineY;
    int movingSpeed = 1;//僵尸的前进速度
    int HP;
    boolean live;
    boolean attacking;
    JLayeredPane layeredPane;
    public Zombie(int Hp, JLayeredPane layeredPane) {
        //this.layeredPane = layeredPane;
        this.setIcon(zombie_Picture);
        this.setSize(zombie_Picture.getIconWidth(),zombie_Picture.getIconHeight());
        this.setOpaque(false);//设置边框为透明
        this.setVisible(true);
        this.HP = Hp;
        this.live = true;
        this.attacking = false;
        this.X = zombie_initialX;
        this.lineY = rand.nextInt(5);
        this.Y = lineY*88 + zombie_initialY - 50;
        this.setLocation(X,Y);
        layeredPane.add(this);
        layeredPane.setLayer(this,2);//设置为第2层
        move(this);
    }

    public void move(Zombie zombie){
        Timer timer = new Timer(true);
        TimerTask move = new TimerTask() {
            @Override
            public void run() {
                if (zombie.X <= 0 || !zombie.live || zombie.attacking) {
                    cancel();
                    return;
                }
                zombie.X -= movingSpeed;
                zombie.setLocation(zombie.X,zombie.Y);
            }
        };
        TimerTask attack = new TimerTask() {
            @Override
            public void run() {
                if (X >= 224 && X < 214 + 9 * 72) {
                    Attack();
                }
            }
        };
        timer.schedule(attack,0,500);
        timer.schedule(move,0,120);
    }

    @Override
    public void Attack() {
        if (Background.plant[lineY][(X-214)/72] != null ) {
            this.setIcon(AppStart.InitialImage("resources\\src\\ZombieAttack.gif"));
            this.attacking = true;
            Background.plant[lineY][(X-214)/72].HP -= 50;
        }
        else {
            this.attacking = false;
        }
    }

    @Override
    public void Hurt() {

    }
}
