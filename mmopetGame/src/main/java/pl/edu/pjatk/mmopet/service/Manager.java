package main.java.pl.edu.pjatk.mmopet.service;

import main.java.pl.edu.pjatk.mmopet.domain.models.Model;

import java.sql.Connection;
import java.util.List;

public interface Manager {
    public Connection getConnection();
    public int add(Model model);
    public List<Model> getAll();
}
