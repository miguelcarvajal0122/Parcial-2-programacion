package modelo;

public class Pedido {
    private int id;
    private int mesaId;
    private int clienteId;
    private String estado;
    private String fecha;

    public Pedido(int id, int mesaId, int clienteId, String estado, String fecha) {
        this.id = id;
        this.mesaId = mesaId;
        this.clienteId = clienteId;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public int getMesaId() { return mesaId; }
    public int getClienteId() { return clienteId; }
    public String getEstado() { return estado; }
    public String getFecha() { return fecha; }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public String toString() {
        return "Pedido [ID: " + id + ", Mesa: " + mesaId + ", Cliente: " + clienteId + 
               ", Estado: " + estado + ", Fecha: " + fecha + "]";
    }
}
