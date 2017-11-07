package edu.umbc.dmutlu1.chocolatecafedem;

public class Dessert
{

    private final String name;
    private final String title;
    private final int image;

    public Dessert(String name, String title, int image) {
        this.name = name;
        this.title = title;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}