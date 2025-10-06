public class Main {
    public static void main(String[] args) {
        Funcionario dev1 = new Funcionario("João", "Desenvolvedor", 5000);
        Funcionario dev2 = new Funcionario("Maria", "Desenvolvedor", 5500);
        Funcionario tester = new Funcionario("Pedro", "Tester", 4000);

        Funcionario gerente = new Funcionario("Ana", "Gerente", 8000);
        Funcionario diretor = new Funcionario("Carlos", "Diretor", 15000);

        Departamento depDesenvolvimento = new Departamento("Desenvolvimento");
        Departamento depTI = new Departamento("TI");
        Departamento empresa = new Departamento("Empresa XYZ");

        depDesenvolvimento.adicionarFuncionario(dev1);
        depDesenvolvimento.adicionarFuncionario(dev2);
        depDesenvolvimento.adicionarFuncionario(tester);

        depTI.adicionarSubdepartamento(depDesenvolvimento);
        depTI.adicionarFuncionario(gerente);

        empresa.adicionarSubdepartamento(depTI);
        empresa.adicionarFuncionario(diretor);

        System.out.println("=== ESTRUTURA ORGANIZACIONAL (ANTI-PADRÃO) ===");
        empresa.mostrarDetalhes();

        System.out.println("\n=== CÁLCULO DE SALÁRIOS ===");
        System.out.println("Total de salários da empresa: R$ " + empresa.calcularSalarioTotal());
        System.out.println("Total de salários do TI: R$ " + depTI.calcularSalarioTotal());
        System.out.println("Total de salários do Desenvolvimento: R$ " + depDesenvolvimento.calcularSalarioTotal());

        System.out.println("\n=== PROBLEMAS DO ANTI-PADRÃO ===");
        System.out.println("- Métodos diferentes para adicionar funcionários vs departamentos");
        System.out.println("- Lógica complexa e repetitiva nos métodos");
        System.out.println("- Sem polimorfismo - cliente precisa saber o tipo específico");
        System.out.println("- Difícil extensão para novos tipos de componentes");
    }
}

