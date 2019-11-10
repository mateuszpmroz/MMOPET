package pl.mroz.tau.mmopet.service;

import pl.mroz.tau.mmopet.domain.models.Champion;
import pl.mroz.tau.mmopet.manager.DatabaseManager;
import pl.mroz.tau.mmopet.service.exceptions.ObjectAlreadyExistException;
import pl.mroz.tau.mmopet.service.exceptions.ObjectDoesNotExistException;

import java.util.List;
import java.util.stream.Collectors;

public class ChampionServiceImpl implements ChampionService {
    private DatabaseManager databaseManager;

    public ChampionServiceImpl(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public void create(Champion model) throws ObjectAlreadyExistException {
        this.databaseManager.create(model);
    }

    @Override
    public List<Champion> readAll() {
        return this.databaseManager.readAll().stream().filter(model -> model instanceof Champion).map(model -> (Champion) model).collect(Collectors.toList());
    }

    @Override
    public Champion read(int id) {
        return (Champion) this.databaseManager.read(id);
    }

    @Override
    public void update(Champion model) throws ObjectDoesNotExistException {
        this.databaseManager.update(model);
    }

    @Override
    public void delete(Champion model) {
        this.databaseManager.delete(model);
    }
}
