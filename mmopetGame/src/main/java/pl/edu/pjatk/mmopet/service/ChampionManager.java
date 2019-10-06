package main.java.pl.edu.pjatk.mmopet.service;

import main.java.pl.edu.pjatk.mmopet.domain.models.Model;

import java.sql.Connection;
import java.util.List;

public class ChampionManager implements Manager {
    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public int add(Model champion) {
        return 0;
    }

    @Override
    public List<Model> getAll() {
        return null;
    }
}
