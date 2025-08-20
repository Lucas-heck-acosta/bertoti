// Pequena demonstração do uso do Strategy para tipos de ponto
public class Main {
    public static void main(String[] args) {
        Funcionario ana = new Funcionario("Ana", "Analista", 5000.0, new PontoCartao());
        Funcionario bruno = new Funcionario("Bruno", "Desenvolvedor", 7000.0, new PontoOnline());

        System.out.println(ana.getNome() + ": " + ana.baterPonto());
        System.out.println(bruno.getNome() + ": " + bruno.baterPonto());

        ana.setTipoDePonto(new PontoOnline());
        System.out.println(ana.getNome() + " (trocado): " + f1.baterPonto());
    }
}
