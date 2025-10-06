public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void mostrarDetalhes() {
        System.out.println("Funcionário: " + nome + " - Cargo: " + cargo + " - Salário: R$ " + salario);
    }

    public double getSalario() {
        return salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }
}

