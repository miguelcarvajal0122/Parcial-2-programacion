package interfaces;

import interfaces.IMostrarMensaje;

public interface IMostrarMensaje {
    default void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
