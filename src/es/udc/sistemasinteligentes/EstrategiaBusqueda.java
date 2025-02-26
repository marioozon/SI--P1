package es.udc.sistemasinteligentes;

public interface EstrategiaBusqueda {
    /**
     * MODIFICADA
     * Soluciona el problema de búsqueda, obteniendo un camino de nodos desde el estado inicial hasta un estado meta
     * o arrojando una excepción si no encuentra una solución.
     *
     * @param p Problema a solucionar
     * @return Array de nodos que representan la solución encontrada
     * @throws Exception si no se encuentra solución
     */
    public abstract Nodo[] soluciona(ProblemaBusqueda p) throws Exception;
}
