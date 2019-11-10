package pl.mroz.tau.mmopet.repository;

import pl.mroz.tau.mmopet.domain.models.Champion;
import pl.mroz.tau.mmopet.service.ChampionService;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ChampionRepository {
    private ChampionService championService;

    ChampionRepository(ChampionService championService) {
        this.championService = championService;
    }

    public List<Champion> getChampionsByNameRegex(String name) {
        Pattern pattern = Pattern.compile(".*" + name + ".*");
        List<Champion> champions;
        champions = this.championService.readAll();
        return champions.stream().filter(champion -> pattern.matcher(champion.getName()).matches()).collect(Collectors.toList());
    }
}
