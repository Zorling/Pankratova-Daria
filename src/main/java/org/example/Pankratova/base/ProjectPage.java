package org.example.Pankratova.base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {



    public ProjectPage(WebDriver driver) {
        super(driver);
    }
    @Step("Открытие меню контакты и нажатие на кнопку Новый контакт")
    public NewProjectPage click (){
        // Клик на кнопку "Проекты"
        clickProject();
        // Клик на выпадашку "Мои проекты"
        clickMyProject();
        return new NewProjectPage(driver);

    }
    @Step("Клик на кнопку \"Проекты\"")
    public ProjectPage clickProject(){
        driver.findElement(By.xpath(
                ".//li[@class='dropdown first']")).click();
        return this;
    }
    @Step("Клик на выпадашку \"Мои проекты\"")
    public ProjectPage clickMyProject(){
        driver.findElement(By.xpath(".//li[@data-route='crm_contact_index']/a")).click();
        driver.findElement(By.xpath(".//div[@class='pull-left btn-group icons-holder']/a")).click();
        return this;
    }
}
