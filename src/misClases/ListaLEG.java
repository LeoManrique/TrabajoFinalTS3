package misClases;

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
    public String toString(){
        String res = "";
        
        for (NodoLEG<E> aux = primero; aux != null; aux = aux.getSiguiente()){
            res = res + (aux.getDato().toString()) + "\n";
        }
        return res;
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
    /*public void agregarNuevoUsuario(E x){
        NodoLEG<E> nuevo=new NodoLEG<>(x);
        
        NodoLEG<E> ant=null,aux=primero;
        
        if(primero==null){
            insertarAlInicio(x);
        }else{
            
        while(aux!=null && 
         aux.getDato().getNom_afiliado().compareToIgnoreCase(x.getNom_afiliado())<0){
                ant=aux;
                aux=aux.getSiguiente();
        }
        if(aux!=null){
            if(aux.getDato().getNom_afiliado().equalsIgnoreCase(x.getNom_afiliado())){
                JOptionPane.showMessageDialog(null, "Usuario ya existe ......");
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
    }*/
}
