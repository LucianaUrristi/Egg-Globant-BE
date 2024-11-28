package GestionDeCuentas.excepciones;

// Clase de Excepción Personalizada
public class SaldoInsuficienteException extends Exception {
    // Constructor que acepta un mensaje personalizado
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
