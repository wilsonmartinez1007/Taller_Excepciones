public class Platos{
    String nombre;
    String descripcion;
    Tipo_plato tipo;
    int costo;
    byte tiempo_preparacion;

    public Platos(String nombre, String descripcion, Tipo_plato tipo, int costo, byte tiempo_preparacion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.costo = costo;
        this.tiempo_preparacion = tiempo_preparacion;
    }
    public String getNombre() {
        return "Nombre: " + nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return "Descripcion: " + descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Tipo_plato getTipo() {
        return tipo;
    }
    public void setTipo(Tipo_plato tipo) {
        this.tipo = tipo;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public byte getTiempo_preparacion() {
        return tiempo_preparacion;
    }
    public void setTiempo_preparacion(byte tiempo_preparacion) {
        this.tiempo_preparacion = tiempo_preparacion;
    }
}