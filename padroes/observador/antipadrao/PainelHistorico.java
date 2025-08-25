public class PainelHistorico {
    private final Bolsa bolsa;
    private double ultimoAcao = Double.NaN;
    private double ultimoFii = Double.NaN;

    public PainelHistorico(Bolsa bolsa) { this.bolsa = bolsa; }

    public void checar() {
        double a = bolsa.getPrecoAcao();
        double f = bolsa.getPrecoFii();
        if (Double.compare(a, ultimoAcao) != 0 || Double.compare(f, ultimoFii) != 0) {
            System.out.println("[Histórico-RUIM] Ação: " + a + " | FII: " + f);
            ultimoAcao = a;
            ultimoFii = f;
        }
    }
}
