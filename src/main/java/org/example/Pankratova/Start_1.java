package CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Start_1 {


    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static final String LAST_NAME = "Иванов";
    private static final String FIRST_NAME = "Иван";
    private static final String JOB = "Рабочий";

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
        driver.findElement(By.xpath(
                ".//li[@class='dropdown first']")).click();
        // Клик на выпадашку "Мои проекты"
        driver.findElement(By.xpath(".//li[@data-route='crm_contact_index']/a")).click();
        driver.findElement(By.xpath(".//div[@class='pull-left btn-group icons-holder']/a")).click();
        // ввод в поле "фамилия"
        sleep(2000);
        WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 5);
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//input[@name='crm_contact[lastName]']"))));
        driver.findElement(By.xpath(".//input[@name='crm_contact[lastName]']")).sendKeys(LAST_NAME);
        // ввод в поле "имя"
        driver.findElement(By.xpath(".//input[@name='crm_contact[firstName]']")).sendKeys(FIRST_NAME);
        // Клик на выпадашку "Организация"
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                ".//span[@class='select2-chosen']"))));
        driver.findElement(By.xpath(".//span[@class='select2-chosen']")).click();
        // Клик на вариант "Все организации"
        driver.findElement(By.xpath(".//div[@class='select2-result-label']")).click();
        // ввод в поле "должность"
        driver.findElement(By.xpath(".//input[@name='crm_contact[jobTitle]']")).sendKeys(JOB);
        // Клик на кнопку "Сохранить и закрыть"
        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();




        driver.quit();
    }
}
