class Cliente {
    public void enviar(String imagem) {
        JpegService service = new JpegService();
        service.processarJpeg(imagem);
    }
}

