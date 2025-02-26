package es.udc.sistemasinteligentes;

public class Nodo {
    private Estado estado;
    private Nodo padre;
    private Accion accion;
    private int profundidad;
    private double costeCamino;

    public Nodo(Estado estado, Nodo padre, Accion accion, int profundidad, double costeCamino) {
        this.estado = estado;
        this.padre = padre;
        this.accion = accion;
        this.profundidad = profundidad;
        this.costeCamino = costeCamino;
    }

    public Estado getEstado(){
        return estado;
    }
    public Nodo getPadre(){
        return padre;
    }

    public Accion getAccion() {
        return accion;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public double getCosteCamino() {
        return costeCamino;
    }
}
