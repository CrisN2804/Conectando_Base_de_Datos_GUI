package Models;

public class DatosUsuario {
    private int id;
    private String nombre;
    private String registro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    DatosUsuario(){
        setId(0);
        setNombre("John Doe");
        setRegistro("00000000");
    }

    public DatosUsuario(int id, String nombre, String registro){
        setId(id);
        setNombre(nombre);
        setRegistro(registro);
    }
}
