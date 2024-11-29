package model;

public class Shelf {
    private int id;
    private String genre;
    private int capacity;

    public Shelf(int id, String genre, int capacity) {
        this.id = id;
        this.genre = genre;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
