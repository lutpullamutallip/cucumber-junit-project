package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataTablesTaskPage {
    public DataTablesTaskPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
