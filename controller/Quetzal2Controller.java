package controller;

import model.Amenaza;
import model.ModuloEnergia;
import model.ModuloTierra;
import model.ModuloVuelo;
import model.PiezaDesplegable;
import model.Quetzal2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quetzal2Controller {

    private final Quetzal2 qtz2;
    private final Random random;

    public Quetzal2Controller() {
        this(new Random());
    }

    public Quetzal2Controller(Random random) {
        this.random = random;
        this.qtz2 = new Quetzal2();

        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        qtz2.registrarModulo(new ModuloVuelo(
                1, "Cámara orbital", 100, 5000));

        qtz2.registrarModulo(new ModuloVuelo(
                2, "Sensor climático", 90, 4200));

        qtz2.registrarModulo(new ModuloVuelo(
                3, "Radar espacial", 95, 6000));

        qtz2.registrarModulo(new ModuloTierra(
                4, "Antena central", 100, 3500));

        qtz2.registrarModulo(new ModuloTierra(
                5, "Antena auxiliar", 85, 2800));

        qtz2.registrarModulo(new ModuloTierra(
                6, "Estación de descarga", 90, 4000));

        qtz2.registrarModulo(new ModuloEnergia(
                7, "Panel solar norte", 100, 2500));

        qtz2.registrarModulo(new ModuloEnergia(
                8, "Panel solar sur", 90, 2500));

        qtz2.registrarModulo(new ModuloEnergia(
                9, "Batería principal", 100, 3200));

        qtz2.registrarModulo(new ModuloEnergia(
                10, "Batería auxiliar", 80, 2200));

        qtz2.registrarAmenaza(new Amenaza(
                "Tormenta solar", 15));

        qtz2.registrarAmenaza(new Amenaza(
                "Radiación espacial", 10));

        qtz2.registrarAmenaza(new Amenaza(
                "Micrometeorito", 20));
    }

    public Quetzal2 getQtz2() {
        return qtz2;
    }

    public List<PiezaDesplegable> listarModulos() {
        return qtz2.getModulos();
    }

    public PiezaDesplegable buscarPorId(int id) {
        return qtz2.buscarPorId(id);
    }

    public PiezaDesplegable buscarPorNombre(String nombre) {
        return qtz2.buscarPorNombre(nombre);
    }

    public void ordenarPorCosto() {
        qtz2.ordenarPorCosto();
    }

    public ArrayList<String> procesarCiclo() {
        ArrayList<String> resultados = new ArrayList<>();

        qtz2.incrementarCiclo();

        // Aquí se aplica el polimorfismo
        for (PiezaDesplegable modulo : qtz2.getModulos()) {
            resultados.add(modulo.procesarCiclo());
        }

        List<Amenaza> amenazas = qtz2.getAmenazas();
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

        for (PiezaDesplegable modulo : qtz2.getModulos()) {
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
