package CrmTest.AutoTest.base;

import CrmTest.AutoTest.base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Pankratova.base.AuthorizationPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static CrmTest.AutoTest.common.Configuration.*;

public class StartTest extends BaseTest {
    @Test
    public void loginTest(){
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.login(LOGIN,PASSWORD);

    }
    //Тест авторизации
    @Test
    public void loginWithBaseUserTest() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASE_URL+LOGIN_URL);

        new AuthorizationPage(driver)

                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickLoginButton();

    }
    //Тест создания нового контакта
    @Test
    public void ContactTest() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_URL);

        new AuthorizationPage(driver)
                .login(LOGIN,PASSWORD)
                .click()
                .newProject(FIRST_NAME,LAST_NAME,JOB);
    }
    //Тест создания нового проекта
    @Test
    public void ProjectTest() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_URL);

        new AuthorizationPage(driver)
                .login2(LOGIN,PASSWORD)
                .menu()
                .createProject(FIELD_NAME,COMPANY,PROJECT_PRIORITY,FINANCE_SOURCE,BUSINESS_UNIT,FIELD_CURATOR,FIELD_ADMINISTRATOR,FIELD_MANAGER,FIELD_CONTACTS);
    }






    }
