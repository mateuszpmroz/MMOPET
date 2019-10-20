package pl.mroz.tau.mmopet.models;

import pl.mroz.tau.mmopet.domain.models.BaseModel;
import static org.junit.jupiter.api.Assertions.*;

public class BaseModelTest {
    private BaseModel baseModel;

    @org.junit.jupiter.api.Test
    public void setCreatedAtWhenObjectIsCreated() {
        this.baseModel = new BaseModel();
        assertNotNull(this.baseModel.createdAt);
    }
}
