package model;

public class moduloVuelo extends piezaDesplegable {

    private int datosRecolectados;

    public moduloVuelo(
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
            return getNombre() + "Se ha destruido, diablos.";
        }

        datosRecolectados += 10;

        return getNombre()
                + " Se han recolectado 10 datos, increíble. Total: "
                + datosRecolectados;
    }

    public int getDatosRecolectados() {
        return datosRecolectados;
    }
}