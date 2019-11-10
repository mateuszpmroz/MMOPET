package pl.mroz.tau.mmopet.domain.models;

import java.util.List;

public class Champion extends BaseModel implements Model {
    private int id;
    private String name;
    private List<Integer> friendList;

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

    public void addFriendToFriendList(int id) {
        this.friendList.add(id);
    }

    public List<Integer> getFriendList() {
        return this.friendList;
    }
}
