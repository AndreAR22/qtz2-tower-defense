package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class quetzal2 {

    private final ArrayList<piezaDesplegable> modulos;
    private final ArrayList<amenaza> amenazas;
    private final Random random;

    private int numeroCiclo;

    public quetzal2() {
        modulos = new ArrayList<>();
        amenazas = new ArrayList<>();
        random = new Random();
        numeroCiclo = 0;

        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        modulos.add(new moduloVuelo(
                1, "Cámara orbital", 100, 5000));

        modulos.add(new moduloVuelo(
                2, "Sensor climático", 90, 4200));

        modulos.add(new moduloVuelo(
                3, "Radar espacial", 95, 6000));

        modulos.add(new moduloTierra(
                4, "Antena central", 100, 3500));

        modulos.add(new moduloTierra(
                5, "Antena auxiliar", 85, 2800));

        modulos.add(new moduloTierra(
                6, "Estación de descarga", 90, 4000));

        modulos.add(new moduloEnergia(
                7, "Panel solar norte", 100, 2500));

        modulos.add(new moduloEnergia(
                8, "Panel solar sur", 90, 2500));

        modulos.add(new moduloEnergia(
                9, "Batería principal", 100, 3200));

        modulos.add(new moduloEnergia(
                10, "Batería auxiliar", 80, 2200));

        amenazas.add(new amenaza(
                "Tormenta solar", 15));

        amenazas.add(new amenaza(
                "Radiación espacial", 10));

        amenazas.add(new amenaza(
                "Micrometeorito", 20));
    }

    public List<piezaDesplegable> getModulos() {
        return modulos;
    }

    public int getNumeroCiclo() {
        return numeroCiclo;
    }

    public piezaDesplegable buscarPorId(int id) {
        for (piezaDesplegable modulo : modulos) {
            if (modulo.getId() == id) {
                return modulo;
            }
        }

        return null;
    }

    public piezaDesplegable buscarPorNombre(String nombre) {
        for (piezaDesplegable modulo : modulos) {
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
        for (piezaDesplegable modulo : modulos) {
            resultados.add(modulo.procesarCiclo());
        }

        piezaDesplegable objetivo = obtenerModuloActivo();

        if (objetivo != null && !amenazas.isEmpty()) {
            amenaza amenazaSeleccionada = amenazas.get(
                    random.nextInt(amenazas.size())
            );

            resultados.add(
                    amenazaSeleccionada.atacar(objetivo)
            );
        }

        return resultados;
    }

    private piezaDesplegable obtenerModuloActivo() {
        ArrayList<piezaDesplegable> activos = new ArrayList<>();

        for (piezaDesplegable modulo : modulos) {
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