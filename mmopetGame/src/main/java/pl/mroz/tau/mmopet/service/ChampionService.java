package pl.mroz.tau.mmopet.service;

import org.springframework.stereotype.Repository;
import pl.mroz.tau.mmopet.domain.models.Champion;
import pl.mroz.tau.mmopet.domain.models.Model;
import pl.mroz.tau.mmopet.service.exceptions.ObjectAlreadyExistException;
import pl.mroz.tau.mmopet.service.exceptions.ObjectDoesNotExistException;

import java.util.List;

@Repository
public interface ChampionService {
    public void create(Champion model) throws ObjectAlreadyExistException;
    public List<Champion> readAll();
    public Champion read(int id);
    public void update(Champion model) throws ObjectDoesNotExistException;
    public void delete(Champion model);
}
