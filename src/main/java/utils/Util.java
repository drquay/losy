package utils;

import model.Icon;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

public class Util {

    public static DecimalFormat getDecimalFormat() {
        final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.GERMAN);
        return (DecimalFormat) numberFormat;
    }

    // Method to set default font for all components
    public static void setUIFont(FontUIResource f) {
        java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, f);
            }
        }
    }

    public static ImageIcon getIconFromResource(Class clazz, Icon icon) {
        final Optional<URL> resource = getFileFromResource(clazz, icon.getPathFromResource());
        if (resource.isEmpty()) {
            System.out.println("Error loading resource from path: " + icon.getPathFromResource());
            return null;
        }
        final BufferedImage image = renderSVGToImage(resource.get().getPath(),
                icon.getCharset(), icon.getWidth(), icon.getHeight());
        if (image != null) {
            return new ImageIcon(image);
        }
        return null;
    }

    public static Optional<URL> getFileFromResource(Class clazz, String pathToFile) {
        final URL resource = clazz.getResource(pathToFile);
        return Optional.ofNullable(resource);
    }

    public static BufferedImage renderSVGToImage(String svgFilePath, Charset charset, int width, int height) {
        try {
            final InputStream svgFileStream = new FileInputStream(svgFilePath);
            final InputStreamReader svgReader = new InputStreamReader(svgFileStream, charset);
            final TranscoderInput input = new TranscoderInput(svgReader);

            final BufferedImageTranscoder imageTranscoder = new BufferedImageTranscoder(width, height);
            imageTranscoder.transcode(input, null);
            return imageTranscoder.getBufferedImage();
        } catch (Exception e) {
            System.out.println("Error loading svg: " + e.getMessage());
        }
        return null;
    }

    static class BufferedImageTranscoder extends ImageTranscoder {
        private BufferedImage bufferedImage;

        public BufferedImageTranscoder(int width, int height) {
            hints.put(KEY_WIDTH, (float) width);
            hints.put(KEY_HEIGHT, (float) height);
        }

        @Override
        public BufferedImage createImage(int width, int height) {
            return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }

        @Override
        public void writeImage(BufferedImage img, TranscoderOutput output) {
            this.bufferedImage = img;
        }

        public BufferedImage getBufferedImage() {
            return bufferedImage;
        }
    }
}
