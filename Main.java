//import javax.swing.JFrame;

import controller.Quetzal2Controller;

//import view.GamePanel;
import view.TerminalView;

public class Main {
    public static void main(String[] args) {
        /* Vista grafica usando JFrame
        JFrame window = new JFrame();
        
        window.setTitle("Quetzal 2 Tower Defense");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        GamePanel game = new GamePanel();
        
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        game.iniciarGameThread();*/

        TerminalView terminal = new TerminalView(new Quetzal2Controller());
        terminal.inicio();
        
    }
}
