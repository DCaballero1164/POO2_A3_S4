package cl.speedfast.app;

import cl.speedfast.model.*;
import cl.speedfast.data.*;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        //Se instancia el controlador de envios para manejar el historial
        ControladorDeEnvios controlador = new ControladorDeEnvios();

        //Se crean pedidos de prueba
        PedidoComida pedido1 = new PedidoComida(1,"Avenida Evergreen 742, Springfield", 100.5);
        PedidoEncomienda pedido2 = new PedidoEncomienda(2,"Avenida Principal 123, Santiago", 50.0);
        PedidoExpress pedido3 = new PedidoExpress(3,"Avenida Valparaiso 1001, Villa Alemana", 60.9);
        PedidoComida pedido4 = new PedidoComida(4,"Av. Pacífico 321, Viña del Mar", 70.0);
        PedidoEncomienda pedido5 = new PedidoEncomienda(5,"Calle Este 654, Quilpué", 40.0);
        PedidoExpress pedido6 = new PedidoExpress(6,"Plaza Oeste 987, Concón", 25.0);

        //Se visualiza el resumen de pedidos
        System.out.println("=== RESUMEN DE PEDIDOS ===\n");
        pedido1.MostrarResumen();
        pedido2.MostrarResumen();
        pedido3.MostrarResumen();
        pedido4.MostrarResumen();
        pedido5.MostrarResumen();
        pedido6.MostrarResumen();

        //Se muestran los tiempos de entrega
        System.out.println("=== TIEMPOS ESTIMADOS DE ENTREGA ===\n");

        // Mostramos solo los tiempos de forma clara y comparativa
        System.out.println("Pedido "+pedido1.getTipoEntrega()+" (ID: " + pedido1.getIdPedido() + "): "
                + pedido1.calcularTiempoEntrega() + " min.");

        System.out.println("Pedido "+pedido2.getTipoEntrega()+" (ID: " + pedido2.getIdPedido() + "): "
                + pedido2.calcularTiempoEntrega() + " min.");

        System.out.println("Pedido "+pedido3.getTipoEntrega()+" (ID: " + pedido3.getIdPedido() + "): "
                + pedido3.calcularTiempoEntrega() + " min.");

        System.out.println("Pedido "+pedido4.getTipoEntrega()+" (ID: " + pedido4.getIdPedido() + "): "
                + pedido4.calcularTiempoEntrega() + " min.");

        System.out.println("Pedido "+pedido5.getTipoEntrega()+" (ID: " + pedido5.getIdPedido() + "): "
                + pedido5.calcularTiempoEntrega() + " min.");

        System.out.println("Pedido "+pedido6.getTipoEntrega()+" (ID: " + pedido6.getIdPedido() + "): "
                + pedido6.calcularTiempoEntrega() + " min.");

        System.out.println("------------------------------------\n");


        // Crear repartidores con listas de pedidos
        Repartidor r1 = new Repartidor("Luis Díaz", Arrays.asList(pedido1, pedido2));
        Repartidor r2 = new Repartidor("Daniela Tapia", Arrays.asList(pedido3, pedido4));
        Repartidor r3 = new Repartidor("Carlos Rivas", Arrays.asList(pedido5, pedido6));

        // ExecutorService con un pool de 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Ejecutar repartidores en paralelo
        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        // Cerrar el ExecutorService cuando terminen
        executor.shutdown();

        // Mostrar historial final (se puede actualizar desde cada repartidor)
        controlador.verHistorial();
    }
}
