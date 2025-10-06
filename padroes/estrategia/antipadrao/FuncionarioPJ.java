class FuncionarioPJ extends Funcionario {
    private String tipoDePonto;

    public FuncionarioPJ(String nome, String cargo, double salario) {
        super(nome, cargo, salario);
        this.tipoDePonto = "Online";
    }

    public String baterPonto() {
        return "Ponto registrado Online";
    }

    public String getTipoDePonto() {
        return tipoDePonto;
    }
}