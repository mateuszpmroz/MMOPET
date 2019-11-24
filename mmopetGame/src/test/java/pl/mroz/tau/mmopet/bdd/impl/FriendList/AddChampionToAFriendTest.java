package pl.mroz.tau.mmopet.bdd.impl.FriendList;

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
    private Champion searchedFriend;

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

    @And("^I don't have a friend on a friends list$")
    public void iDonTHaveAFriendOnAFriendsList() {
        assertFalse(this.champion.getFriendList().contains(this.friendChampion.getId()));
    }

    @When("^I search for a \"([^\"]*)\" on add friends list search box$")
    public void iSearchForAOnAddFriendsListSearchBox(String name) {
        this.searchedFriend = this.championRepository.getChampionsByNameRegex(name).get(0);
    }

    @Then("^I should have a new friend on a friends list$")
    public void iShouldHaveAOnAFriendsList() {
        assertTrue(this.champion.getFriendList().contains(this.friendChampion.getId()));
    }

    @And("^I add champion as a friend$")
    public void iAddChampionAsAFriend() throws Exception {
        this.champion.addFriendToFriendList(this.searchedFriend.getId());
    }

    @And("^I have a friend on a friends list$")
    public void iHaveAFriendOnAFriendList() throws Exception {
        this.champion.addFriendToFriendList(this.friendChampion.getId());
    }

    @Then("^I should got an error when add existing friend as a friend$")
    public void iShouldGotAnErrorWhenAddExistingFriendAsAFriend() throws Exception {
        assertThrows(Exception.class, () -> {
            this.champion.addFriendToFriendList(this.friendChampion.getId());
        });
    }
}
