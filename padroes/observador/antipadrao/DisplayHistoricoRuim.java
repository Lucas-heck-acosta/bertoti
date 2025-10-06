public class DisplayHistoricoRuim {
    private final BolsaAntipadrao bolsa;
    private double ultimoAcao = Double.NaN;
    private double ultimoFii = Double.NaN;

    public DisplayHistoricoRuim(BolsaAntipadrao bolsa) {
        this.bolsa = bolsa;
    }

    public void checar() {
        double a = bolsa.getPrecoAcao();
        double f = bolsa.getPrecoFii();
        if (mudou(a, f)) {
            System.out.println("[Histórico-RUIM] Ação: " + a + " | FII: " + f);
            ultimoAcao = a;
            ultimoFii = f;
        }
    }

    private boolean mudou(double a, double f) {
        return Double.compare(a, ultimoAcao) != 0 || Double.compare(f, ultimoFii) != 0;
    }
}
