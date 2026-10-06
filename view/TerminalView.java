package view;

import controller.Quetzal2Controller;
import model.PiezaDesplegable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalView {
    private final Quetzal2Controller controller;
    Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    private int seleccion;

    public TerminalView(Quetzal2Controller controller) {
        this.controller = controller;
    }

    private void showOpciones() {
        System.out.println("\n===== DEFENSA DE QTZ2 =====");
        System.out.println("1. Listar módulos");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Buscar por nombre");
        System.out.println("4. Ordenar por costo");
        System.out.println("5. Procesar ciclo");
        System.out.println("0. Salir");
    }

    public void inicio(){
        while(running){
            showOpciones();
            try {
                seleccion = scanner.nextInt();
                scanner.nextLine();
                switch (seleccion){
                    case 0:
                        running = false;
                        break;
                    case 1:
                        listarModulos();
                        break;
                    case 2:
                        buscarPorId();
                        break;
                    case 3:
                        buscarPorNombre();
                        break;
                    case 4:
                        ordenarPorCosto();
                        break;
                    case 5:
                        procesarCiclo();
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        
        }
    }

    private void listarModulos() {
        for (PiezaDesplegable modulo : controller.listarModulos()) {
            System.out.println(modulo);
        }
    }

    private void buscarPorId() {
        System.out.println("Ingrese el ID del módulo");
        int id = scanner.nextInt();
        scanner.nextLine();

        PiezaDesplegable modulo = controller.buscarPorId(id);

        if (modulo == null) {
            System.out.println("No existe un módulo con el ID " + id + ".");
            return;
        }

        System.out.println(modulo);
    }

    private void buscarPorNombre() {
        System.out.println("Ingrese el nombre del módulo");
        String nombre = scanner.nextLine();

        PiezaDesplegable modulo = controller.buscarPorNombre(nombre);

        if (modulo == null) {
            System.out.println("No existe un módulo con el nombre " + nombre + ".");
            return;
        }

        System.out.println(modulo);
    }

    private void ordenarPorCosto() {
        controller.ordenarPorCosto();
        listarModulos();
    }

    private void procesarCiclo() {
        for (String resultado : controller.procesarCiclo()) {
            System.out.println(resultado);
        }
    }
}
