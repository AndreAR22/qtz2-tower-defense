package model;

public abstract class PiezaDesplegable
        implements Comparable<PiezaDesplegable> {

    private int id;
    private String nombre;
    private int salud;
    private double costoConstruccion;

    public PiezaDesplegable(
            int id,
            String nombre,
            int salud,
            double costoConstruccion) {

        this.id = id;
        this.nombre = nombre;
        this.salud = salud;
        this.costoConstruccion = costoConstruccion;
    }

    public abstract String procesarCiclo();

    public void recibirDanio(int danio) {
        salud -= danio;

        if (salud < 0) {
            salud = 0;
        }
    }

    public boolean estaActivo() {
        return salud > 0;
    }

    @Override
    public int compareTo(PiezaDesplegable otraPieza) {
        return Double.compare(
                this.costoConstruccion,
                otraPieza.costoConstruccion
        );
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public double getCostoConstruccion() {
        return costoConstruccion;
    }

    @Override
    public String toString() {
        return "Tipo: " + getClass().getSimpleName()
                + " | ID: " + id
                + " | Nombre: " + nombre
                + " | Salud: " + salud
                + " | Costo: Q" + costoConstruccion;
    }
}
