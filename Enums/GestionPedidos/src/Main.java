import servicios.MenuServicio;

public class Main {
    public static void main(String[] args) {
        MenuServicio menuServicio = new MenuServicio();
        menuServicio.mostrarMenu();
    }
}
/*CONSIGNA:
Desarrolla una aplicación de gestión de pedidos utilizando el patrón experto. Comienza por implementar un Enum llamado 
“EstadoPedido”, el cual representará los distintos estados posibles de un pedido: "pendiente", "enviado" y "entregado".

A continuación:

Crea la clase “Pedido”, que contendrá los siguientes atributos: “numeroDePedido”, “cliente”, “listaDeProductos” y 
“estadoDelPedido”. El estado del pedido debe ser una constante de la enumeración "EstadoPedido", y la lista de productos 
será un array de Strings.

Desarrolla la clase “PedidoServicio”, encargada de gestionar los pedidos. Esta clase deberá incluir métodos para crear 
un nuevo pedido, actualizar el estado de un pedido existente, buscar pedidos por estado y obtener la lista completa de 
pedidos, permitiendo también realizar filtros sobre la misma.

Crea la clase “MenuServicio” para interactuar con el usuario al inicio de la aplicación. Este menú debe ofrecer opciones 
para crear un nuevo pedido, actualizar el estado de un pedido, buscar pedidos por estado, mostrar la lista de pedidos 
(con posibilidad de filtrarlos) y salir de la aplicación.
 */