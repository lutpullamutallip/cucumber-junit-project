package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DataTableTaskStepDefinitions {

    Select select;

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> months) {
        select = new Select(Driver.getDriver().findElement(By.id("month")));
        List<WebElement> list = select.getOptions();
        List<String> list2 = new ArrayList<>();
        for(WebElement each: list){
          list2.add(each.getText());
        }

        Assert.assertTrue(list2.equals(months));

    }
}
