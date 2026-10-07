import java.time.LocalDateTime;

public class ServicioDomiciliario {

    private String codigo;
    private LocalDateTime fechaProgramada;
    private String direccionAtencion;
    private String motivo;
    private String estado;

    private Paciente paciente;
    private ProfesionalSalud profesionalSalud;
    private AtencionMedica atencionMedica;

    public ServicioDomiciliario() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(LocalDateTime fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getDireccionAtencion() {
        return direccionAtencion;
    }

    public void setDireccionAtencion(String direccionAtencion) {
        this.direccionAtencion = direccionAtencion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProfesionalSalud getProfesionalSalud() {
        return profesionalSalud;
    }

    public AtencionMedica getAtencionMedica() {
        return atencionMedica;
    }

    public void programar(LocalDateTime fecha) {
        this.fechaProgramada = fecha;
        this.estado = "PROGRAMADO";
        if (paciente != null) {
            paciente.notificar("Su servicio " + codigo + " quedo programado para " + fecha);
        }
    }

    public void asignarProfesional(ProfesionalSalud profesional) {
        if (profesional == null || !profesional.estaDisponible(fechaProgramada)) {
            return;
        }
        this.profesionalSalud = profesional;
        profesional.notificar("Se le asigno el servicio " + codigo + " para " + fechaProgramada);
    }

    public void iniciarAtencion() {
        if (profesionalSalud == null || "CANCELADO".equals(estado)) {
            return;
        }
        this.atencionMedica = new AtencionMedica();
        this.atencionMedica.setFechaHoraInicio(LocalDateTime.now());
        this.estado = "EN_CURSO";
    }

    public void finalizar() {
        if (atencionMedica == null) {
            return;
        }
        this.atencionMedica.setFechaHoraFin(LocalDateTime.now());
        this.estado = "FINALIZADO";
    }

    public void cancelar() {
        this.estado = "CANCELADO";
        if (paciente != null) {
            paciente.notificar("Su servicio " + codigo + " fue cancelado");
        }
        if (profesionalSalud != null) {
            profesionalSalud.notificar("El servicio " + codigo + " fue cancelado");
        }
    }
}
