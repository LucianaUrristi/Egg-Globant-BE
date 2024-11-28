package GestionDeCuentas.entidades;
import GestionDeCuentas.excepciones.*;

public class CuentaBancaria {
    private double saldoInicial;

    // Constructor
    public CuentaBancaria(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    // El constructor por defecto, inicializo el saldo en 0 si no se recibe valor a
    // la apertura.
    public CuentaBancaria() {
        this.saldoInicial = 0;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    // Método para realizar retiros
    public void retirar(double cantidad) throws
        SaldoInsuficienteException {
        
        // Verificar si el saldo es suficiente para el retiro
        if (cantidad > saldoInicial) {
        // Lanzar una excepción personalizada si el saldo es insuficiente
        
        throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro");
        
        } else {
        // Actualizar el saldo
        saldoInicial -= cantidad;
        System.out.println("Retiro exitoso. Saldo restante: " +
        
        saldoInicial);
        }
        }
}
