/* 
 * Luiz Felipe Fernanddes Ramos - RA: 2767112
 */
public class Principal {

    public static void main(String[] args) {
        int opcao; // Variável para armazenar a opção do menu escolhida pelo usuário
        String limitador = "S";
        Hospital hospital = new Hospital(); // Instancia o Hospital para gerenciar os dados dos pacientes, médicos e doadores
        do { 
            
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Cadastrar Doador");
            System.out.println("4. Cadastrar Consulta");
            System.out.println("5. Listar Pacientes");
            System.out.println("6. Listar Médicos");
            System.out.println("7. Listar Doadores");
            System.out.println("8. Listar Consultas");
            System.out.println("9. Sair");
            System.out.println("===========================");
            
            opcao = Leitura.entradaInt("Escolha uma opção: ");
            
            switch (opcao){
                    case 1 -> {
                    System.out.println("Cadastrar Paciente"); 
                    Paciente paciente = new Paciente(); // Cria um novo objeto Paciente da classe Paciente
                    paciente.setNome(Leitura.entrada("Nome: ")); // aponta para o método de entrada da classe Leitura através do objeto paciente
                   try {
                            paciente.setIdade(Leitura.entradaInt("Idade: "));
                        } catch (IdadeInvalidaException e) {//exceção para idade inválida
                            System.out.println("Erro: " + e.getMessage());
                            continue;
                        }
                    paciente.setCpf(Leitura.entrada("CPF (Str): (000.000.000-00)"));
                    paciente.setSexo(Leitura.entrada("Sexo (M/F): ").charAt(0));
                    paciente.setEmail(Leitura.entrada("Email: "));
                    paciente.setTipoSanguineo(Leitura.entrada("Tipo sanguineo"));
                    paciente.setDoenca(Leitura.entrada("Tem algum tipo de Doença ou enfermidade crônica? S/N "));

                    hospital.adicionarPaciente(paciente);
                    System.out.println("Paciente cadastrado com sucesso!");
                    
                    limitador = Leitura.entrada("\n\nDeseja continuar S/N ?").toUpperCase();
                    }
                    case 2 -> {
                        System.out.println("Cadastrar Médico");
                        Medico medico = new Medico();
                        medico.setNome(Leitura.entrada("Nome: ")); 
                        try {
                            medico.setIdade(Leitura.entradaInt("Idade: "));
                        } catch (IdadeInvalidaException e) {
                            System.out.println("Erro: " + e.getMessage());
                            continue;
                        }
                        medico.setCpf(Leitura.entrada("CPF: STR (000.000.000-00)"));
                        medico.setSexo(Leitura.entrada("Sexo (M/F): ").charAt(0));
                        medico.setEmail(Leitura.entrada("Email: "));
                       try {
                                medico.setCrm(Leitura.entradaInt("CRM: INT (0000000..) "));
                            } catch (CrmInvalidoException e) {
                                System.out.println("Erro: " + e.getMessage());
                                continue;
                            }

                        medico.setEspecialidade(Leitura.entrada("Especialidade: "));
                        limitador = Leitura.entrada("\n\nDeseja continuar S/N ?").toUpperCase();
                        hospital.adicionarMedico(medico);


                    }
                    case 3 -> {
                        System.out.println("Cadastrar Doador"); 
                        Doador doador = new Doador();
                        doador.setNome(Leitura.entrada("Nome: "));
                       try {
                            doador.setIdade(Leitura.entradaInt("Idade: "));
                        } catch (IdadeInvalidaException e) {
                            System.out.println("Erro: " + e.getMessage());
                            continue;
                        }
                        doador.setCpf(Leitura.entrada("CPF STR:  (000.000.000-00)"));
                        doador.setSexo(Leitura.entrada("Sexo (M/F): ").charAt(0));
                        doador.setEmail(Leitura.entrada("Email: "));
                        doador.setOrgao(Leitura.entrada("Qual orgão deseja doar?: "));
                        doador.setDataCadastro(Leitura.entrada(" Insira a data de cadastro: DD/MM/AAAA"));
                        hospital.adicionarDoador(doador);
                        System.out.println("Doador cadastrado com sucesso!");
                        limitador = Leitura.entrada("\n\nDeseja continuar S/N ?").toUpperCase();
                    }
                    case 4 -> {
                        System.out.println("Cadastrar Consulta");
                        int crmMedico = Leitura.entradaInt("Insira o CRM do Médico: ");
                        Medico medicoConsulta = hospital.buscarMedicoPorCrm(crmMedico);
                        if (medicoConsulta == null) {
                            System.out.println("Médico não encontrado com CRM: " + crmMedico);
                            break;
                        }
                        String cpfPaciente = Leitura.entrada("Insira o CPF do Paciente: ");
                        Paciente pacienteConsulta = hospital.buscarPacientePorCpf(cpfPaciente);
                        if (pacienteConsulta == null) {
                            System.out.println("Paciente não encontrado com CPF: " + cpfPaciente);
                            break;
                        }
                        String dataConsulta = Leitura.entrada("Data da Consulta (DD/MM/AAAA): ");
                        String horaConsulta = Leitura.entrada("Hora da Consulta (HH:MM): ");
                        Consulta consulta = new Consulta();
                        consulta.setMedico(medicoConsulta);
                        consulta.setPaciente(pacienteConsulta);
                        consulta.setData(dataConsulta);
                        consulta.setHora(horaConsulta);
                        hospital.adicionarConsulta(consulta);
                        System.out.println("Consulta cadastrada com sucesso!");
                        limitador = Leitura.entrada("\n\nDeseja continuar S/N ?").toUpperCase();
                    }
                    case 5 -> {
                        System.out.println("Listar Pacientes");
                        hospital.listarPacientes();
                        limitador = Leitura.entrada("\n\nDeseja continuar S/N ?").toUpperCase();
                        
                    }
                    case 6 -> {
                        System.out.println("Listar Médicos");
                        hospital.listarMedicos();
                        limitador = Leitura.entrada("\n\nDeseja continuar S/N ?").toUpperCase();
                    }
                    case 7 ->{
                        System.out.println("Listar Doadores");
                        hospital.listarDoadores();
                        limitador = Leitura.entrada("\n\nDeseja continuar S/N ?").toUpperCase();
                    }
                    case 8 -> {
                        System.out.println("Listar Consultas");
                        hospital.listarConsultas();
                        limitador = Leitura.entrada("\n\nDeseja continuar S/N ?").toUpperCase();
                    }
                }

            }while (opcao != 9 && "S".equals(limitador));
        }
    }
