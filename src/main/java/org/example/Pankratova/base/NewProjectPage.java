package org.example.Pankratova.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class NewProjectPage extends BasePage{

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }
    public NewProjectPage newProject(String last_name,String first_name, String job){
        // ввод в поле "фамилия"

        WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 5);
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//input[@name='crm_contact[lastName]']"))));
        driver.findElement(By.xpath(".//input[@name='crm_contact[lastName]']")).sendKeys(last_name);
        // ввод в поле "имя"
        driver.findElement(By.xpath(".//input[@name='crm_contact[firstName]']")).sendKeys(first_name);
        // Клик на выпадашку "Организация"
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//span[@class='select2-chosen']"))));
        driver.findElement(By.xpath(".//span[@class='select2-chosen']")).click();
        // Клик на вариант "Все организации"
        driver.findElement(By.xpath(".//div[@class='select2-result-label']")).click();
        // ввод в поле "должность"
        driver.findElement(By.xpath(".//input[@name='crm_contact[jobTitle]']")).sendKeys(job);
        // Клик на кнопку "Сохранить и закрыть"
        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();
        return this;
    }


}
