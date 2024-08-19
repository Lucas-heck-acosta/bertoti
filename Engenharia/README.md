## Aula 1

We see three critical differences between programming and software engineering: time, scale, and the trade-offs at play. On a software engineering project, engineers need to be more concerned with the passage of time and the eventual need for change. In a software engineering organization, we need to be more concerned about scale and efficiency, both for the software we produce as well as for the organization that is producing it. Finally, as software engineers, we are asked to make more complex decisions with higher-stakes outcomes, often based on imprecise estimates of time and growth.

- O que é Engenharia de Software?

A engenharia de software é similar às outras engenharias na aplicação de uma abordagem sistemática para resolver problemas complexos, envolvendo fases de planejamento, design, implementação, teste e manutenção. Assim como nas demais engenharias, a modelagem, o teste rigoroso e o gerenciamento de projetos são cruciais para garantir a qualidade do produto final. No entanto, a engenharia de software se distingue por sua ênfase em tempo, escala e decisões complexas. Os engenheiros de software precisam considerar a necessidade de futuras mudanças, a escalabilidade do software e a eficiência da organização, tomando decisões de alto impacto com base em estimativas muitas vezes imprecisas.


## Aula 2

- Portabilidade
    Fazer um software portátil o torna mais difícil de otimizar, ao passo que otimizar um software para um dispositivo específico pode sacrificar sua portabilidade.

- Ecalabilidade
    Projetar um sistema escalável o torna muito mais complexo, enquanto projetos simples tem uma capacidade limitada.

- Manutenção
    Manter um código de fácil e eficiente manutenção pode custar muito tempo e acabar atrasando o projeto, enquanto um código entregue antes do prazo pode apresentar dificuldades de manutenção.



## Aula 3

- Classe aluno
```java

//declarando a classe, um substantivo 
public class Aluno {

  //declarando seus atributos (privados, onde apenas a classe tem acesso)
	private String nome;
	private String ra;
	
	//construtor, o código que acontece na criação do objeto, podendo ser passado argumentos para utilizar na lógica
	public Aluno(String nome, String ra) {
	  //this para acessar o atributo da classe
		this.nome = nome;
		this.ra = ra;
	}

  //metodos são como as funções que podem ser chamadas de cada classe, como uma maneira de solicitar um retorno ou efetuar uma operação
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	
}


```

- Classe SalaAula
```java

import java.util.List;
import java.util.LinkedList;

public class SalaAula {
  //Utilizando a classe predefinida List do pacote Util
	private List<Aluno> alunos = new LinkedList<Aluno>();

  //um metodo para adicionar o aluno passado no parametro a lista de alunos na sala
	public void cadastrarAluno(Aluno aluno) {
		alunos.add(aluno);
	}


	public List<Aluno> buscarAlunoPorNome(String nome){
    //cria uma nova lista vazia
		List<Aluno> alunosEncontrados = new LinkedList<Aluno>();
		for(Aluno aluno:alunos) { //passa por todos os alunos da lista original
			if(aluno.getNome().equals(nome)) //se um aluno for encontrado com o nome passado
				alunosEncontrados.add(aluno);  //adiciona esse aluno a lista temporaria do metodo
		}
		return alunosEncontrados; //retorna a lista com os alunos correspondentes
	}
	
	public List<Aluno> getAlunos(){
		return alunos;
	}
	
}


```

- Testes

```java
//importando os pacotes para realizar os testes
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void test() {
		
		SalaAula fatecBancoDeDados = new SalaAula();

    //criando duas instancias de aluno com os dados de teste 
		Aluno lucas = new Aluno("Lucas", "123123");
		Aluno pedro = new Aluno("Pedro", "555555");
		
		fatec.cadastrarAluno(lucas);
		fatec.cadastrarAluno(pedro);

    // testando se o tamanho da lista de alunos é igual a dois, depois de ter adicionado dois alunos a uma lista vazia
		assertEquals(fatec.getAlunos().size(), 2);

    //Criando uma nova lista que vem do metado de buscar alunos, utilizando o parametro "lucas"
		List<Aluno> todosOsLucas = fatec.buscarAlunoPorNome("lucas");

    //como criamos apenas um lucas, o tamanho da nova lista deve ser 1
		assertEquals(todosOsLucas.size(), 1);
		
		
	}

}

```
