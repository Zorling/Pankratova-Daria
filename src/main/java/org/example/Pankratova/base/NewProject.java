package org.example.Pankratova.base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewProject extends BasePage{
    public NewProject(WebDriver driver) {
        super(driver);
    }
    @Step("Заполнение полей На вкладке Новый проект")
    public NewProject createProject(String field_name,String company,String project_priority, String finance_source, String business_unit, String field_curator,String field_administrator, String field_manager, String field_contacts){
        // Нажатие на поле ввода текста "Наименование"
        sendName(field_name);
        // Укажите организацию
        sendCompany(company);
        // Выбор приоритета
        sendProjectPriority(project_priority);
        // Выбор типа Финансирования
        sendFinanceSource(finance_source);
        //driver.findElement(By.xpath(".//select[@data-name='field__curator']")).click();
        // Выбор из списка Бизнес Юнит
        sendBusinessUnit(business_unit);
        // Выбор Куратора проекта
        sendFieldCurator(field_curator);
        // Выбор руководителя проекта
        sendFieldAdministrator();
        // Выбор администратора проекта
        sendFieldAdministrator(field_administrator);
        // Выбор Менеджера
        sendFieldManager(field_manager);
        // Основное контактное лицо
        sendFieldContacts(field_contacts);
        // Проверка наличия названия Все Проекты
        titleContains();





        return this;
    }
    @Step("Заполнение поля Организация")
    public NewProject sendCompany(String company){
        driver.findElement(By.xpath(".//*[@id=\"select2-drop\"]/div/input")).sendKeys(company);
        driver.findElement(By.xpath(".//*[@id=\"select2-drop\"]/ul[2]/li/div")).click();
        driver.findElement(By.xpath(".//select[@data-name='field__priority']")).click();
        return this;
    }
    @Step("Заполнение поля Наименование")
    public NewProject sendName(String field_name){
        wait5second.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//input[@name=\"crm_project[name]\"]"))));
        driver.findElement(By.xpath(".//input[@name=\"crm_project[name]\"]")).click();
        driver.findElement(By.xpath(".//input[@data-name=\"field__name\"]")).sendKeys(field_name);
        driver.findElement(By.xpath(".//div[@class=\"company-container\"]")).click();
        driver.findElement(By.xpath(".//span [@class= \"select2-chosen\"]")).click();
        return this;
    }

    @Step("Заполнение поля Выбор приоритета")
    public NewProject sendProjectPriority(String project_priority){
        Select ProjectPriorityDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__priority']")));
        ProjectPriorityDropDown.selectByValue(project_priority);
        driver.findElement(By.xpath(".//select[@data-name='field__priority']")).click();
        driver.findElement(By.xpath(".//select[@data-name='field__finance-source']")).click();
        return this;
    }
    @Step("Заполнение поля Тип финансирования")
    public NewProject sendFinanceSource(String finance_source){
        Select FinanceSourceDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__finance-source']")));
        FinanceSourceDropDown.selectByValue(finance_source);
        driver.findElement(By.xpath(".//select[@data-name='field__business-unit']")).click();
        return this;
    }
    @Step("Выбор из списка Бизнес юнит")
    public NewProject sendBusinessUnit(String business_unit){
        Select BusinessUnitDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__business-unit']")));
        BusinessUnitDropDown.selectByVisibleText(business_unit);
        return this;
    }
    @Step("Выбор из списка Куратор проекта")
    public NewProject sendFieldCurator(String field_curator){
        driver.findElement(By.xpath(".//select[@data-name='field__curator']")).click();

        Select FieldCuratorDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__curator']")));
        FieldCuratorDropDown.selectByVisibleText(field_curator);
        driver.findElement(By.xpath(".//select[@data-name='field__rp']")).click();
        return this;
    }
    @Step("Выбор из списка Руководителя проекта")
    public NewProject sendFieldAdministrator(){
        Select businessUnitDropDown55 = new Select(driver.findElement(By.xpath(".//select[@data-name='field__rp']")));
        businessUnitDropDown55.selectByVisibleText("Applanatest Applanatest Applanatest");
        driver.findElement(By.xpath(".//select[@data-name='field__administrator']")).click();
        return this;
    }
    @Step("Выбор из списка Администратора проекта")
    public NewProject sendFieldAdministrator(String field_administrator){
        Select FieldAdministratorDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__administrator']")));
        FieldAdministratorDropDown.selectByVisibleText(field_administrator);
        driver.findElement(By.xpath(".//select[@data-name='field__manager']")).click();
        return this;
    }
    @Step("Выбор из списка Менеджер проекта")
    public NewProject sendFieldManager(String field_manager){
        Select FieldManagerDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__manager']")));
        FieldManagerDropDown.selectByVisibleText(field_manager);
        driver.findElement(By.xpath("./html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[4]/div[1]/div[2]/div")).click();
        wait5second.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//select[@data-name='field__contact-main']"))));
        return this;
    }
    @Step("Выбор из списка Основное контактное лицо")
    public NewProject sendFieldContacts(String field_contacts){
        Select FieldContactsDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__contact-main']")));
        FieldContactsDropDown.selectByVisibleText(field_contacts);
        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();
        return this;
    }
    @Step("Проверка наличия названия Все Проекты")
    public NewProject titleContains(){
        wait5second.until(ExpectedConditions.titleContains("Все - Проекты - Все проекты - Проекты"));
        return this;
    }





}
