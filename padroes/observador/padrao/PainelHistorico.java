public class PainelHistorico implements Observador {
    @Override
    public void atualizar(double precoAcao, double precoFii) {
        System.out.println("[Histórico] Registro -> Ação: " + precoAcao + " | FII: " + precoFii);
    }
}
