package pe.incubadora.backend.api;

public class TipoCambioResponse {
    private String fecha;
    private double compra;
    private double venta;
    private String fuente;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCompra() {
        return compra;
    }

    public void setCompra(double compra) {
        this.compra = compra;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }



    public TipoCambioResponse(String fecha, String fuente, double venta, double compra) {
        this.fecha = fecha;
        this.fuente = fuente;
        this.venta = venta;
        this.compra = compra;
    }
}
