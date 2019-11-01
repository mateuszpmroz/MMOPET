package pl.mroz.tau.mmopet.domain.models;

public class Weapon extends BaseModel implements Model {
    private int id;

    public Weapon(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
