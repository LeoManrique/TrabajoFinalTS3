package miCola;

import misClases.Pedidos;

public interface Cola<E extends Pedidos> {
    void encolar(E x);
    void desencolar();
    E frentec();
    boolean colaVacia();
    boolean colaLlena();
}
