package pl.mroz.tau.mmopet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.mroz.tau.mmopet.domain.models.Champion;
import pl.mroz.tau.mmopet.service.ChampionService;
import pl.mroz.tau.mmopet.service.exceptions.ObjectAlreadyExistException;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ChampionApi {
    @Autowired
    ChampionService championService;

    @RequestMapping(value = "/champion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Champion getChampion(@PathVariable("id") int id) throws SQLException {
        return this.championService.read(id);
    }

    @RequestMapping(value = "/champions", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Champion> getChampions(@RequestParam(value = "filter", required = false) String f) throws SQLException {
        List<Champion> champions = new LinkedList<Champion>();
        for (Champion c : this.championService.readAll()) {
            if (f == null) {
                champions.add(c);
            } else if (c.getName().contains(f)) {
                champions.add(c);
            }
        }
        return champions;
    }

    @RequestMapping(value = "/champion",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Champion addChampion(@RequestBody Champion c) throws ObjectAlreadyExistException {
        try {
            this.championService.create((c));
            return c;
        } catch (ObjectAlreadyExistException e) {
            return null;
        }
    }

    @RequestMapping(value = "/champion/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteChampion(@PathVariable("id") int id) throws SQLException {
        this.championService.delete(this.championService.read(id));
        return id;
    }
}
