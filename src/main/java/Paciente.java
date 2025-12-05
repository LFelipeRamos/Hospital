/*
 * Luiz Felipe Fernanddes Ramos - RA: 2767112
 * Classe Paciente que herda de Pessoa
 */
public class Paciente extends Pessoa implements Listavel{
    private String tipoSanguineo;
    private String doenca;
   
    // Construtor padrão
    public Paciente() {
        super();
        this.tipoSanguineo = "";
        this.doenca = "";
    }
    // Construtor com Sobrecarga
    //Sobrecarga
    public Paciente(String nome, int idade, String cpf, Character sexo, String email, String tipoSanguineo, String doenca) {
        super(nome, idade, cpf, sexo, email);
        this.tipoSanguineo = tipoSanguineo;
        this.doenca = doenca;
    }

    // Getters e Setters
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    public String getDoenca() {
        return doenca;
    }
    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    //sobreescrita (só coloquei pq é um requisito mas ta funcionando bonitinho sem skk)
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
    
    //Sobreescrita para funcionar a interface pq sem ela n funciona pra nada 

    //Sobrescrita
    @Override
    public String listar() {
        return getNome() + " | " + getCpf() + " | " + getTipoSanguineo() + " | " + getDoenca();
    }
    

}
