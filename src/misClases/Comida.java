package misClases;

public class Comida {
    private String nombre;
    private double precio;
    private int cantidad;

    public Comida(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getMontoAPagar(){
        return precio*cantidad;
    }
    
    @Override
    public String toString(){
        return "El monto a pagar por "+nombre+" es "+getMontoAPagar();
    }
}
