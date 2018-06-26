package misClases;

import miLista.ListaLEG;
import miLista.NodoLEG;

public class Pedido extends Object {
    private int sucursal;
    private double montoR;
    private ListaLEG<Comida> lista;

    public Pedido(int sucursal) {
        this.sucursal = sucursal;
        this.montoR = 0;
        this.lista = new ListaLEG<>();
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

    public void calcularMontoR() {
        double monto = 0;
        if (lista.getTalla() > 0){
            monto = lista.getMontoLista();
            this.montoR = monto;
        }
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
    public String toString(){
        String output = "La sucursal:"+sucursal+", con monto :"+montoR+"tiene las comidas:\n";
        output+= getLista().toString();
        return output;
    }
}
