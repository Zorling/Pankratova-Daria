package CrmTest.AutoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Test01 {



        private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
        private static final String STUDENT_LOGIN = "Applanatest";
        private static final String STUDENT_PASSWORD = "Student2020!";
        private static final String LAST_NAME = "Иванов";
        private static final String FIRST_NAME = "Иван";
        private static final String JOB = "Рабочий";

    private static final String FIELD_NAME = "Наименование22341wqr4";
    private static final String COMPANY = "1234";
    private static final String PROJECT_PRIORITY = "1";
    private static final String FINANCE_SOURCE = "3";
    private static final String BUSINESS_UNIT = "Research & Development";
    private static final String FIELD_CURATOR = "Applanatest Applanatest Applanatest";
    private static final String FIELD_ADMINISTRATOR = "Амелина Светлана";
    private static final String FIELD_MANAGER = "Антонов Дмитрий";
    private static final String FIELD_CONTACTS = "Almun Alex";

        private static WebDriver driver;
        // @FindBy(css = "input[id='prependedInput']")
        //private static WebElement inputLogin;
        @Test
        @DisplayName("Создание контактного лица")



        public void test01(){
            WebDriverManager.chromedriver().setup();


            // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
            ChromeOptions options = new ChromeOptions();

            // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
//        options.addArguments("--headless");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            driver.get(LOGIN_PAGE_URL);

            // Заполнение поля Логин

            WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));

            loginTextInput.sendKeys(STUDENT_LOGIN);

            //Проверка корректности заполнения поля Логин
            String login = driver.findElement(By.cssSelector("input[id='prependedInput']")).getAttribute("value");
            Assertions.assertEquals(login,STUDENT_LOGIN);



            // Заполнение поля Пароль
            WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
            passwordTextInput.sendKeys(STUDENT_PASSWORD);

            //Проверка корректности заполнения поля Пароль
            String password = driver.findElement(By.cssSelector(".span2[name='_password']")).getAttribute("value");
            Assertions.assertEquals(password,STUDENT_PASSWORD);


            // Нажатие на кнопку Логин
            WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
            loginButton.click();





            // Клик на кнопку "Проекты"
            driver.findElement(By.xpath(
                    ".//li[@class='dropdown first']")).click();
            // Клик на выпадашку "Мои проекты"
            driver.findElement(By.xpath(".//li[@data-route='crm_contact_index']/a")).click();
            driver.findElement(By.xpath(".//div[@class='pull-left btn-group icons-holder']/a")).click();
            // ввод в поле "фамилия"

            WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 5);
            waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                    ".//input[@name='crm_contact[lastName]']"))));
            driver.findElement(By.xpath(".//input[@name='crm_contact[lastName]']")).sendKeys(LAST_NAME);
            //Проверка корректности заполнения поля Фамилия
            String lastName = driver.findElement(By.xpath(".//input[@name='crm_contact[lastName]']")).getAttribute("value");
            Assertions.assertEquals(lastName,LAST_NAME);
            // ввод в поле "имя"
            driver.findElement(By.xpath(".//input[@name='crm_contact[firstName]']")).sendKeys(FIRST_NAME);

            //Проверка корректности заполнения поля Имя
            String name = driver.findElement(By.xpath(".//input[@name='crm_contact[firstName]']")).getAttribute("value");
            Assertions.assertEquals(name,FIRST_NAME);
            // Клик на выпадашку "Организация"
            waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                    ".//span[@class='select2-chosen']"))));
            driver.findElement(By.xpath(".//span[@class='select2-chosen']")).click();
            // Клик на вариант "Все организации"
            driver.findElement(By.xpath(".//div[@class='select2-result-label']")).click();
            // ввод в поле "должность"
            driver.findElement(By.xpath(".//input[@name='crm_contact[jobTitle]']")).sendKeys(JOB);
            //Проверка корректности заполнения поля Должность
            String job = driver.findElement(By.xpath(".//input[@name='crm_contact[jobTitle]']")).getAttribute("value");
            Assertions.assertEquals(job,JOB);
            // Клик на кнопку "Сохранить и закрыть"
            driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();




            driver.quit();

        }

    @Test
    @DisplayName("Заполняем поле Логин")
    public void test02(){
        WebDriverManager.chromedriver().setup();

        // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();

        // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(LOGIN_PAGE_URL);

        // Заполнение поля Логин

        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));

        loginTextInput.sendKeys(STUDENT_LOGIN);

        //Проверка корректности заполнения поля Логин
        String login = driver.findElement(By.cssSelector("input[id='prependedInput']")).getAttribute("value");
        Assertions.assertEquals(login,STUDENT_LOGIN);



        // Заполнение поля Пароль
        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        //Проверка корректности заполнения поля Пароль
        String password = driver.findElement(By.cssSelector(".span2[name='_password']")).getAttribute("value");
        Assertions.assertEquals(password,STUDENT_PASSWORD);


        // Нажатие на кнопку Логин
        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();


        //наш код-----
        // Клик на кнопку "Проекты"
        driver.findElement(By.xpath(".//div[@id=\"main-menu\"]/ul/li[@class=\"dropdown\"]/a")).click();
        // Клик на выпадашку "Мои проекты"
        driver.findElement(By.xpath(".//li[@data-routes='[\"\\/^crm_project_my\\/\"]']/a")).click();

        WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 5);
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//a[@title=\"Создать проект\"]"))));
        driver.findElement(By.xpath(".//a[@title=\"Создать проект\"]")).click();
        // Нажатие на поле ввода текста "Наименование"
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//input[@name=\"crm_project[name]\"]"))));
        driver.findElement(By.xpath(".//input[@name=\"crm_project[name]\"]")).click();
        driver.findElement(By.xpath(".//input[@data-name=\"field__name\"]")).sendKeys(FIELD_NAME);
        //Проверка корректности заполнения поля Наименование
        String name = driver.findElement(By.xpath(".//input[@data-name=\"field__name\"]")).getAttribute("value");
        Assertions.assertEquals(name,FIELD_NAME);

        driver.findElement(By.xpath(".//div[@class=\"company-container\"]")).click();
        driver.findElement(By.xpath(".//span [@class= \"select2-chosen\"]")).click();
        // Укажите организацию


        driver.findElement(By.xpath(".//*[@id=\"select2-drop\"]/div/input")).sendKeys(COMPANY);
        //Проверка корректности заполнения поля Организация
        String company = driver.findElement(By.xpath(".//*[@id=\"select2-drop\"]/div/input")).getAttribute("value");
        Assertions.assertEquals(company,COMPANY);
        driver.findElement(By.xpath(".//*[@id=\"select2-drop\"]/ul[2]/li/div")).click();
        driver.findElement(By.xpath(".//select[@data-name='field__priority']")).click();
        // Выбор приоритета

        Select ProjectPriorityDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__priority']")));
        ProjectPriorityDropDown.selectByValue(PROJECT_PRIORITY);

        driver.findElement(By.xpath(".//select[@data-name='field__priority']")).click();
        //Проверка корректности заполнения поля Приоритет
        String priority = driver.findElement(By.xpath(".//select[@data-name='field__priority']")).getAttribute("value");
        Assertions.assertEquals(priority,PROJECT_PRIORITY);
        // Выбор типа Финансирования
        driver.findElement(By.xpath(".//select[@data-name='field__finance-source']")).click();
        Select FinanceSourceDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__finance-source']")));
        FinanceSourceDropDown.selectByValue(FINANCE_SOURCE);
        //Проверка корректности заполнения поля Финансирование
        String source = driver.findElement(By.xpath(".//select[@data-name='field__finance-source']")).getAttribute("value");
        Assertions.assertEquals(source,FINANCE_SOURCE);
        // Выбор  бизнес партнера
        driver.findElement(By.xpath(".//select[@data-name='field__business-unit']")).click();
        Select BusinessUnitDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__business-unit']")));
        BusinessUnitDropDown.selectByVisibleText(BUSINESS_UNIT);
        //Проверка корректности заполнения поля бизнес партнер
        String unit = driver.findElement(By.xpath(".//select[@data-name='field__business-unit']")).getAttribute("value");
        Assertions.assertEquals(unit,"1");
        // Выбор Куратора проекта
        driver.findElement(By.xpath(".//select[@data-name='field__curator']")).click();

        Select FieldCuratorDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__curator']")));
        FieldCuratorDropDown.selectByVisibleText(FIELD_CURATOR);
        //Проверка корректности заполнения поля Куратор проекта
        String curator = driver.findElement(By.xpath(".//select[@data-name='field__curator']")).getAttribute("value");
        Assertions.assertEquals(curator,"115");
        // Выбор руководителя проекта
        driver.findElement(By.xpath(".//select[@data-name='field__rp']")).click();

        Select businessUnitDropDown55 = new Select(driver.findElement(By.xpath(".//select[@data-name='field__rp']")));
        businessUnitDropDown55.selectByVisibleText("Applanatest Applanatest Applanatest");
        //Проверка корректности заполнения поля Руководитель проекта
        String rp = driver.findElement(By.xpath(".//select[@data-name='field__rp']")).getAttribute("value");
        Assertions.assertEquals(rp,"115");
        driver.findElement(By.xpath(".//select[@data-name='field__administrator']")).click();
        // Выбор администратора проекта
        Select FieldAdministratorDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__administrator']")));
        FieldAdministratorDropDown.selectByVisibleText(FIELD_ADMINISTRATOR);
        driver.findElement(By.xpath(".//select[@data-name='field__manager']")).click();
        //Проверка корректности заполнения поля Администратор
        String admin = driver.findElement(By.xpath(".//select[@data-name='field__administrator']")).getAttribute("value");
        Assertions.assertEquals(admin,"6");
        // Выбор Менеджера
        Select FieldManagerDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__manager']")));
        FieldManagerDropDown.selectByVisibleText(FIELD_MANAGER);
        driver.findElement(By.xpath("./html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[4]/div[1]/div[2]/div")).click();
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//select[@data-name='field__contact-main']"))));
        // Основное контактное лицо
        Select FieldContactsDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__contact-main']")));
        FieldContactsDropDown.selectByVisibleText(FIELD_CONTACTS);
        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();
        // Проверка наличия названия Все Проекты
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Все - Проекты - Все проекты - Проекты"));





        driver.quit();
    }





}
