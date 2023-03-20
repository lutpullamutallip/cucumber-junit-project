package com.cydeo.step_definitions;

import com.cydeo.pages.SmartBearPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class SmartBear_StepDefinitions {
    SmartBearPage smartBearPage = new SmartBearPage();
    @When("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {


        Driver.getDriver().get(ConfigurationReader.getProperty("smartBear.url"));
        smartBearPage.loginBox.sendKeys("Tester");
        smartBearPage.passwordBox.sendKeys("test");
        smartBearPage.loginButton.click();
    }
   /*
    @When("User selects FamilyAlbum from product dropdown")
    public void user_selects_family_album_from_product_dropdown() {


    }
    */
   @When("User selects {string} from product dropdown")
   public void user_selects_from_product_dropdown(String productName) {
      smartBearPage.orders.click();
       Select select = new Select(smartBearPage.productDropdown);
       select.selectByVisibleText(productName);

   }


    @When("User enters {string} to quantity")
    public void user_enters_to_quantity(String quality) {
       smartBearPage.quantity.sendKeys(quality);
    }
    @When("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String costumerName) {
        smartBearPage.CustomerName.sendKeys(costumerName);
    }
    @When("User enters {string} to street")
    public void user_enters_to_street(String streetName) {
        smartBearPage.street.sendKeys(streetName);
    }
    @When("User enters {string} to city")
    public void user_enters_to_city(String city) {
       smartBearPage.city.sendKeys(city);
    }
    @When("User enters {string} to state")
    public void user_enters_to_state(String state) {
        smartBearPage.state.sendKeys(state);
    }
    @When("User enters {string}")
    public void user_enters(String zip) {
        smartBearPage.zip.sendKeys(zip);
    }
    @When("User selects Visa as card type")
    public void user_selects_visa_as_card_type() {
       smartBearPage.VisaCardType.click();
    }
    @When("User enters {string} to card number")
    public void user_enters_to_card_number(String cardNumber) {
       smartBearPage.cardNumber.sendKeys(cardNumber);
    }
    @When("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String expireDate) {
        smartBearPage.expDate.sendKeys(expireDate);
    }
    @When("User clicks process button")
    public void user_clicks_process_button() {
      smartBearPage.processButton.click();


    }
    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String name) {
        smartBearPage.viewAllOrders.click();

        Assert.assertEquals(name,smartBearPage.firstCustomerlist.getText());
    }

}
