package misClases;

public class GestionPedidos <E extends Pedidos> {
    private ArrayCola<E> cola;
    
    public GestionPedidos() {
        cola = new ArrayCola<>();
    }
    
    public ArrayCola<E> getCola() {
        return cola;
    }
    
    public void encolarPedido(E x){
        cola.encolar(x);
        //falta validar que el num de sucursal no se repita
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
    
}
