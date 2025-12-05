/*
 * Luiz Felipe Feranandes Ramos - RA: 2767112
 * Classe Consulta que é a associação entre Médico e Paciente
 */

// Classe Consulta
public class Consulta implements Listavel {
    private Medico medico;
    private Paciente paciente;
    private String data; // Formato: "dd/mm/yyyy"
    private String hora; // Formato: "hh:mm"

    // Construtor padrão
    public Consulta() {
        this.medico = null;
        this.paciente = null;
        this.data = "";
        this.hora = "";
    }

   

    //Sobrecarga

    public Consulta(Medico medico, Paciente paciente, String data, String hora) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
    }

    // Getters
    public Medico getMedico() {
        return medico;
    }   
    public Paciente getPaciente() {
        return paciente;
    }
    public String getData() {
        return data;
    }
    public String getHora() {
        return hora;
    }

    // Setters
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    //sobreescreve o método listar() da interface Listavel
    //Sobrescrita
    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Consulta:\n");
        sb.append("Médico: ").append(medico.getNome()).append(" | CRM: ").append(medico.getCrm()).append("\n");
        sb.append("Paciente: ").append(paciente.getNome()).append(" | CPF: ").append(paciente.getCpf()).append("\n");
        sb.append("Data: ").append(data).append(" | Hora: ").append(hora).append("\n");
        sb.append("---------------------------");
        return sb.toString();
    }
}
   