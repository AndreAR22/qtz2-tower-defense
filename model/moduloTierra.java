package model;

public class moduloTierra extends piezaDesplegable {

    private int datosDescargados;

    public moduloTierra(
            int id,
            String nombre,
            int salud,
            double costoConstruccion) {

        super(id, nombre, salud, costoConstruccion);
        this.datosDescargados = 0;
    }

    @Override
    public String procesarCiclo() {
        if (!estaActivo()) {
            return getNombre() + " está destruido.";
        }

        datosDescargados += 8;

        return getNombre()
                + " descargó 8 datos."
                + " Total: " + datosDescargados;
    }

    public int getDatosDescargados() {
        return datosDescargados;
    }
}