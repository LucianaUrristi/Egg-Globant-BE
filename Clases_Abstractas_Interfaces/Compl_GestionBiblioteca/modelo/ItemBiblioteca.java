package  Compl_GestionBiblioteca.modelo;

import java.time.LocalDate;

public abstract class ItemBiblioteca {
    public abstract void prestar();

    public abstract void devolver();

    public abstract double calcularMultas(LocalDate fechaRealDevolucion);
}
