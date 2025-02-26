package es.udc.sistemasinteligentes.ejemplo;

import es.udc.sistemasinteligentes.*;

import java.util.ArrayList;
import java.util.List;

public class Estrategia4 implements EstrategiaBusqueda {

    public Estrategia4() {
    }

    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception {
        List<Nodo> explorados = new ArrayList<>();
        Nodo nodoActual = new Nodo(p.getEstadoInicial(), null, null, 0, 0);
        explorados.add(nodoActual);

        int i = 1;

        System.out.println((i++) + " - Empezando búsqueda en " + nodoActual.getEstado());

        while (!p.esMeta(nodoActual.getEstado())) {
            System.out.println((i++) + " - " + nodoActual.getEstado() + " no es meta");
            Accion[] accionesDisponibles = p.acciones(nodoActual.getEstado());
            boolean modificado = false;

            for (Accion acc : accionesDisponibles) {
                Estado nuevoEstado = p.result(nodoActual.getEstado(), acc);
                System.out.println((i++) + " - RESULT(" + nodoActual.getEstado() + "," + acc + ")=" + nuevoEstado);

                boolean yaExplorado = false;
                for (Nodo nodoExplorado : explorados) {
                    if (nodoExplorado.getEstado().equals(nuevoEstado)) {
                        yaExplorado = true;
                        break;
                    }
                }

                if (!yaExplorado) {
                    nodoActual = new Nodo(nuevoEstado, nodoActual, acc, nodoActual.getProfundidad() + 1, nodoActual.getCosteCamino() + acc.getCoste());
                    System.out.println((i++) + " - " + nuevoEstado + " NO explorado");
                    explorados.add(nodoActual);
                    modificado = true;
                    System.out.println((i++) + " - Estado actual cambiado a " + nodoActual.getEstado());
                    break;
                } else {
                    System.out.println((i++) + " - " + nuevoEstado + " ya explorado");
                }
            }

            if (!modificado) throw new Exception("No se ha podido encontrar una solución");
        }

        System.out.println((i++) + " - FIN - " + nodoActual.getEstado());
        return reconstruye_sol(nodoActual);
    }

    private Nodo[] reconstruye_sol(Nodo nodoMeta) {
        List<Nodo> camino = new ArrayList<>();
        while (nodoMeta != null) {
            camino.add(0, nodoMeta);
            nodoMeta = nodoMeta.getPadre();
        }
        return camino.toArray(new Nodo[0]);
    }
}
