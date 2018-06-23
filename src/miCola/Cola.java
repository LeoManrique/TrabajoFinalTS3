package miCola;

import misClases.Pedidos;

public interface Cola<E> {
    void encolar(E x);
    void desencolar();
    E frentec();
    boolean colaVacia();
    boolean colaLlena();
}
