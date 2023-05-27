package com.example.uniconvert;

public class Dimension {
    int Image;
    String dim;

    public Dimension(int image, String dim) {
        Image = image;
        this.dim = dim;
    }

    public int getImage() {
        return Image;
    }

    public String getDim() {
        return dim;
    }
}
