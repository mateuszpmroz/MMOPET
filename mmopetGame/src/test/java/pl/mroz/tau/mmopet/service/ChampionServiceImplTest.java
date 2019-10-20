package pl.mroz.tau.mmopet.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pl.mroz.tau.mmopet.domain.models.Champion;
import pl.mroz.tau.mmopet.manager.DatabaseManager;
import pl.mroz.tau.mmopet.service.exceptions.ObjectAlreadyExistException;
import pl.mroz.tau.mmopet.service.exceptions.ObjectDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChampionServiceImplTest {
    private ChampionServiceImpl championService;

    @BeforeEach
    public void before() {
        DatabaseManager databaseManager = new DatabaseManager();
        this.championService = new ChampionServiceImpl(databaseManager);
    }

    @AfterEach
    public void after() {
        this.championService = null;
    }

    @org.junit.jupiter.api.Test
    public void throwsExceptionWhenObjectAlreadyExist() throws ObjectAlreadyExistException {
        Champion champion = new Champion(1);
        this.championService.create(champion);
        assertThrows(ObjectAlreadyExistException.class, () -> {
            this.championService.create(champion);
        });
    }

    @org.junit.jupiter.api.Test
    public void createsChampionInTheDatabase() throws ObjectAlreadyExistException {
        int objectId = 1;
        Champion champion = new Champion(objectId);
        this.championService.create(champion);
        assertEquals(this.championService.read(0), champion);
    }

    @org.junit.jupiter.api.Test
    public void readsAllTheChampionsFromTheDatabase() throws ObjectAlreadyExistException {
        Champion champion = new Champion(0);
        Champion otherChampion = new Champion(1);
        this.championService.create(champion);
        this.championService.create(otherChampion);
        List<Champion> listOfChampions = new ArrayList<>();
        listOfChampions.add(champion);
        listOfChampions.add(otherChampion);
        assertEquals(this.championService.readAll(), listOfChampions);
    }

    @org.junit.jupiter.api.Test
    public void readChampionFromTheDatabase() throws ObjectAlreadyExistException {
        Champion champion = new Champion(0);
        this.championService.create(champion);
        assertEquals(this.championService.read(champion.getId()), champion);
    }

    @org.junit.jupiter.api.Test
    public void updatesChampionInTheDatabase() throws ObjectAlreadyExistException, ObjectDoesNotExistException {
        Champion champion = new Champion(0);
        this.championService.create(champion);
        champion.setName("test");
        this.championService.update(champion);
        assertEquals(this.championService.read(champion.getId()), champion);
    }

    @org.junit.jupiter.api.Test
    public void throwsExceptionIfObjectDoesNotExistInTheDatabase() throws ObjectAlreadyExistException, ObjectDoesNotExistException {
        Champion champion = new Champion(0);
        Champion otherChampion = new Champion(1);
        this.championService.create(champion);
        assertThrows(ObjectDoesNotExistException.class, () -> {
            this.championService.update(otherChampion);
        });
    }

    @org.junit.jupiter.api.Test
    public void deletesChampionFromTheDatabase() throws ObjectAlreadyExistException {
        Champion champion = new Champion(0);
        this.championService.create(champion);
        this.championService.delete(champion);
        ArrayList emptyList = new ArrayList();
        assertEquals(this.championService.readAll(), emptyList);
    }
}
