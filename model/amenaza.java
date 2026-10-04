package model;

public class amenaza {

    private String nombre;
    private int danio;

    public amenaza(String nombre, int danio) {
        this.nombre = nombre;
        this.danio = danio;
    }

    public String atacar(piezaDesplegable objetivo) {
        if (!objetivo.estaActivo()) {
            return objetivo.getNombre() + " ya está destruido.";
        }

        objetivo.recibirDanio(danio);

        return nombre
                + " atacó a " + objetivo.getNombre()
                + " y causó " + danio + " puntos de daño.";
    }

    public String getNombre() {
        return nombre;
    }

    public int getDanio() {
        return danio;
    }

    @Override
    public String toString() {
        return nombre + " | Daño: " + danio;
    }
}