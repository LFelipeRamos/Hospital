/*
 * Luiz Felipe Fernanddes Ramos - RA: 2767112
 * Classe Hospital que gerencia Pacientes, Médicos e Doadores
 */

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;


// Classe Hospital
public class Hospital  {
    private final List<Paciente> pacientes = new ArrayList<>();
    private final List<Medico> medicos = new ArrayList<>();
    private final List<Doador> doadores = new ArrayList<>();
    private final List<Consulta> consultas = new ArrayList<>();

    public void adicionarPaciente(Paciente p) { pacientes.add(p); }
    public void adicionarMedico(Medico m) { medicos.add(m); }
    public void adicionarDoador(Doador d) { doadores.add(d); }
    public void adicionarConsulta(Consulta c) { consultas.add(c); }

    // Métodos que chamam o listar() de cada objeto
    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente p : pacientes) {
                System.out.println(p.listar());
            }
        }
    }

    public void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            for (Medico m : medicos) {
                System.out.println(m.listar());
            }
        }
    }

    public void listarDoadores() {
        if (doadores.isEmpty()) {
            System.out.println("Nenhum doador cadastrado.");
        } else {
            for (Doador d : doadores) {
                System.out.println(d.listar());
            }
        }
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada.");
        } else {
            for (Consulta c : consultas) {
                System.out.println(c.listar());
            }
        }
    }

    // Métodos de busca por CPF
    public Paciente buscarPacientePorCpf(String cpf) {
        // Tenta busca direta
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        // Se não encontrou, tenta por reflexão (requisito de Reflexividade)
        Object found = buscarPorCampo(pacientes, "cpf", cpf);
        if (found instanceof Paciente p) {
            return p; //Reflexividade
        }
        return null; // Retorna null se não encontrar
    }

    public Medico buscarMedicoPorCrm(int crm) {
        for (Medico m : medicos) {
            if (m.getCrm() == crm) {
                return m;
            }
        }
        return null; 
    }

    // Método genérico que busca por campo via reflexão
    public static <T> T buscarPorCampo(List<T> lista, String campo, Object valor) {
        for (T obj : lista) {
            try {
                Field f = obj.getClass().getDeclaredField(campo); //Reflexividade
                f.setAccessible(true);
                Object v = f.get(obj);
                if (v != null && v.equals(valor)) {
                    return obj;
                }
            } catch (NoSuchFieldException e) {
                // ignora e continua
            } catch (IllegalAccessException e) {
                // ignora e continua
            }
        }
        return null;
    }
}