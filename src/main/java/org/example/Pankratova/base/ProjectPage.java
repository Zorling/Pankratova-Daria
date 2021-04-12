package org.example.Pankratova.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {



    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public NewProjectPage click (){
        // Клик на кнопку "Проекты"
        driver.findElement(By.xpath(
                ".//li[@class='dropdown first']")).click();
        // Клик на выпадашку "Мои проекты"
        driver.findElement(By.xpath(".//li[@data-route='crm_contact_index']/a")).click();
        driver.findElement(By.xpath(".//div[@class='pull-left btn-group icons-holder']/a")).click();
        return new NewProjectPage(driver);

    }
}
