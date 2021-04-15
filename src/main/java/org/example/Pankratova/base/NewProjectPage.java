package org.example.Pankratova.base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class NewProjectPage extends BasePage{
    WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 5);

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }
    @Step("Заполнение полей нового Клиента")
    public NewProjectPage newProject(String last_name,String first_name, String job){
        // ввод в поле "фамилия"
        sendLastName(last_name);
        // ввод в поле "имя"
        sendFirstName(first_name);
        // Клик на выпадашку "Организация"
        clickOrg();
        // Клик на вариант "Все организации"
        clickAllOgr();
        // ввод в поле "должность"
        sendJob(job);
        // Клик на кнопку "Сохранить и закрыть"
        clickSaveAndClose();
        return this;
    }
    @Step("Ввод данных в поле Фамилия")
    public NewProjectPage sendLastName(String last_name){

        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//input[@name='crm_contact[lastName]']"))));
        driver.findElement(By.xpath(".//input[@name='crm_contact[lastName]']")).sendKeys(last_name);
        return this;
    }
    @Step("Ввод данных в поле Имя")
    public NewProjectPage sendFirstName(String first_name){
        driver.findElement(By.xpath(".//input[@name='crm_contact[firstName]']")).sendKeys(first_name);

        return this;
    }
    @Step("Клик на выпадашку \"Организация\"")
    public NewProjectPage clickOrg(){
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//span[@class='select2-chosen']"))));
        driver.findElement(By.xpath(".//span[@class='select2-chosen']")).click();
        return this;
    }
    @Step("Клик на вариант \"Все организации\"")
    public NewProjectPage clickAllOgr(){
        driver.findElement(By.xpath(".//div[@class='select2-result-label']")).click();
        return this;
    }
    @Step("Ввод данных в поле Должность")
    public NewProjectPage sendJob(String job){
        driver.findElement(By.xpath(".//input[@name='crm_contact[jobTitle]']")).sendKeys(job);
        return this;
    }
    @Step("Клик на кнопку \"Сохранить и закрыть\"")
    public NewProjectPage clickSaveAndClose(){
        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();
        return this;
    }


}
