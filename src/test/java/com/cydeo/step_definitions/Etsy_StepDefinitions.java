package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_StepDefinitions {
    EtsyPage etsyPage = new EtsyPage();
    @Given("user is on etsy website")
    public void user_is_on_etsy_website() {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));
    }
    @Then("user is able to see the title as expected")
    public void user_is_able_to_see_the_title_as_expected() {
        Assert.assertEquals("Verification failed","Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone",Driver.getDriver().getTitle());
    }

    @When("user types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
        etsyPage.searchbox.sendKeys("Wooden Spoon");
    }
    @When("user clicks search button")
    public void user_clicks_search_button() {
       etsyPage.searchButton.click();
    }
    @Then("user sees Wooden spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
       Assert.assertTrue("Verification failed", Driver.getDriver().getTitle().contains("Wooden spoon"));
    }

    @When("user types {string} in the search box")
    public void user_types_in_the_search_box(String searchWord) {
       etsyPage.searchbox.sendKeys(searchWord);
    }
    @Then("user sees {string} is in the title")
    public void user_sees_is_in_the_title(String searchwords) {
        Assert.assertTrue("Verification failed", Driver.getDriver().getTitle().contains(searchwords));
    }
}
