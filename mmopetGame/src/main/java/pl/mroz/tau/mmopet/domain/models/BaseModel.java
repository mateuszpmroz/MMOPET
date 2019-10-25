package pl.mroz.tau.mmopet.domain.models;

import java.util.Date;

public class BaseModel {
    public long createdAt;
    public long updatedAt;
    public long readedAt;

    public BaseModel() {
    }

    public void setCreatedAt(Long time) {
        this.createdAt = time;
    }

    public void setUpdatedAt(Long time) {
        this.updatedAt = time;
    }

    public void setReadedAt(Long time) {
        this.readedAt = time;
    }
}
