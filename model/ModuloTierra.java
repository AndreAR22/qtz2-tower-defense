package model;

public class ModuloTierra extends PiezaDesplegable {

    private int datosDescargados;

    public ModuloTierra(
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