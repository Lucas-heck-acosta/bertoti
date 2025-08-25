import java.util.ArrayList;
import java.util.List;

public class Bolsa {

    double precoAcao = 37.15;
    double precoFii = 167.80;

    List<Observador> observadores = new ArrayList<>();

    public void addObservador(Observador o) {
        observadores.add(o);
    }

    public void notificar(){
        for(Observador observador:observadores){
            observador.atualizar(precoAcao, precoFii);
        }
    }

    public static void main(String[] args) {
        Bolsa bolsa = new Bolsa();

        bolsa.addObservador(new PainelHistorico());
        bolsa.addObservador(new PainelResumo());

        bolsa.notificar();
    }
}