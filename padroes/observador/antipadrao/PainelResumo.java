public class PainelResumo {
    private final Bolsa bolsa;
    private double acao = Double.NaN;
    private double fii = Double.NaN;

    public PainelResumo(Bolsa bolsa) { this.bolsa = bolsa; }

    public void checar() {
        double a = bolsa.getPrecoAcao();
        double f = bolsa.getPrecoFii();
        if (a != acao || f != fii) {
            System.out.println("[Resumo-RUIM] A=" + a + " / FII=" + f);
            acao = a;
            fii = f;
        }
    }
}
