package pl.mroz.tau.mmopet.models;

import pl.mroz.tau.mmopet.domain.models.BaseModel;
import static org.junit.jupiter.api.Assertions.*;

class BaseModelTest {
    private BaseModel baseModel;

    @org.junit.jupiter.api.Test
    void setCreatedAtWhenObjectIsCreated() {
        this.baseModel = new BaseModel();
        assertNotNull(this.baseModel.createdAt);
    }

    @org.junit.jupiter.api.Test
    void doesNotSetUpdatedAtAndReadedAt() {
        this.baseModel = new BaseModel();
        assertEquals(this.baseModel.updatedAt, 0);
        assertEquals(this.baseModel.readedAt, 0);
    }
}
