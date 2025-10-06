import java.util.ArrayList;
import java.util.List;

public class BolsaDeValores implements Subject {
    private double precoAcao = 100.0;
    private double precoFii = 200.0;
    private final List<Observador> observadores = new ArrayList<>();

    @Override
    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.atualizar(precoAcao, precoFii);
        }
    }

    // Métodos para atualizar os preços e notificar observadores
    public void atualizarPrecoAcao(double novoPreco) {
        this.precoAcao = novoPreco;
        notificarObservadores();
    }

    public void atualizarPrecoFii(double novoPreco) {
        this.precoFii = novoPreco;
        notificarObservadores();
    }

    // Getters para os preços atuais
    public double getPrecoAcao() {
        return precoAcao;
    }

    public double getPrecoFii() {
        return precoFii;
    }
}
