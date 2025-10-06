public class Main {
    public static void main(String[] args) {
        BolsaDeValores bolsa = new BolsaDeValores();

        PainelHistorico painelHistorico = new PainelHistorico();
        PainelResumo painelResumo = new PainelResumo();

        bolsa.adicionarObservador(painelHistorico);
        bolsa.adicionarObservador(painelResumo);

        System.out.println("=== PADRÃO OBSERVER ===");
        System.out.println("Preços iniciais:");
        System.out.println("Ação: " + bolsa.getPrecoAcao() + " | FII: " + bolsa.getPrecoFii());

        System.out.println("\n--- Atualizando preço da ação ---");
        bolsa.atualizarPrecoAcao(120.50);

        System.out.println("\n--- Atualizando preço do FII ---");
        bolsa.atualizarPrecoFii(180.30);

        System.out.println("\n--- Removendo PainelHistorico ---");
        bolsa.removerObservador(painelHistorico);

        System.out.println("\n--- Nova atualização (só PainelResumo será notificado) ---");
        bolsa.atualizarPrecoAcao(125.75);
    }
}
