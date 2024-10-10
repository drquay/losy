package model;

import java.nio.charset.Charset;

public class Icon {
    private String pathFromResource;
    private Charset charset;
    private int width;
    private int height;

    public Icon(String pathFromResource, Charset charset, int width, int height) {
        this.pathFromResource = pathFromResource;
        this.charset = charset;
        this.width = width;
        this.height = height;
    }

    public String getPathFromResource() {
        return pathFromResource;
    }

    public void setPathFromResource(String pathFromResource) {
        this.pathFromResource = pathFromResource;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
