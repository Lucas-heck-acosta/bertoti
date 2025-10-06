import java.util.ArrayList;
import java.util.List;

public class Departamento implements Componente {
    private String nome;
    private List<Componente> componentes;

    public Departamento(String nome) {
        this.nome = nome;
        this.componentes = new ArrayList<>();
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Departamento: " + nome);
        System.out.println("Membros:");
        for (Componente componente : componentes) {
            System.out.print("  ");
            componente.mostrarDetalhes();
        }
    }

    @Override
    public double calcularSalario() {
        double total = 0;
        for (Componente componente : componentes) {
            total += componente.calcularSalario();
        }
        return total;
    }

    @Override
    public void adicionarComponente(Componente componente) {
        componentes.add(componente);
    }

    @Override
    public void removerComponente(Componente componente) {
        componentes.remove(componente);
    }
}
