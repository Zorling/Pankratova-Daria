package org.example.Pankratova.base;

import com.sun.webkit.dom.MouseEventImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuProject extends BasePage{

    public MenuProject(WebDriver driver) {
        super(driver);
    }
    public NewProject menu(){
        driver.findElement(By.xpath(".//div[@id=\"main-menu\"]/ul/li[@class=\"dropdown\"]/a")).click();
        // Клик на выпадашку "Мои проекты"
        driver.findElement(By.xpath(".//li[@data-routes='[\"\\/^crm_project_my\\/\"]']/a")).click();
        WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 5);
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//a[@title=\"Создать проект\"]"))));
        driver.findElement(By.xpath(".//a[@title=\"Создать проект\"]")).click();

        return new NewProject(driver);
    }

}
