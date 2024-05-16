import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Seed extends JLabel implements MouseListener, MouseMotionListener {
    static int CardNum = 0;//卡片数量
    JLayeredPane layeredPane;
    public Seed(ImageIcon Plant, int price, JLayeredPane layeredPane) {
        this.layeredPane = layeredPane;

        GenerateCard(layeredPane);//设置卡背景
        AppearPrice(price, layeredPane);//显示价格

        this.setIcon(Plant);
        this.setSize(Plant.getIconWidth(),Plant.getIconHeight());
        this.setVisible(true);
        this.setLocation(291+(int)(CardNum*100.0/2.2),33);//设置植物卡对应植物
        layeredPane.add(this);
        layeredPane.setLayer(this,2);
        CardNum++;
    }
    public void GenerateCard(JLayeredPane layeredPane) {
        ImageIcon Card = new ImageIcon("resources\\src\\SeedPacket_Larger.png");   //创建一个图像
        Image scaledCard = Card.getImage().getScaledInstance((int)(Card.getIconWidth()/2.2),
                (int)(Card.getIconHeight()/2.2), Image.SCALE_SMOOTH);
        Card = new ImageIcon(scaledCard);   // 调整植物卡图像大小
        JLabel card = new JLabel(Card);   //创建一个JLabel板
        card.addMouseListener(this);
        card.setBounds(286+Card.getIconWidth()*CardNum,24, Card.getIconWidth(), Card.getIconHeight());   //设置位置大小
        card.setVisible(true);
        layeredPane.add(card);
        layeredPane.setLayer(card,1);
    }
    public void AppearPrice(int price, JLayeredPane layeredPane) {
        JLabel Price = new JLabel();
        Price.setSize(20,10);
        Price.setHorizontalAlignment(SwingConstants.RIGHT);//设置右对齐
        Price.setFont(new Font("Continuum",Font.BOLD,12));//设置字体(似乎有点失败，太丑)
        Price.setText(Integer.toString(price));
        Price.setLocation(295+(int)(CardNum*100.0/2.2),73);
        Price.setVisible(true);
        layeredPane.add(Price);
        layeredPane.setLayer(Price,2);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
