package pl.mroz.tau.mmopet.service;

import pl.mroz.tau.mmopet.domain.models.Champion;
import pl.mroz.tau.mmopet.domain.models.Model;
import pl.mroz.tau.mmopet.service.exceptions.ObjectAlreadyExistException;
import pl.mroz.tau.mmopet.service.exceptions.ObjectDoesNotExistException;

import java.util.List;

public interface ChampionService {
    public void create(Champion model) throws ObjectAlreadyExistException;
    public List<Champion> readAll();
    public Champion read(int id);
    public void update(Champion model) throws ObjectDoesNotExistException;
    public void delete(Champion model);
}
