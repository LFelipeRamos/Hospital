<!-- Instruções para agentes Copilot/AI que trabalham neste repositório -->

# Copilot instructions — Projeto "Hospital" (Java / NetBeans)

Objetivo rápido

- Ajude a manter e estender um pequeno app Java (Swing + console) criado com NetBeans. O código usa pacote default (sem `package`) e armazena tudo em memória via a classe `Hospital`.

Comandos úteis (Windows / PowerShell)

- Compilar: `mvn -q -DskipTests compile`
- Empacotar: `mvn -q -DskipTests package`
- Executar (classe `Principal` no classpath compilado):
  - `java -cp target/classes Principal`
  - Se precisar usar o plugin maven-exec: `mvn -DskipTests compile org.codehaus.mojo:exec-maven-plugin:3.1.0:java -Dexec.mainClass="Principal"`
- Observação: NetBeans normalmente roda diretamente pela IDE; usar a linha de comando só quando necessário.

Estrutura e arquivos chave

- `Principal.java` — UI de console; mostra como o app cria `Paciente`, `Medico`, `Doador` e `Consulta` e usa `Hospital` para armazenar/listar.
- `FormPrincipal.java` (+ `.form`) — formulário Swing gerado pelo NetBeans; contém `initComponents()` gerado automaticamente.
- `Hospital.java` — gerencia coleções em memória e fornece métodos como `adicionarPaciente`, `listarPacientes`, `buscarPacientePorCpf`, `buscarMedicoPorCrm`, `adicionarConsulta`.
- Modelos: `Paciente.java`, `Medico.java`, `Doador.java`, `Consulta.java`, `Pessoa.java` — seguir getters/setters já existentes.
- Utilitários/validação: `Leitura.java` (entrada), `IdadeInvalidaException.java`, `CrmInvalidoException.java` — observe tratamento de exceções em `Principal`.

Padrões e convenções específicas deste projeto

- Código usa idioma Português para identificadores e mensagens; mantenha isso em novas mensagens e labels.
- Não adicione declarações de `package` nas classes existentes — o projeto usa o pacote default. Alterar isso exige mover/refatorar todas as classes e atualizar execuções maven/IDE.
- Forms do NetBeans: não modifique manualmente as seções geradas (ex.: `initComponents()`), pois o NetBeans reescreverá os arquivos `.java`/`.form`.
- Validação: use/exponha as mesmas exceções específicas (`IdadeInvalidaException`, `CrmInvalidoException`) para manter consistência com `Principal`.
- Entrada/saída: CLI utiliza `Leitura.entrada(...)` e `Leitura.entradaInt(...)`; reutilize isso para manter experiência consistente.

Como estender funcionalidades (boas práticas locais)

- Para adicionar relatórios ou novas listas, preferir implementar métodos em `Hospital.java` (por exemplo `listarConsultasPorMedico`) e chamá-los a partir de `Principal` ou dos `ActionListeners` do `FormPrincipal`.
- Para persistência futura, mantenha separação entre: (a) modelos (`Paciente`, `Medico`, ...), (b) lógica de coleção (`Hospital`) e (c) interface (`Principal`/`Form*`). Isso torna a substituição da camada de armazenamento mais simples.

Pontos de atenção ao editar código

- Evite editar manualmente trechos marcados como gerados pelo NetBeans (comentários `// <editor-fold ...>`). Use a IDE para modificar formulários.
- `Principal` usa `continue` dentro de blocos `case` ao capturar exceções — preserve esse fluxo se copiar/colar código.
- Interfaces gráficas e console coexistem; novas features devem suportar ambos quando fizer sentido.

Integrações externas e CI

- Atualmente não há integração externa (BD, serviços REST, etc.) — tudo é em memória.
- Não há testes automáticos no repositório (`src/test` ausente). Se adicionar testes, siga padrão Maven (`mvn test`) e adicione dependências ao `pom.xml`.

Exemplos rápidos (buscar/usar)

- Procurar implementações existentes para seguir o padrão: `buscarPacientePorCpf` em `Hospital.java` e chamadas em `Principal.java`.
- Validar CRM: veja tratamento em `Principal` onde `medico.setCrm(Leitura.entradaInt(...))` é envolvido por `try/catch CrmInvalidoException`.

Quando pedir revisão ao humano

- Peça revisão se você:
  - Alterar o pacote padrão (impacto amplo).
  - Modificar código gerado pelo NetBeans em `Form*.java`.
  - Introduzir persistência (arquivo/DB) — discuta a estratégia de migração.

Feedback

- Se algo ficou ambíguo ou faltar referência a algum arquivo, solicite que o mantenedor aponte o arquivo ou workflow que prefere.

Fim.

**Instruções do Mantenedor — Requisitos da Entrega Final (versão do aluno)**

Resumo rápido

- A seguir estão os requisitos formais da entrega final da disciplina (projeto com interface gráfica). Esses itens vêm do enunciado do trabalho e devem ser respeitados ao desenvolver/avaliar o repositório.

Requisitos obrigatórios (ações concretas)

- Comentários iniciais em todas as classes: adicione no topo de cada arquivo Java um comentário com seu nome. Exemplo (linha 1/2 do arquivo):

  - `// NetBeans IDE 27` <- 1ª linha **em `FormPrincipal.java` somente** (versão usada)
  - `// Seu Nome - RA: xxxxx` <- 2ª linha em `FormPrincipal.java` e comentário similar no topo de todas as classes

- `FormPrincipal.java`:

  - Na primeira linha do corpo da classe (logo após o cabeçalho de comentários) inclua a versão do NetBeans usada.
  - Na segunda linha inclua seu nome conforme o enunciado.

- Pacote default: **NÃO CRIAR pacotes**. Todas as classes devem permanecer no pacote default (sem `package ...`). Mudar isso acarreta refatoração ampla e não é permitido para a entrega.

- Bibliotecas: use apenas bibliotecas nativas do NetBeans/JDK. Não adicionar dependências externas no `pom.xml`.

- Formulários: todos os JFrame devem começar com o prefixo `Form` (ex.: `FormPaciente`, `FormRelatorio`). Não editar manualmente blocos gerados pelo NetBeans (`initComponents()`) — use a IDE quando for alterar o formulário.

- Remoção de classes: REMOVA classes que não são necessárias para a versão com interface gráfica. Mantenha somente as classes que o sistema usa efetivamente (modelos, `Hospital`/BD, forms e utilitários como `Leitura`).

Collections e nomeclatura de BD

- As collections que armazenam os dados devem estar em uma(s) classe(s) separada(s) cujo(s) nome(s) iniciem com `BD` (ex.: `BDHospital`, `BDRegistro`).
- Essas classes `BD*` devem usar `List/ArrayList` como armazenamento interno e expor os 4 métodos básicos (CRUD). Exemplos de assinaturas recomendadas:
  - `public void inserirPaciente(Paciente p)`
  - `public Paciente buscarPacientePorCpf(String cpf)`
  - `public void atualizarPaciente(Paciente p)`
  - `public boolean removerPaciente(String cpf)`

Padrão Singleton (obrigatório)

- Aplique o padrão Singleton nas classes `BD*` e também nos `JFrame` (cada formulário deve ter um getter `getInstance()` que retorne a instância única). Logo acima do método Singleton inclua o comentário exato:
  - `//MÉTODO SINGLETON`

Exemplo breve (BD):

```java
public class BDHospital {
    //MÉTODO SINGLETON
    private static BDHospital instancia;
    private List<Paciente> pacientes = new ArrayList<>();
    private BDHospital() {}
    public static BDHospital getInstance() {
        if (instancia == null) instancia = new BDHospital();
        return instancia;
    }
    // CRUD: inserir/consultar/atualizar/remover
}
```

Exemplo breve (Form JFrame):

```java
public class FormPaciente extends javax.swing.JFrame {
    //MÉTODO SINGLETON
    private static FormPaciente instancia;
    private FormPaciente() { initComponents(); }
    public static FormPaciente getInstance() {
        if (instancia == null) instancia = new FormPaciente();
        return instancia;
    }
}
```

Relatórios e UI

- Deve existir um `FormPrincipal` como ponto de entrada com `JMenuBar` e opções para abrir os formulários.
- Relatórios individuais: janelas que apresentam os dados de uma única entidade.
- Relatórios em grupo: pelo menos uma tabela (`JTable`) mostrando múltiplos registros (pode também usar `JList`/`JComboBox` após isso).

Verificações rápidas antes da submissão

- Todas as classes possuem comentário com nome do autor no topo.
- `FormPrincipal.java` contém a 1ª linha com a versão do NetBeans e a 2ª linha com o nome do autor.
- Não existem `package` nas classes.
- Há pelo menos uma classe `BD*` com `ArrayList` e métodos CRUD.
- `//MÉTODO SINGLETON` está presente acima dos métodos `getInstance()` em `BD*` e `Form*`.

Checklist para o avaliador (para facilitar revisão automática/manual)

- `grep -R "//MÉTODO SINGLETON" .` deve retornar entradas em `BD*.java` e `Form*.java`.
- `grep -R "NetBeans" FormPrincipal.java` deve retornar a linha com a versão.
- `ls src/main/java | grep -E "^Form"` deve listar os formulários.

Observação final

- Essas instruções são reproduções do enunciado de entrega final do curso. Se quiser, eu posso:
  - Inserir automaticamente os comentários de cabeçalho em todas as classes (substituindo o autor por um placeholder),
  - Gerar um `BDHospital` esqueleto com os métodos CRUD usando `ArrayList` e o singleton,
  - Gerar `getInstance()` para formulários existentes (como `FormPrincipal`) — mas isso altera fontes, confirme se devo prosseguir.
