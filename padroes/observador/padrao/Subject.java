public interface Subject {
    void adicionarObservador(Observador observador);
    void removerObservador(Observador observador);
    void notificarObservadores();
}

