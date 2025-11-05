public class Cliente {
    private ImageConverter converter;

    public Cliente(ImageConverter converter) {
        this.converter = converter;
    }

    public void converterImagem(String caminho) {
        System.out.println("Cliente: solicitando conversão de " + caminho);
        converter.convert(caminho);
        System.out.println("Cliente: conversão concluída\n");
    }
}

