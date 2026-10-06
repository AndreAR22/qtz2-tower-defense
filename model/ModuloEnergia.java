package model;

public class ModuloEnergia extends PiezaDesplegable {

    private int energiaGenerada;

    public ModuloEnergia(
            int id,
            String nombre,
            int salud,
            double costoConstruccion) {

        super(id, nombre, salud, costoConstruccion);
        this.energiaGenerada = 0;
    }

    @Override
    public String procesarCiclo() {
        if (!estaActivo()) {
            return getNombre() + " está destruido.";
        }

        energiaGenerada += 15;

        return getNombre()
                + " generó 15 unidades de energía."
                + " Total: " + energiaGenerada;
    }

    public int getEnergiaGenerada() {
        return energiaGenerada;
    }
}