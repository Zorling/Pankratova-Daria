package org.example.Pankratova.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {
    // задаем локатор логина

    private WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
    // задаем локатор

    private WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
    // задаем локатор

    private WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));

    //создали конструктор
    public AuthorizationPage(WebDriver driver){
        super(driver);
    }
    //метод ввода логина

    public AuthorizationPage enterLogin(String login){
        loginTextInput.sendKeys(login);
        return this;
    }
    //метод ввода пароля

    public AuthorizationPage enterPassword(String password){
        passwordTextInput.sendKeys(password);
        return this;
    }
    //метод нажатия на кнопку Войти

    public AuthorizationPage clickLoginButton(){
        loginButton.click();
        return this;
    }
    public  ProjectPage login (String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickLoginButton();
        return new  ProjectPage(driver);

    }
    public  MenuProject login2 (String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickLoginButton();
        return new MenuProject(driver);

    }

}
