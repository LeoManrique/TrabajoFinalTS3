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
        
    }
    
}
