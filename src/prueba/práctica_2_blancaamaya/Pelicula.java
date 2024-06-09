package prueba.práctica_2_blancaamaya;

public class Pelicula {

    private String Titulo;
    private String Director;
    private int ID;
    private boolean estado;
    private String propietario;

    public Pelicula(String Titulo, String Director, int ID) {
        this.Titulo = Titulo;
        this.Director = Director;
        this.ID = ID;
        this.estado = false;
        this.propietario = "";
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void prestar(String propietario) {
        if (!estado) {
            this.estado = true;
            this.propietario = propietario;
            System.out.println("Pelicula prestada a: " + propietario);
        } else {
            System.out.println("No disponible, ya esta prestada");
        }
    }

    public void regresar() {
        if (estado) {
            this.estado = false;
            this.propietario = "";
            System.out.println("Regresada");
        } else {
            System.out.println("Disponible");
        }
    }

    @Override
    public String toString() {
        if (estado == true) {
            return "ID: " + ID + ", Título: " + Titulo + ", Director: " + Director + ", Estado: Prestada a " + propietario;
        } else {
            return "ID: " + ID + ", Título: " + Titulo + ", Director: " + Director + ", Estado: Disponible";
        }
    }
}