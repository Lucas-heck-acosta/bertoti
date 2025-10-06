class FuncionarioCLT extends Funcionario {
    private String tipoDePonto;

    public FuncionarioCLT(String nome, String cargo, double salario) {
        super(nome, cargo, salario);
        this.tipoDePonto = "Cartão";
    }

    public String baterPonto() {
        return "Ponto registrado com Cartão";
    }

    public String getTipoDePonto() {
        return tipoDePonto;
    }
}