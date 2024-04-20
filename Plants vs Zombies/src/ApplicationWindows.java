import jdk.internal.dynalink.beans.StaticClass;
import javax.swing.*;
import java.awt.*;

public class ApplicationWindows extends JFrame{
    private static JFrame ApplicationWindows; //声明一个静态的顶级容器，方便后续调用
    public ApplicationWindows() {
    }
    // 无参构造方法
    public static void main(String[] args) {
        SelectCondition();
    }//程序启动
    public static void SelectCondition () {
        if(ApplicationWindows != null) {
            ApplicationWindows.dispose();
        }//每次开始前，把容器清空
        ApplicationWindows = new JFrame("Plants vs Zombies"); //创建一个窗口实例
        AppStart AppStart = new AppStart();
        ApplicationWindows.setIconImage(AppStart.imageIcon.getImage());// 设置游戏图标
        ApplicationWindows.add(AppStart);// 游戏启动入口，添加组件使用
        ApplicationWindows.setSize(1000,618); // 设置窗口大小
        ApplicationWindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时，结束程序
        ApplicationWindows.setLocationRelativeTo(null);// 将窗口设置位于容器中心位置
        ApplicationWindows.setVisible(true);// 设置容器可见
    }
    public static void gameplay() {
        ApplicationWindows.dispose();
        System.gc();
        ApplicationWindows = new JFrame("Plants vs Zombies"); //创建一个窗口实例
        AppStart AppStart = new AppStart(true);
        ApplicationWindows.setIconImage(AppStart.imageIcon.getImage());// 设置游戏图标
        ApplicationWindows.add(AppStart);//游戏启动入口
        ApplicationWindows.setSize(1256,638); // 设置窗口大小
        ApplicationWindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时，结束程序
        ApplicationWindows.setLocationRelativeTo(null);// 将窗口设置位于容器中心位置
        ApplicationWindows.setVisible(true);// 设置容器可见
    }
}
