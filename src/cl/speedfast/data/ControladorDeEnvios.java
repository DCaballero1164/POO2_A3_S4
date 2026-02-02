package cl.speedfast.data;

import java.util.ArrayList;
import cl.speedfast.model.*;

public class ControladorDeEnvios implements Rastreable {
    // Lista para guardar el historial de entregas
    private ArrayList<String> historial = new ArrayList<>();

    // Metodo para registrar una entrega en el historial
    public void registrarEntrega(Pedido pedido) {
        historial.add(pedido.getClass().getSimpleName() + " #" + pedido.getIdPedido() +
                " – entregado por " + pedido.getRepartidor());
    }

    // Metodo para mostrar el historial completo
    @Override
    public void verHistorial() {
        System.out.println("Historial:");
        for (String registro : historial) {
            System.out.println("- " + registro);
        }
    }
}
