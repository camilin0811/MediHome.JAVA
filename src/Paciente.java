public class Paciente extends Usuario implements Notificable {

    private String telefono;
    private String direccion;

    public Paciente() {
        super();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificacion para el paciente " + getNombre() + ": " + mensaje);
    }
}
