package view;

import java.util.Scanner;

public class TerminalView {
    Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    private int seleccion;

    private void showOpciones() {
        System.out.println("\n===== DEFENSA DE QTZ2 =====");
        System.out.println("1. Listar módulos");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Buscar por nombre");
        System.out.println("4. Ordenar por costo");
        System.out.println("0. Salir");
    }

    


    public void inicio(){
        while(running){
            showOpciones();
            seleccion = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (seleccion){
                    case 0:
                        running = false;
                        break;
                    case 1:
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }    
}
