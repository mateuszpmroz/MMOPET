package pl.edu.pjatk.mmopet.service;

import main.java.pl.edu.pjatk.mmopet.domain.models.Champion;
import main.java.pl.edu.pjatk.mmopet.domain.models.Model;
import main.java.pl.edu.pjatk.mmopet.service.Database;
import main.java.pl.edu.pjatk.mmopet.service.exceptions.ObjectAlreadyExistException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    Database database;

    DatabaseTest() {
        database = new Database();
    }

    @org.junit.jupiter.api.Test
    public void throwsExceptionWhenObjectAlreadyExist() throws ObjectAlreadyExistException {
        Model champion = new Champion(1);
        this.database.create(champion);
        assertThrows(ObjectAlreadyExistException.class, () -> {
            this.database.create(champion);
        });
    }
}
