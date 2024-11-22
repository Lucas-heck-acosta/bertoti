## Aula 1

We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.

- O que é Engenharia de Software?

A engenharia de software é similar às outras engenharias na aplicação de uma abordagem sistemática para resolver problemas complexos, envolvendo fases de planejamento, design, implementação, teste e manutenção. Assim como nas demais engenharias, a modelagem, o teste rigoroso e o gerenciamento de projetos são cruciais para garantir a qualidade do produto final. No entanto, a engenharia de software se distingue por sua ênfase em tempo, escala e decisões complexas. Os engenheiros de software precisam considerar a necessidade de futuras mudanças, a escalabilidade do software e a eficiência da organização, tomando decisões de alto impacto com base em estimativas muitas vezes imprecisas.


## Aula 2

- Portabilidade
    -Fazer um software portátil o torna mais difícil de otimizar, ao passo que otimizar um software para um dispositivo específico pode sacrificar sua portabilidade.

- Ecalabilidade
    -Projetar um sistema escalável o torna muito mais complexo, enquanto projetos simples tem uma capacidade limitada.

- Manutenção
    -Manter um código de fácil e eficiente manutenção pode custar muito tempo e acabar atrasando o projeto, enquanto um código entregue antes do prazo pode apresentar dificuldades de manutenção.



## Aula 3

- Classe Carro
```java

// Declarando a classe, um substantivo
public class Carro {

  // Declarando seus atributos
  private String modelo;
  private String placa;
  private int ano;

  // Construtor, o código que acontece na criação do objeto, podendo ser passado argumentos para utilizar na lógica
  public Carro(String modelo, String placa, int ano) {
    // this para acessar o atributo da classe
    this.modelo = modelo;
    this.placa = placa;
    this.ano = ano;
  }

  // Métodos são como as funções que podem ser chamadas de cada classe, como uma maneira de solicitar um retorno ou efetuar uma operação
  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  // Método para exibir informações do carro
  public void exibirInformacoes() {
    System.out.println("Modelo: " + modelo);
    System.out.println("Placa: " + placa);
    System.out.println("Ano: " + ano);
  }

}



```

- Classe Garagem
```java
import java.util.ArrayList;

// Declarando a classe Garagem
public class Garagem {

  // Declarando o atributo para armazenar a lista de carros
  private ArrayList<Carro> carros;

  public Garagem() {
    carros = new ArrayList<>();
  }

  // Método para adicionar um carro a garagem
  public void adicionarCarro(Carro carro) {
    carros.add(carro);
  }

  // Método para remover um carro da garagem
  public void removerCarro(Carro carro) {
    carros.remove(carro);
  }

  // Método para exibir todos os carros na garagem
  public void exibirCarros() {
    if (carros.isEmpty()) {
      System.out.println("A garagem está vazia.");
    }
else {
      System.out.println("Carros na garagem:");
      for (Carro carro : carros) {
        carro.exibirInformacoes();
        System.out.println();
      }
    }
  }

}

```

- Testes

```java
//import para fazer os testes automatizados
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class GaragemTest {

    private Garagem garagem;
    private Carro carro1;
    private Carro carro2;

    @Test
    void testAdicionarCarro() {

	//cria carros para o teste
	carro1 = new Carro("Fusca", "ABC-1234", 1980);
        carro2 = new Carro("Civic", "DEF-4321", 2020);
	//adiciona eles na garagem
        garagem.adicionarCarro(carro1);
        garagem.adicionarCarro(carro2);

        // Verifica se o número de carros na garagem é 2
        assertEquals(2, garagem.getCarros().size());
    }
}

```

- UML

<img width="865" alt="image" src="https://github.com/user-attachments/assets/1b919484-ba08-49e5-b9f2-ad8737b325a4">




## exemplos de perguntas que o bot consegue responder

* Quantas medalhas de prata o brasil ganhou?
* Qual atleta do brasil ganhou mais medalhas?
* Quais são todos os atletas do Brasil?
* Quantas medalhas o brasil ganhou no esporte Skateboarding
* quais sao todos os atletas do argentina ?
