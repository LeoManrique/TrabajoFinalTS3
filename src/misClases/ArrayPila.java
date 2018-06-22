package misClases;

import misInterfaces.Pila;

public class ArrayPila<E> implements Pila<E>{
    protected static final int TAMAÑO = 50;
    protected E[] arP;
    protected int tope;
    
    public ArrayPila(){
        arP= (E[]) new Object[TAMAÑO];
        tope = -1;
    }
    
    @Override
    public void apilar(E x){
        if (pilaLlena()){
            System.out.println("Pila llena...");
        } else {
            tope ++;
            arP[tope]=x;
        }
    }
    @Override
    public void desapilar(){
        arP[tope] = null;
        tope--;
    }
    @Override
    public E tope(){
        return arP[tope];
    }
    @Override
    public boolean pilaVacia(){
        return (tope==-1);
    }
    @Override
    public boolean pilaLlena(){
        return (tope==TAMAÑO);
    }

    public int getTope() {
        return tope;
    }
    
    public String mostrarPila(){
        String res = "";
        ArrayPila<E> pAux = new ArrayPila<>();
        while (!pilaVacia()){
            res = res+tope().toString()+"\n";
            pAux.apilar(tope());
            desapilar();
        }
        while (!pAux.pilaVacia()){
            apilar(pAux.tope());
            pAux.desapilar();
        }
        return res;
    }
}
