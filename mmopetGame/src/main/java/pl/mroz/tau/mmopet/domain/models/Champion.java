package pl.mroz.tau.mmopet.domain.models;

import java.util.ArrayList;
import java.util.List;

public class Champion extends BaseModel implements Model {
    private int id;
    private String name;
    private List<Integer> friendList;

    public Champion(int id) {
        this.friendList = new ArrayList<Integer>();
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

    public void addFriendToFriendList(int id) throws Exception {
        if (this.friendList.contains(id)) {
            throw new Exception("This friend already exist on your friends list.");
        }
        this.friendList.add(id);
    }

    public List<Integer> getFriendList() {
        return this.friendList;
    }
}
