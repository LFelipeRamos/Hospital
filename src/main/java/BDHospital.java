// Luiz Felipe Feranandes Ramos - RA: 2767112

import java.util.ArrayList;
import java.util.List;

public class BDHospital {
    //MÉTODO SINGLETON
    private static BDHospital instancia;

    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Doador> doadores = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();

    private BDHospital() {}

    public static BDHospital getInstance() {
        if (instancia == null) instancia = new BDHospital();
        return instancia;
    }

    // Paciente CRUD
    public void inserirPaciente(Paciente p) { pacientes.add(p); }
    // compatibilidade com API antiga (Hospital)
    public void adicionarPaciente(Paciente p) { inserirPaciente(p); }
    public Paciente buscarPacientePorCpf(String cpf) {
        for (Paciente p : pacientes) if (p.getCpf() != null && p.getCpf().equals(cpf)) return p;
        return null;
    }
    public void atualizarPaciente(Paciente p) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCpf() != null && pacientes.get(i).getCpf().equals(p.getCpf())) {
                pacientes.set(i, p);
                return;
            }
        }
    }
    public boolean removerPaciente(String cpf) {
        return pacientes.removeIf(p -> p.getCpf() != null && p.getCpf().equals(cpf));
    }
    public List<Paciente> listarPacientes() { return new ArrayList<>(pacientes); }

    // Medico CRUD
    public void inserirMedico(Medico m) { medicos.add(m); }
    // compatibilidade com API antiga (Hospital)
    public void adicionarMedico(Medico m) { inserirMedico(m); }
    public Medico buscarMedicoPorCrm(int crm) {
        for (Medico m : medicos) if (m.getCrm() == crm) return m;
        return null;
    }
    public void atualizarMedico(Medico m) {
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getCrm() == m.getCrm()) { medicos.set(i, m); return; }
        }
    }
    public boolean removerMedico(int crm) { return medicos.removeIf(m -> m.getCrm() == crm); }
    public List<Medico> listarMedicos() { return new ArrayList<>(medicos); }

    // Doador CRUD
    public void inserirDoador(Doador d) { doadores.add(d); }
    // compatibilidade com API antiga (Hospital)
    public void adicionarDoador(Doador d) { inserirDoador(d); }
    public Doador buscarDoadorPorCpf(String cpf) {
        for (Doador d : doadores) if (d.getCpf() != null && d.getCpf().equals(cpf)) return d;
        return null;
    }
    public void atualizarDoador(Doador d) {
        for (int i = 0; i < doadores.size(); i++) {
            if (doadores.get(i).getCpf() != null && doadores.get(i).getCpf().equals(d.getCpf())) { doadores.set(i, d); return; }
        }
    }
    public boolean removerDoador(String cpf) { return doadores.removeIf(d -> d.getCpf() != null && d.getCpf().equals(cpf)); }
    public List<Doador> listarDoadores() { return new ArrayList<>(doadores); }

    // Consulta CRUD
    public void inserirConsulta(Consulta c) { consultas.add(c); }
    // compatibilidade com API antiga (Hospital)
    public void adicionarConsulta(Consulta c) { inserirConsulta(c); }
    public List<Consulta> listarConsultas() { return new ArrayList<>(consultas); }
}
