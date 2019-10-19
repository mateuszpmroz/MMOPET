package pl.mroz.tau.mmopet.manager;

import pl.mroz.tau.mmopet.domain.models.Model;
import pl.mroz.tau.mmopet.service.exceptions.ObjectAlreadyExistException;
import pl.mroz.tau.mmopet.service.exceptions.ObjectDoesNotExistException;

import java.sql.Connection;
import java.util.List;

public interface Manager {
    public void create(Model model) throws ObjectAlreadyExistException;
    public List<Model> readAll();
    public Model read(int id);
    public void update(Model model) throws ObjectDoesNotExistException;
    public void delete(Model model);
}
