/*
 * Luiz Felipe Fernanddes Ramos - RA: 2767112
 * Classe Pessoa base para Paciente, Medico e Doador
 */

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private Character sexo;
    private String email;

    // Construtor padrão
    public Pessoa() {
    
        this.nome = "";
        this.idade = 0;
        this.cpf = "";
        this.sexo = ' ';
        this.email = "";
    }

    // Construtor com parâmetros
    public Pessoa(String nome, int idade, String cpf, Character sexo, String email) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) throws IdadeInvalidaException {
        if (idade < 0 || idade > 120) {
        throw new IdadeInvalidaException("Idade inválida! Digite um valor entre 0 e 120.");
        }
        this.idade = idade;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Character getSexo() {
        return sexo;
    }
    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
