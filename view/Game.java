package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{
    final int WIDTH = 800;
    final int HEIGHT = 600;
    final int FPS = 60;
    
    Thread gameThread;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void iniciarGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        while (gameThread != null){
            System.out.println("Running");
        }
    }
}
