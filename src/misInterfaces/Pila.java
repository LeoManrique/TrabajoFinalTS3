package misInterfaces;

public interface Pila<E>{
    void apilar(E x);
    void desapilar();
    E tope();
    boolean pilaVacia();
    boolean pilaLlena();
}
