package edu.umbc.dmutlu1.chocolatecafedem;

public class Dessert
{
    private final String name;
    private final String title;
    private final int image;
    private final String URL;

    public Dessert(String name, String title, int image, String URL)
    {
        this.name = name;
        this.title = title;
        this.image = image;
        this.URL = URL;
    }

    public String getName()
    {
        return name;
    }

    public String getTitle()
    {
        return title;
    }

    public int getImage()
    {
        return image;
    }

    public String getURL()
    {
        return URL;
    }
}