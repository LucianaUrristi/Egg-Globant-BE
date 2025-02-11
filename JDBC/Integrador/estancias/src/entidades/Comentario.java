package entidades;

public class Comentario {
    private int id_comentario;
    private Casa casa; // Relación con Casa
    private String comentario;

    
    public Comentario(int id_comentario, Casa casa, String comentario) {
        this.id_comentario = id_comentario;
        this.casa = casa;
        this.comentario = comentario;
    }

    public Comentario() {
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

