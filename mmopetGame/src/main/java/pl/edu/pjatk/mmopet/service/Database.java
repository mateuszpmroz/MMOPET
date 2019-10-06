package main.java.pl.edu.pjatk.mmopet.service;

import main.java.pl.edu.pjatk.mmopet.domain.models.Model;
import main.java.pl.edu.pjatk.mmopet.service.exceptions.ObjectDoesNotExistException;
import main.java.pl.edu.pjatk.mmopet.service.exceptions.ObjectAlreadyExistException;

import java.util.List;

public class Database {
    private List<Model> collection;

    public void create(Model model) throws ObjectAlreadyExistException {
        for (Model element: this.collection) {
            if (element.getId() == model.getId()) {
                throw new ObjectAlreadyExistException();
            }
        }
        this.collection.add(model);
    }

    public List<Model> readAll() {
        return this.collection;
    }

    public Model read(int id) {
        return this.collection.get(id);
    }

    public void update(Model model) throws ObjectDoesNotExistException {
        int modelId = model.getId();
        if (this.collection.get(modelId) == null) {
            throw new ObjectDoesNotExistException();
        }
        this.collection.set(modelId, model);
    }

    public void delete(Model model) {
        this.collection.remove(model.getId());
    }
}
