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

        depDesenvolvimento.adicionarComponente(dev1);
        depDesenvolvimento.adicionarComponente(dev2);
        depDesenvolvimento.adicionarComponente(tester);

        depTI.adicionarComponente(depDesenvolvimento);
        depTI.adicionarComponente(gerente);

        empresa.adicionarComponente(depTI);
        empresa.adicionarComponente(diretor);

        System.out.println("=== ESTRUTURA ORGANIZACIONAL ===");
        empresa.mostrarDetalhes();

        System.out.println("\n=== CÁLCULO DE SALÁRIOS ===");
        System.out.println("Total de salários da empresa: R$ " + empresa.calcularSalario());
        System.out.println("Total de salários do TI: R$ " + depTI.calcularSalario());
        System.out.println("Total de salários do Desenvolvimento: R$ " + depDesenvolvimento.calcularSalario());
    }
}

