package miCola;

import misClases.Pedido;

public interface Cola<E extends Pedido> {
    void encolar(E x);
    void desencolar();
    E frentec();
    boolean colaVacia();
    boolean colaLlena();
}
