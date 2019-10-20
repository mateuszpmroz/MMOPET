package pl.mroz.tau.mmopet.domain.models;

import java.util.Date;

public class BaseModel {
    public Date createdAt;
    public Date updatedAt;
    public Date readedAt;

    public BaseModel() {
        this.createdAt = new Date();
    }
}
