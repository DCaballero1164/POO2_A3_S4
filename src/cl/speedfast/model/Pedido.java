package cl.speedfast.model;

import cl.speedfast.data.ControladorDeEnvios;
import cl.speedfast.data.Despachable;

import java.io.Serializable;

public abstract class Pedido implements Despachable {

    //Definicion de variables
    private int idPedido;
    private String direccionEntrega;
    double distanciaKm;

    //Se agrega la variable repartidor
    String repartidor;

    //Constructor de la clase Pedido
    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    //Getters
    public int getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public String getRepartidor() {
        return repartidor;
    }

    //Setter
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    // Obligamos a los hijos a definir su nombre y sus reglas antes de mostrar resumen
    public abstract String getTipoEntrega();       // Ej: "Pedido de Comida"
    public abstract String getFactoresAfectanEntrega();   // Ej: "15 min base + 2 min/km"

    //Metodo que muestra el resumen basico del pedido
    public void MostrarResumen() {
        System.out.println("===========================================================================");
        System.out.println("              ...::: Resumen del pedido: " + idPedido + " :::...");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" Tipo de Entrega: " + getTipoEntrega());
        System.out.println(" Dirección:       " + direccionEntrega);
        System.out.println(" Distancia:       " + distanciaKm + " km");
        System.out.println(" Factores Tiempo: " + getFactoresAfectanEntrega());
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" TIEMPO ESTIMADO: " + calcularTiempoEntrega() + " min");
        System.out.println("===========================================================================\n");

    }

    //Metodo comun de subclases
    public abstract int calcularTiempoEntrega();

    //Metodo para asignar repartidor
    public void asignarRepartidor(){
        System.out.println("Asignando repartidor...");
        System.out.println("→ Pedido asignado.");
    }

    //Metodo para asignar repartidor (sobrecarga 1)
    public void asignarRepartidor(String nombre){
        this.repartidor = nombre;
        System.out.println("Asignando repartidor...");
        System.out.println("→ Pedido asignado a "+nombre);
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Pedido{" +
                "direccionEntrega='" + getDireccionEntrega() + '\'' +
                ", idPedido='" + getIdPedido() + '\'' +
                ", tipoPedido='" + getDistanciaKm() + '\'' +
                '}';
    }

    @Override
    public abstract void despachar();
}
