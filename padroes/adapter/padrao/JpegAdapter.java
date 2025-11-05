public class JpegAdapter implements ImageConverter {
    private JpegService jpegService;

    public JpegAdapter(JpegService jpegService) {
        this.jpegService = jpegService;
    }

    @Override
    public void convert(String imagePath) {
        System.out.println("Adapter: traduzindo chamada convert() -> processJpeg()");
        jpegService.processJpeg(imagePath);
        System.out.println("Adapter: conversão finalizada para PNG");
    }
}

