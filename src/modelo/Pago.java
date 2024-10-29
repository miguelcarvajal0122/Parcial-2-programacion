package modelo;

public class Pago {
    private int id;
    private int facturaId;
    private String metodoPago;
    private double monto;

    public Pago(int id, int facturaId, String metodoPago, double monto) {
        this.id = id;
        this.facturaId = facturaId;
        this.metodoPago = metodoPago;
        this.monto = monto;
    }

    public int getId() { return id; }
    public int getFacturaId() { return facturaId; }
    public String getMetodoPago() { return metodoPago; }
    public double getMonto() { return monto; }

    @Override
    public String toString() {
        return "Pago [ID: " + id + ", Factura ID: " + facturaId + ", Método: " + metodoPago + 
               ", Monto: $" + monto + "]";
    }
}
