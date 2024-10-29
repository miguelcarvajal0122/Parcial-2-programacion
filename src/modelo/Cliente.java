package modelo;

public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private int puntos;

    public Cliente(int id, String nombre, String email, int puntos) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.puntos = puntos;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public int getPuntos() { return puntos; }

    public void acumularPuntos(int puntosGanados) {
        this.puntos += puntosGanados;
    }

    @Override
    public String toString() {
        return "Cliente [ID: " + id + ", Nombre: " + nombre + ", Email: " + email + ", Puntos: " + puntos + "]";
    }
}
