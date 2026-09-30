import javax.swing.JFrame;

import view.GamePanel;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        
        window.setTitle("Quetzal 2 Tower Defense");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        GamePanel game = new GamePanel();
        
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        game.iniciarGameThread();
    }
}
