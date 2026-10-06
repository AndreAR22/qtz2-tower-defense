package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quetzal2 {

    private final ArrayList<PiezaDesplegable> modulos;
    private final ArrayList<Amenaza> amenazas;

    private int numeroCiclo;

    public Quetzal2() {
        modulos = new ArrayList<>();
        amenazas = new ArrayList<>();
        numeroCiclo = 0;
    }

    public void registrarModulo(PiezaDesplegable modulo) {
        modulos.add(modulo);
    }

    public void registrarAmenaza(Amenaza amenaza) {
        amenazas.add(amenaza);
    }

    public List<PiezaDesplegable> getModulos() {
        return Collections.unmodifiableList(modulos);
    }

    public List<Amenaza> getAmenazas() {
        return Collections.unmodifiableList(amenazas);
    }

    public int getNumeroCiclo() {
        return numeroCiclo;
    }

    public void incrementarCiclo() {
        numeroCiclo++;
    }

    public PiezaDesplegable buscarPorId(int id) {
        for (PiezaDesplegable modulo : modulos) {
            if (modulo.getId() == id) {
                return modulo;
            }
        }

        return null;
    }

    public PiezaDesplegable buscarPorNombre(String nombre) {
        for (PiezaDesplegable modulo : modulos) {
            if (modulo.getNombre().equalsIgnoreCase(nombre)) {
                return modulo;
            }
        }

        return null;
    }

    public void ordenarPorCosto() {
        Collections.sort(modulos);
    }
}
