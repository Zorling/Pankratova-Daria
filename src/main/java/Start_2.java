import io.github.bonigarcia.wdm.WebDriverManager;
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

public class Start_2 {


    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
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

    public static void main(String[] args) throws InterruptedException {
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

        // используем имя тега
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);


        // используем имя класса
        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);


        // используя xpath
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
        driver.findElement(By.xpath(".//div[@class=\"company-container\"]")).click();
        driver.findElement(By.xpath(".//span [@class= \"select2-chosen\"]")).click();
        // Укажите организацию


        driver.findElement(By.xpath(".//*[@id=\"select2-drop\"]/div/input")).sendKeys(COMPANY);
        driver.findElement(By.xpath(".//*[@id=\"select2-drop\"]/ul[2]/li/div")).click();
        driver.findElement(By.xpath(".//select[@data-name='field__priority']")).click();
        // Выбор приоритета

        Select ProjectPriorityDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__priority']")));
        ProjectPriorityDropDown.selectByValue(PROJECT_PRIORITY);
        driver.findElement(By.xpath(".//select[@data-name='field__priority']")).click();
        driver.findElement(By.xpath(".//select[@data-name='field__finance-source']")).click();
        // Выбор типа Финансирования
        Select FinanceSourceDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__finance-source']")));
        FinanceSourceDropDown.selectByValue(FINANCE_SOURCE);
        driver.findElement(By.xpath(".//select[@data-name='field__business-unit']")).click();
        //driver.findElement(By.xpath(".//select[@data-name='field__curator']")).click();
        Select BusinessUnitDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__business-unit']")));
        BusinessUnitDropDown.selectByVisibleText(BUSINESS_UNIT);
        driver.findElement(By.xpath(".//select[@data-name='field__curator']")).click();
        // Выбор Куратора проекта
        Select FieldCuratorDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__curator']")));
        FieldCuratorDropDown.selectByVisibleText(FIELD_CURATOR);
        driver.findElement(By.xpath(".//select[@data-name='field__rp']")).click();
        // Выбор руководителя проекта
        Select businessUnitDropDown55 = new Select(driver.findElement(By.xpath(".//select[@data-name='field__rp']")));
        businessUnitDropDown55.selectByVisibleText("Applanatest Applanatest Applanatest");
        driver.findElement(By.xpath(".//select[@data-name='field__administrator']")).click();
        // Выбор администратора проекта
        Select FieldAdministratorDropDown = new Select(driver.findElement(By.xpath(".//select[@data-name='field__administrator']")));
        FieldAdministratorDropDown.selectByVisibleText(FIELD_ADMINISTRATOR);
        driver.findElement(By.xpath(".//select[@data-name='field__manager']")).click();
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
