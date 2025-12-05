/*
* Luiz Felipe Fernanddes Ramos - RA: 2767112
* Classe Medico que herda de Pessoa
*/
public class Medico extends Pessoa  implements Listavel{
    private int crm;
    private String especialidade;

    // Construtor padrão
    public Medico() {
        super();
        this.crm = 0;
        this.especialidade = "";
    }

    // Construtor com Sobrecarga
    //Sobrecarga
    public Medico(String nome, int idade, String cpf, Character sexo, String email, int crm, String especialidade) {
        super(nome, idade, cpf, sexo, email);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    // Getters e Setters
    public int getCrm() {
        return crm;
    }
    public void setCrm(int crm) throws CrmInvalidoException {
    if (crm <= 0) {
        throw new CrmInvalidoException("CRM inválido! Deve ser um número positivo.");
    }
    this.crm = crm;
}
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }



   
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

    //sobreescrita para interface funcionar 

   
   @Override
    public String listar() {
        return "Médico: " + getNome() + " | CPF: " + getCpf() + " | CRM: " + getCrm() + " | Especialidade: " + getEspecialidade();
    }

}