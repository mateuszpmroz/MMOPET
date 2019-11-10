package pl.mroz.tau.mmopet.bdd.impl.FriendList;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pl.mroz.tau.mmopet.domain.models.Champion;
import pl.mroz.tau.mmopet.manager.DatabaseManager;
import pl.mroz.tau.mmopet.repository.ChampionRepository;
import pl.mroz.tau.mmopet.service.ChampionService;
import pl.mroz.tau.mmopet.service.ChampionServiceImpl;
import pl.mroz.tau.mmopet.service.exceptions.ObjectAlreadyExistException;

import static org.junit.Assert.*;

public class AddChampionToAFriendTest {
    private Champion champion;
    private Champion friendChampion;
    private ChampionRepository championRepository;
    private ChampionService championService;
    private DatabaseManager databaseManager;

    @Given("^I am logged as a champion$")
    public void iAmLoggedAsAChampion() throws ObjectAlreadyExistException {
        this.champion = new Champion(0);
        this.friendChampion = new Champion(1);
        this.champion.setName("unique");
        this.friendChampion.setName("test");
        this.databaseManager = new DatabaseManager();
        this.championService = new ChampionServiceImpl(this.databaseManager);
        this.championRepository = new ChampionRepository(this.championService);
        this.championService.create(this.champion);
        this.championService.create(this.friendChampion);
    }

    @And("^I don't have a friend on a friend list$")
    public void iDonTHaveAFriendOnAFriendList() {
        assertFalse(this.champion.getFriendList().contains(this.friendChampion.getId()));
    }

    @When("^I search for a \"([^\"]*)\" on add friend list search box and add as a friend$")
    public void iSearchForAOnAddFriendListSearchBox(String name) {
        Champion searchedFriend = this.championRepository.getChampionsByNameRegex(name).get(0);
        this.champion.addFriendToFriendList(searchedFriend.getId());
    }

    @Then("^I should have a new friend on a friend list$")
    public void iShouldHaveAOnAFriendList() {
        assertTrue(this.champion.getFriendList().contains(this.friendChampion.getId()));
    }
}
