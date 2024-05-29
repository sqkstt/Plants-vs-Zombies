import javafx.geometry.HPos;

import javax.swing.*;

public class Plant extends JLabel implements PlantAction{
    int X;
    int Y;
    int HP = 0;
    boolean live;
    public Plant(int initHP,int intiX,int initY) {
        super();
        this.HP = initHP;
        this.X = intiX;
        this.Y = initY;
        this.live = true;
    }

    @Override
    public void hurt() {

    }

    @Override
    public void produce() {

    }

    @Override
    public void attack() {

    }
}
