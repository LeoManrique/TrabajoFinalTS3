package misClases;

public class GestionPedidos {
    private ArrayCola<Pedidos> cola;
    
    public GestionPedidos() {
        cola = new ArrayCola<>();
    }
    
    public ArrayCola<Pedidos> getCola() {
        return cola;
    }
    
    
}
