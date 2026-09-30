import javax.swing.JFrame;

import view.Game;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        
        window.setTitle("Quetzal 2 Tower Defense");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        Game game = new Game();
        
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        game.iniciarGameThread();
    }
}
