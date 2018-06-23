package misClases;

import miCola.ArrayCola;
import java.util.ArrayList;

public class GestionPedidos <E extends Pedidos> {
    private ArrayCola<E> cola;
    
    public GestionPedidos() {
        cola = new ArrayCola<>();
    }
    
    public ArrayCola<E> getCola() {
        return cola;
    }
    public boolean validarRepetido(int sucursal){
        ArrayCola<E> colaAux = new ArrayCola<>(); 
        E pedido;
        boolean repetido = false;
        while (!cola.colaVacia()){
            pedido = cola.frentec();
            
            if (pedido.getSucursal() == sucursal){
                repetido = true;
            }
            
            cola.desencolar();
            colaAux.encolar(pedido);
        }
        while (!cola.colaVacia()){
            pedido = cola.frentec();
            colaAux.desencolar();
            cola.encolar(pedido);
        }
        return repetido;
    }
    public void encolarPedido(E x){
        int sucursal = x.getSucursal();
        if (!validarRepetido(sucursal)){
            cola.encolar(x);
        } else {
            System.out.println("La sucursal "+sucursal+" ya existe");
        }
    }
    
    public void atenderSucursalesPares(){
        ArrayCola<E> colaAux = new ArrayCola<>(); 
        E pedido;
        while (!cola.colaVacia()){
            pedido = cola.frentec();
            cola.desencolar();
            if (pedido.getSucursal()%2==0){
                colaAux.encolar(pedido);
            }
        }
        while (!cola.colaVacia()){
            pedido = cola.frentec();
            colaAux.desencolar();
            cola.encolar(pedido);
        }
    }
    
    public void eliminarFinalCola(){
        ArrayCola<E> colaAux = new ArrayCola<>(); 
        E pedido;
        while (!cola.colaVacia()){
            pedido = cola.frentec();
            cola.desencolar();
            if (!cola.colaVacia()){
                colaAux.encolar(pedido);
            }
        }
        while (!cola.colaVacia()){
            pedido = cola.frentec();
            colaAux.desencolar();
            cola.encolar(pedido);
        }
    }
    
}
