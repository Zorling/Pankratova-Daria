package CrmTest.AutoTest.base;

import CrmTest.AutoTest.base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.Pankratova.base.AuthorizationPage;
import org.example.Pankratova.base.CustomLogger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static CrmTest.AutoTest.common.Configuration.*;

public class StartTest extends BaseTest {
    @Feature("Позитивный тест Авторизация")
    @Test
    public void loginTest(){
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.login(LOGIN,PASSWORD);

    }
    @Feature("Позитивный тест Авторизация")
    @Severity(SeverityLevel.BLOCKER)
    //Тест авторизации
    @Test
    public void loginWithBaseUserTest() {
        EventFiringWebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // Конфигурирование логгирования драйвера через интерфейс RemoteWebDriver
        RemoteWebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.setLogLevel(Level.INFO);
        // ----------------------------------------------------------------------

        // Обертка драйвера в EventFiringWebDriver, умеющего регистрировать кастомные листнеры
        driver = new EventFiringWebDriver(chromeDriver);
        driver.register(new CustomLogger());
        // ----------------------------------------------------------------------

        // Остальная часть может быть использована без изменений
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_URL);


        new AuthorizationPage(driver)

                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickLoginButton();

    }
    @Feature("Позитивный тест Создание нового Контакта")
    @Severity(SeverityLevel.CRITICAL)
    //Тест создания нового контакта
    @Test
    public void ContactTest() {
        EventFiringWebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // Конфигурирование логгирования драйвера через интерфейс RemoteWebDriver
        RemoteWebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.setLogLevel(Level.INFO);
        // ----------------------------------------------------------------------

        // Обертка драйвера в EventFiringWebDriver, умеющего регистрировать кастомные листнеры
        driver = new EventFiringWebDriver(chromeDriver);
        driver.register(new CustomLogger());
        // ----------------------------------------------------------------------

        // Остальная часть может быть использована без изменений
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_URL);


        new AuthorizationPage(driver)
                .login(LOGIN,PASSWORD)
                .click()
                .newProject(FIRST_NAME,LAST_NAME,JOB);
    }
    //Тест создания нового проекта
    @Feature("Позитивный тест Создание нового проекта")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void ProjectTest() {
        EventFiringWebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // Конфигурирование логгирования драйвера через интерфейс RemoteWebDriver
        RemoteWebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.setLogLevel(Level.INFO);
        // ----------------------------------------------------------------------

        // Обертка драйвера в EventFiringWebDriver, умеющего регистрировать кастомные листнеры
        driver = new EventFiringWebDriver(chromeDriver);
        driver.register(new CustomLogger());
        // ----------------------------------------------------------------------

        // Остальная часть может быть использована без изменений
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_URL);


        new AuthorizationPage(driver)
                .login2(LOGIN,PASSWORD)
                .menu()
                .createProject(FIELD_NAME,COMPANY,PROJECT_PRIORITY,FINANCE_SOURCE,BUSINESS_UNIT,FIELD_CURATOR,FIELD_ADMINISTRATOR,FIELD_MANAGER,FIELD_CONTACTS);
    }






    }
