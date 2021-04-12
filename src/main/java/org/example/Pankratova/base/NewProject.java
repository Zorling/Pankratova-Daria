package org.example.Pankratova.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewProject extends BasePage{
    public NewProject(WebDriver driver) {
        super(driver);
    }
    public NewProject createProject(String field_name,String company,String project_priority, String finance_source, String business_unit, String field_curator,String field_administrator, String field_manager, String field_contacts){
        // Нажатие на поле ввода текста "Наименование"
        wait5second.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//input[@name=\"crm_project[name]\"]"))));
        driver.findElement(By.xpath(".//input[@name=\"crm_project[name]\"]")).click();
        driver.findElement(By.xpath(".//input[@data-name=\"field__name\"]")).sendKeys(field_name);
        driver.findElement(By.xpath(".//div[@class=\"company-container\"]")).click();
        driver.findElement(By.xpath(".//span [@class= \"select2-chosen\"]")).click();
        // Укажите организацию


        driver.findElement(By.xpath(".//*[@id=\"select2-drop\"]/div/input")).sendKeys(company);
        driver.findElement(By.xpath(".//*[@id=\"select2-drop\"]/ul[2]/li/div")).click();
        driver.findElement(By.xpath(".//select[@data-name='field__priority']")).click();
        // Выбор приоритета

        Select ProjectPriorityDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__priority']")));
        ProjectPriorityDropDown.selectByValue(project_priority);
        driver.findElement(By.xpath(".//select[@data-name='field__priority']")).click();
        driver.findElement(By.xpath(".//select[@data-name='field__finance-source']")).click();
        // Выбор типа Финансирования
        Select FinanceSourceDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__finance-source']")));
        FinanceSourceDropDown.selectByValue(finance_source);
        driver.findElement(By.xpath(".//select[@data-name='field__business-unit']")).click();
        //driver.findElement(By.xpath(".//select[@data-name='field__curator']")).click();
        Select BusinessUnitDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__business-unit']")));
        BusinessUnitDropDown.selectByVisibleText(business_unit);
        driver.findElement(By.xpath(".//select[@data-name='field__curator']")).click();
        // Выбор Куратора проекта
        Select FieldCuratorDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__curator']")));
        FieldCuratorDropDown.selectByVisibleText(field_curator);
        driver.findElement(By.xpath(".//select[@data-name='field__rp']")).click();
        // Выбор руководителя проекта
        Select businessUnitDropDown55 = new Select(driver.findElement(By.xpath(".//select[@data-name='field__rp']")));
        businessUnitDropDown55.selectByVisibleText("Applanatest Applanatest Applanatest");
        driver.findElement(By.xpath(".//select[@data-name='field__administrator']")).click();
        // Выбор администратора проекта
        Select FieldAdministratorDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__administrator']")));
        FieldAdministratorDropDown.selectByVisibleText(field_administrator);
        driver.findElement(By.xpath(".//select[@data-name='field__manager']")).click();
        // Выбор Менеджера
        Select FieldManagerDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__manager']")));
        FieldManagerDropDown.selectByVisibleText(field_manager);
        driver.findElement(By.xpath("./html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[4]/div[1]/div[2]/div")).click();
        wait5second.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//select[@data-name='field__contact-main']"))));
        // Основное контактное лицо
        Select FieldContactsDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__contact-main']")));
        FieldContactsDropDown.selectByVisibleText(field_contacts);
        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();
        // Проверка наличия названия Все Проекты
        wait5second.until(ExpectedConditions.titleContains("Все - Проекты - Все проекты - Проекты"));





        return this;
    }

}
