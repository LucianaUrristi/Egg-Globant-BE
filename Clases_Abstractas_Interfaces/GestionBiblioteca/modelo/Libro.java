package GestionBiblioteca.modelo;
import GestionBiblioteca.interfaces.Catalogable;

public class Libro extends ItemBiblioteca implements Catalogable {
    //Atributos
    private String titulo;
    private String autor;
    private int numLibros;
    private long isbn;
    //Constructor
    public Libro(String titulo, String autor, int numLibros, long isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.numLibros = numLibros;
        this.isbn = isbn;
    }

    //Getters y Setters
    public String getAutor() {
        return autor;
    }

    public int getnumLibros() {
        return numLibros;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setnumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Métodos
    @Override
    public String obtenerInformacion() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numLibros=" + numLibros +
                ", isbn=" + isbn +
                '}';
    }

    @Override
    public void prestar() {
        this.numLibros--;
        System.out.println("El libro " + titulo + " ha sido prestado");
    }

    @Override
    public void devolver() {
        this.numLibros++;
        System.out.println("El libro " + titulo + " ha sido devuelto");
    }

    @Override
    public double calcularMultas() {
        return 0.0;
    }
}