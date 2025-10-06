public class Funcionario implements Componente {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Funcionário: " + nome + " - Cargo: " + cargo + " - Salário: R$ " + salario);
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    @Override
    public void adicionarComponente(Componente componente) {
        throw new UnsupportedOperationException("Funcionário não pode ter subordinados");
    }

    @Override
    public void removerComponente(Componente componente) {
        throw new UnsupportedOperationException("Funcionário não pode ter subordinados");
    }
}

