package main.java.pl.edu.pjatk.mmopet.domain.models;

public class Champion implements Model {
    private int id;

    public Champion(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
