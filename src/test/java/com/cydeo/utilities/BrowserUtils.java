package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void  switchWindowAndVerify(String expectedURL, String expectedTitle){
        Set<String> allHandles = Driver.getDriver().getWindowHandles();
        for (String each : allHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
            System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());
            if(Driver.getDriver().getCurrentUrl().contains(expectedURL)){
                break;
            }
        }
        String actualtitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title Verification failed", actualtitle.contains(expectedTitle));

    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }
    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        List<String> actualOptionsAsString = new ArrayList<>();
        for(WebElement each: actualOptionsAsWebElement){
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }
    public static void switchToWindow(String targetTitle){
        String origin = Driver.getDriver().getWindowHandle();
        for(String handle: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(handle);
            if(Driver.getDriver().getTitle().equals(targetTitle)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
    public static void clickRadioButton(List<WebElement> radioButtons,String attributeValue ){
        for(WebElement each: radioButtons){
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }

}
