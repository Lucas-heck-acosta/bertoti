// Context: utiliza composição para delegar o comportamento de ponto
public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
    private TipoDePonto tipoDePonto; // Strategy

    public Funcionario(String nome, String cargo, double salario, TipoDePonto tipoDePonto) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.tipoDePonto = tipoDePonto;
    }

    public String baterPonto() {
        return tipoDePonto.registrarPonto();
    }

    public void setTipoDePonto(TipoDePonto tipoDePonto) {
        this.tipoDePonto = tipoDePonto;
    }

    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public double getSalario() { return salario; }
}
