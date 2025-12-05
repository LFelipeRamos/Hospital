/*
*Luiz Felipe Fernandes Ramos - Ra 2767112
* Pelo que entendi não poderia colocar essas exeption direto na classe leitura, então a forma que pensei * foi criar arquivo separado de classe pra cada uma. 
*/

public class CrmInvalidoException extends Exception {
    public CrmInvalidoException(String mensagem) {
        super(mensagem);
    }
}