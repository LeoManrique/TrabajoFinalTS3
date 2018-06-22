package misClases;

import misInterfaces.*;

public class ArrayCola<E> implements Cola<E>{
    protected static final int TAMAÑO = 50;
    protected E[] arC;
    protected int frentec, finalc;

    public ArrayCola() {
        this.arC = (E[]) new Object[TAMAÑO];
        this.frentec = -1;
        this.finalc = -1;
    }
    public void prueba(Object x){
        if (x instanceof String){
            
        }
    }
    @Override
    public void encolar(E x){
        if (colaLlena()){
            System.out.println("Cola llena...");
        } else {
            if (colaVacia()){
                frentec=0;
            }
            if(finalc==TAMAÑO-1){
                finalc=0;
            } else {
                finalc++;
            }
            arC[finalc]=x;
        }
    }
    @Override
    public void desencolar(){
        if (colaVacia()){
            System.out.println("Cola Vacia...");
        } else if (frentec == finalc){
            arC[frentec] = null;
            frentec=-1;
            finalc=-1;
        } else if (frentec == TAMAÑO-1){
            arC[frentec] = null;
            frentec=0;
        } else {
            arC[frentec] = null;
            frentec ++;
        }
        
    }
    @Override
    public E frentec(){
        return arC[frentec];
    }
    public E[] getArc(){
        return arC;
    }
    public int getFrentec(){
        return frentec;
    }
    public int getFinalc(){
        return finalc;
    }
    
    @Override
    public boolean colaVacia(){
    return (frentec==-1 && finalc==-1);
    }
    @Override
    public boolean colaLlena(){
    return ((frentec==0 && finalc==TAMAÑO-1) || frentec == finalc+1);
    }

}