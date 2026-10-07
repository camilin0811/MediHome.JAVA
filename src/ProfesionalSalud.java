import java.time.LocalDateTime;

public class ProfesionalSalud extends Usuario implements Notificable {

    private String numeroRegistroProfesional;
    private String especialidad;

    public ProfesionalSalud() {
        super();
    }

    public String getNumeroRegistroProfesional() {
        return numeroRegistroProfesional;
    }

    public void setNumeroRegistroProfesional(String numeroRegistroProfesional) {
        this.numeroRegistroProfesional = numeroRegistroProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificacion para el profesional " + getNombre() + ": " + mensaje);
    }

    public boolean estaDisponible(LocalDateTime fecha) {
        if (fecha == null) {
            return false;
        }
        return !fecha.isBefore(LocalDateTime.now());
    }
}
