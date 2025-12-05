/*
*Luiz Felipe Fernandes Ramos - Ra 2767112
* Pelo que entendi não poderia colocar essas exeption direto na classe leitura, então a forma que pensei * foi criar arquivo separado de classe pra cada uma. 
*/

// Exceção agora unchecked pq do outro jeito n tava indo 
public class IdadeInvalidaException extends Exception {
    public IdadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}