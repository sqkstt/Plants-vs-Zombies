import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

//太阳面板类
public class SunLabel extends JLabel {
    int total = 100;//太阳值
    static int SunGenerateTime = 10000;//阳光生成时间10s
    public SunLabel(JLayeredPane layeredPane) {
        total = 100;
        this.setVisible(true);
        this.setText(Integer.toString(total));//设置初始阳光值
        this.setSize(300, 300);
        this.setLocation(244, -71);
        layeredPane.add(this);//加入此标签到面板
        layeredPane.setLayer(this, 2);//设置标签为第一百层
    }
    //构造方法
    public int getCurrentSun() {
        return total;
    }
    //得到当前太阳值
    public void addCurrentSun(int x) {
        total += x;
        this.setText(Integer.toString(total));
    }
    //当前太阳值
    public void SunGenerate(JLayeredPane layerPane,int a) {
        if (a == 1){
            Timer sunTimer = new Timer(true);
            TimerTask generate = new TimerTask() {
                @Override
                public void run() {
                    Sun sun = new Sun(layerPane);
                }
            };
            sunTimer.schedule(generate,0, SunGenerateTime);
        }
    }
}
