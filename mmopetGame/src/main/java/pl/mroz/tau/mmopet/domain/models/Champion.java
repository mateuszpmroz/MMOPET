package pl.mroz.tau.mmopet.domain.models;

public class Champion implements Model {
    private int id;
    private String name;

    public Champion(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
