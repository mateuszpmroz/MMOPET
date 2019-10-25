package pl.mroz.tau.mmopet.manager;

import org.mockito.Mockito;
import pl.mroz.tau.mmopet.domain.models.Champion;
import pl.mroz.tau.mmopet.domain.models.Model;
import pl.mroz.tau.mmopet.manager.DatabaseManager;
import pl.mroz.tau.mmopet.service.exceptions.ObjectAlreadyExistException;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseManagerTest {
    private DatabaseManager database;

    DatabaseManagerTest() {
        database = new DatabaseManager();
    }

    @org.junit.jupiter.api.Test
    public void setsCreatedAtDateOnObjectCreateInDb() throws ObjectAlreadyExistException {
        long createdAt = 30L;
        Date dateMock = Mockito.mock(Date.class);
        Mockito.when(dateMock.getTime()).thenReturn(createdAt);
        Champion champion = new Champion(0);
        champion.setCreatedAt(dateMock.getTime());
        assertEquals(createdAt, champion.createdAt);
    }
}
