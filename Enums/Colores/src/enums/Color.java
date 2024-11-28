package enums;
public enum Color {
    ROJO("#FF0000"),
    AMARILLO("#FFFF00"),
    AZUL("#0000FF");

    private final String valorHexadecimal;

    // Constructor
    Color(String valorHexadecimal) {
        this.valorHexadecimal = valorHexadecimal;
    }

    // Getter para el valor hexadecimal
    public String getValorHexadecimal() {
        return valorHexadecimal;
    }
}
