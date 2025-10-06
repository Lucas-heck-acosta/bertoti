import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private List<Funcionario> funcionarios;
    private List<Departamento> subdepartamentos;

    public Departamento(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
        this.subdepartamentos = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void adicionarSubdepartamento(Departamento departamento) {
        subdepartamentos.add(departamento);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void removerSubdepartamento(Departamento departamento) {
        subdepartamentos.remove(departamento);
    }

    public void mostrarDetalhes() {
        System.out.println("Departamento: " + nome);

        if (!funcionarios.isEmpty()) {
            System.out.println("Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.print("  ");
                funcionario.mostrarDetalhes();
            }
        }

        if (!subdepartamentos.isEmpty()) {
            System.out.println("Subdepartamentos:");
            for (Departamento subdep : subdepartamentos) {
                System.out.print("  ");
                subdep.mostrarDetalhes();
            }
        }
    }

    public double calcularSalarioTotal() {
        double total = 0;

        for (Funcionario funcionario : funcionarios) {
            total += funcionario.getSalario();
        }

        for (Departamento subdep : subdepartamentos) {
            total += subdep.calcularSalarioTotal();
        }

        return total;
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionario> getFuncionarios() {
        return new ArrayList<>(funcionarios);
    }

    public List<Departamento> getSubdepartamentos() {
        return new ArrayList<>(subdepartamentos);
    }
}
