package misClases;

public class Pedidos {
    private int sucursal;
    private double montoR;
    private ListaLEG lista;

    public Pedidos(int sucursal, double montoR, ListaLEG lista) {
        this.sucursal = sucursal;
        this.montoR = montoR;
        this.lista = lista;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public double getMontoR() {
        return montoR;
    }

    public void setMontoR(double montoR) {
        this.montoR = montoR;
    }

    public ListaLEG getLista() {
        return lista;
    }

    public void setLista(ListaLEG lista) {
        this.lista = lista;
    }
    
}
