public class PainelResumo implements Observador {
    @Override
    public void atualizar(double precoAcao, double precoFii) {
        System.out.println("[Resumo] Ação=" + precoAcao + " / FII=" + precoFii);
    }
}
