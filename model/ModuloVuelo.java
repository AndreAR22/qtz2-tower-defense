package model;

public class ModuloVuelo extends PiezaDesplegable {

    private int datosRecolectados;

    public ModuloVuelo(
            int id,
            String nombre,
            int salud,
            double costoConstruccion) {

        super(id, nombre, salud, costoConstruccion);
        this.datosRecolectados = 0;
    }

    @Override
    public String procesarCiclo() {
        if (!estaActivo()) {
            return getNombre() + " está destruido.";
        }

        datosRecolectados += 10;

        return getNombre()
                + " recolectó 10 datos científicos."
                + " Total: " + datosRecolectados;
    }

    public int getDatosRecolectados() {
        return datosRecolectados;
    }
}