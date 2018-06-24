package miLista;

import java.util.Random;
import javax.swing.JOptionPane;
import misClases.Comida;
import misClases.Pedido;

public class ListaLEG<E extends Comida> {
    private NodoLEG<E> primero;
    private int talla;
    
    public ListaLEG(){
        this.primero = null;
        this.talla = 0;
    }
    
    public NodoLEG<E> getPrimero(){
        return primero;
    }
    public int getTalla(){
        return talla;
    }
    
    public void insertarAlInicio(E x){
        NodoLEG<E> nuevo = new NodoLEG<>(x);
        nuevo.setSiguiente(primero);
        primero = nuevo;
        talla++;
    }
    public void insertarAlFinal(E x){
        NodoLEG<E> nuevo = new NodoLEG<>(x);
        NodoLEG<E> aux = primero;
        
        if (primero == null){
            primero = nuevo;
        } else {
            while (aux.getSiguiente()!=null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        talla++;
    }

    public void eliminarDato(E x){
        NodoLEG<E> aux = primero, ant = null;
        
        while (aux != null && aux.getDato().equals(x)){
            ant = aux;
            aux = aux.getSiguiente();
        }
        
        if (aux != null){
            talla--;
            if (aux == null){
                primero = primero.getSiguiente();
            } else {
                ant.setSiguiente(aux.getSiguiente());
            }
        }
    }
    
    public void eliminarDatoAleatorio(){
        Random randito = new Random();
        int indice = randito.nextInt(talla);  //desde 0 hasta talla-1
        int contador = 0;
        NodoLEG<E> nodo = primero;
        while (nodo != null){
            if (contador == indice){
                eliminarDato(nodo.getDato());
                break;
            } else {
                nodo = nodo.getSiguiente();
                contador++;
            }
        }
    }
    
    public void agregarNuevaComida(E x){
        NodoLEG<E> nuevo=new NodoLEG<>(x);
        
        NodoLEG<E> ant=null,aux=primero;
        
        if(primero==null){
            insertarAlInicio(x);
        }else{
            
        while(aux!=null && 
         aux.getDato().getNombre().compareToIgnoreCase(x.getNombre())<0){
                ant=aux;
                aux=aux.getSiguiente();
        }
        if(aux!=null){
            if(aux.getDato().getNombre().equalsIgnoreCase(x.getNombre())){
                //JOptionPane.showMessageDialog(null, "La comida ya existe ......");
            }else{
                if(aux==primero){
                    insertarAlInicio(x);
                }else {//insercion entre dos nodos
                    ant.setSiguiente(nuevo);
                    nuevo.setSiguiente(aux);
                    talla++;
                }
            }
        }else{
            insertarAlFinal(x);
        }
        
        
        }    
    }
    public double getMontoLista(){
        double monto = 0;
        NodoLEG<E> aux = primero;
        if (aux != null) {
            monto+=aux.getDato().getMontoAPagar();
            
            while (aux.getSiguiente()!=null){
                aux = aux.getSiguiente();
                monto+=aux.getDato().getMontoAPagar();
            }
        }
        return monto;
    }
    
    public E getComidaMayorMonto(){
        NodoLEG<E> nodo = primero;
        double monto_maximo = 0;
        E comida_maxima = null;
        while (nodo != null){
            if (nodo.getDato().getMontoAPagar() > monto_maximo){
                monto_maximo = nodo.getDato().getMontoAPagar();
                comida_maxima = nodo.getDato();
            }
            nodo = nodo.getSiguiente();
        }
        return comida_maxima;
    }
    
    public String toString(){
        String res = "";
        
        for (NodoLEG<E> aux = primero; aux != null; aux = aux.getSiguiente()){
            res+= (aux.getDato().toString()) + "\n";
        }
        return res;
    }
}
