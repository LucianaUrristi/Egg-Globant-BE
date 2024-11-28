package POOAvanzado_Libros.entidades;

public class Libro {
    public String titulo;
    public String autor;
    public int numeroDePaginas;
    private boolean prestado;

    public Libro(String titulo, String autor, int numeroDePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
        this.prestado = false;
    }

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
    public boolean isPrestado() {
        return prestado;
    }

    public void prestarLibro() {
        this.prestado = true;
    }

    public void devolverLibro() {
        this.prestado = false;
    }

    // Método para imprimir los detalles del libro
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de páginas: " + numeroDePaginas);
        System.out.println("--------------------------------");
    }
}
