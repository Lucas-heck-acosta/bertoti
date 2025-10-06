public class Main {
    public static void main(String[] args) {
        FuncionarioCLT ana = new FuncionarioCLT("Ana", "Analista", 5000.0);
        FuncionarioPJ bruno = new FuncionarioPJ("Bruno", "Desenvolvedor", 7000.0);

        System.out.println("=== ANTI-PADRÃO STRATEGY ===");
        System.out.println(ana.getNome() + ": " + ana.baterPonto());
        System.out.println(bruno.getNome() + ": " + bruno.baterPonto());

        System.out.println("\n=== PROBLEMAS DO ANTI-PADRÃO ===");
        System.out.println("- Não é possível trocar o tipo de ponto em runtime");
        System.out.println("- Comportamento fixo definido por herança");
        System.out.println("- Para adicionar novo tipo, precisa criar nova subclasse");
        System.out.println("- Viola o princípio Open/Closed");

        // Demonstrando que não é possível mudar o comportamento
        System.out.println("\nAna sempre usará: " + ana.getTipoDePonto());
        System.out.println("Bruno sempre usará: " + bruno.getTipoDePonto());
        System.out.println("Não há como mudar o comportamento em runtime!");
    }
}

