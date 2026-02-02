package cl.speedfast.model;

import java.util.List;
import java.util.Random;

//Se implementa Runnable en la clase Repartidor
public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidos;
    private Random random = new Random();

    public Repartidor(String nombre, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    @Override
    public void run() {
        System.out.println("-> Repartidor " + nombre + " inicia sus entregas.\n");
        for (Pedido pedido : pedidos) {
            System.out.println(nombre + " está en camino con el pedido ID: " + pedido.getIdPedido()+"\n") ;
            try {
                // Simula tiempo inicial de entrega
                int tiempoInicial = random.nextInt(2000) + 1000; // entre 1 y 3 segundos
                Thread.sleep(tiempoInicial);

                // Mensaje de avance
                System.out.println(nombre + " avanzando... Pedido ID: " + pedido.getIdPedido()+"\n");

                // Retraso adicional antes de la entrega final
                int tiempoFinal = random.nextInt(4000) + 1000; // entre 1 y 3 segundos
                Thread.sleep(tiempoFinal);

                // Mensaje de entrega completada
                System.out.println(nombre + " completó entrega del pedido ID: " + pedido.getIdPedido() +
                        " en " + (tiempoInicial + tiempoFinal) + " ms.\n");
            } catch (InterruptedException e) {
                System.out.println(nombre + " fue interrumpido durante la entrega.\n");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("-> Repartidor " + nombre + " terminó todas sus entregas.\n");
    }
}
