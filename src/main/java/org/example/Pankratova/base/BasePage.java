package org.example.Pankratova.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait5second;
    protected WebDriverWait wait30second;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait5second = new WebDriverWait(driver, 5);
        //this.wait30second = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
}
