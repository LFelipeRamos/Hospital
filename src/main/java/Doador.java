/*
 * Luiz Felipe Feranandes Ramos - RA: 2767112
 * Classe Doador que herda de Paciente
 */
public class Doador extends Pessoa  implements Listavel{
    private String orgao;
    private String dataCadastro;

    // Construtor padrão
    public Doador() {
        super();
        this.orgao = "";
        this.dataCadastro = "";
    }
    // Construtor com Sobrecarga
    //Sobrecarga
    public Doador(String nome, int idade, String cpf, Character sexo, String email, String orgao, String dataCadastro) {
        super(nome, idade, cpf, sexo, email);
        this.orgao = orgao;
        this.dataCadastro = dataCadastro;
    }

    // Getters e Setters
    public String getOrgao() {
        return orgao;
    }
    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }
    public String getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    //sobreescrita
    //Sobrescrita
    @Override
    public void setNome(String nome){
        super.setNome(nome);
    }

    //Sobrescrita
    @Override
    public void setIdade(int idade) throws IdadeInvalidaException {
        if (idade < 0 || idade > 120) {
            throw new IdadeInvalidaException("Idade inválida!");
        }
        super.setIdade(idade);
    }
    @Override
    public void setEmail(String email){
        super.setEmail(email);
    }
    @Override
    public void setCpf(String cpf){
        super.setCpf(cpf);
    }
    @Override
    public void setSexo(Character sexo){
        super.setSexo(sexo);
    }

    // Sobreescrita para funcionar a interface
    //Sobrescrita
    @Override
    public String listar() {
        return "Doador: " + getNome() + " | CPF: " + getCpf() + " | Órgão: " + getOrgao() + " | Data Cadastro: " + getDataCadastro();
    }
} 