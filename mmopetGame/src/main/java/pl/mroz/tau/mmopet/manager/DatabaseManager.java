package pl.mroz.tau.mmopet.manager;

import pl.mroz.tau.mmopet.domain.models.Model;
import pl.mroz.tau.mmopet.service.exceptions.ObjectDoesNotExistException;
import pl.mroz.tau.mmopet.service.exceptions.ObjectAlreadyExistException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseManager {
    private List<Model> collection;

    public DatabaseManager() {
        this.collection = new ArrayList<Model>();
    }

    public enum Datetime {
        CREATED_AT(true), UPDATED_AT(true), READED_AT(true);
        boolean isEnabled;

        Datetime(boolean b) {
            isEnabled = b;
        }
    }

    public void create(Model model) throws ObjectAlreadyExistException {
        if (this.collection != null && !this.collection.isEmpty()) {
            for (Model element : this.collection) {
                if (element.getId() == model.getId()) {
                    throw new ObjectAlreadyExistException();
                }
            }
        }
        if (Datetime.CREATED_AT.isEnabled) {
            Date date = new Date();
            model.setCreatedAt(date.getTime());
        }
        this.collection.add(model);
    }

    public List<Model> readAll() {
        return this.collection;
    }

    public Model read(int id) {
        Model model = this.collection.get(id);
        if (Datetime.READED_AT.isEnabled) {
            Date date = new Date();
            model.setReadedAt(date.getTime());
        }
        return this.collection.get(id);
    }

    public void update(Model model) throws ObjectDoesNotExistException {
        int modelId = model.getId();
        try {
            this.collection.get(modelId);
        } catch ( IndexOutOfBoundsException e ) {
            throw new ObjectDoesNotExistException();
        }

        if (Datetime.UPDATED_AT.isEnabled) {
            Date date = new Date();
            model.setUpdatedAt(date.getTime());
        }
        this.collection.set(modelId, model);
    }

    public void delete(Model model) {
        this.collection.remove(model.getId());
    }
}
