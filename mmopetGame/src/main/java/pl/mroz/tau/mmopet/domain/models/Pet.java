package pl.mroz.tau.mmopet.domain.models;

public class Pet implements Model {
    private int id;

    public Pet(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
