package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quetzal2 {

    private final ArrayList<PiezaDesplegable> modulos;
    private final ArrayList<Amenaza> amenazas;
    private final Random random;

    private int numeroCiclo;

    public Quetzal2() {
        modulos = new ArrayList<>();
        amenazas = new ArrayList<>();
        random = new Random();
        numeroCiclo = 0;

        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        modulos.add(new ModuloVuelo(
                1, "Cámara orbital", 100, 5000));

        modulos.add(new ModuloVuelo(
                2, "Sensor climático", 90, 4200));

        modulos.add(new ModuloVuelo(
                3, "Radar espacial", 95, 6000));

        modulos.add(new ModuloTierra(
                4, "Antena central", 100, 3500));

        modulos.add(new ModuloTierra(
                5, "Antena auxiliar", 85, 2800));

        modulos.add(new ModuloTierra(
                6, "Estación de descarga", 90, 4000));

        modulos.add(new ModuloEnergia(
                7, "Panel solar norte", 100, 2500));

        modulos.add(new ModuloEnergia(
                8, "Panel solar sur", 90, 2500));

        modulos.add(new ModuloEnergia(
                9, "Batería principal", 100, 3200));

        modulos.add(new ModuloEnergia(
                10, "Batería auxiliar", 80, 2200));

        amenazas.add(new Amenaza(
                "Tormenta solar", 15));

        amenazas.add(new Amenaza(
                "Radiación espacial", 10));

        amenazas.add(new Amenaza(
                "Micrometeorito", 20));
    }

    public List<PiezaDesplegable> getModulos() {
        return modulos;
    }

    public int getNumeroCiclo() {
        return numeroCiclo;
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

    public ArrayList<String> procesarCiclo() {
        ArrayList<String> resultados = new ArrayList<>();

        numeroCiclo++;

        // Aquí se aplica el polimorfismo.
        for (PiezaDesplegable modulo : modulos) {
            resultados.add(modulo.procesarCiclo());
        }

        PiezaDesplegable objetivo = obtenerModuloActivo();

        if (objetivo != null && !amenazas.isEmpty()) {
            Amenaza amenazaSeleccionada = amenazas.get(
                    random.nextInt(amenazas.size())
            );

            resultados.add(
                    amenazaSeleccionada.atacar(objetivo)
            );
        }

        return resultados;
    }

    private PiezaDesplegable obtenerModuloActivo() {
        ArrayList<PiezaDesplegable> activos = new ArrayList<>();

        for (PiezaDesplegable modulo : modulos) {
            if (modulo.estaActivo()) {
                activos.add(modulo);
            }
        }

        if (activos.isEmpty()) {
            return null;
        }

        return activos.get(
                random.nextInt(activos.size())
        );
    }
}