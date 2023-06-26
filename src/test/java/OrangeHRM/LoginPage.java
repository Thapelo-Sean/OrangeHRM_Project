package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locate elements
    private By usernameInputLocator = By.name("username");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    private By forgotPasswordLocator = By.linkText("Forgot Password");

    //Methods
    public void setUsername(String stringUsername)
    {
        WebElement username = driver.findElement(usernameInputLocator);
        username.clear();
        username.sendKeys(stringUsername);
    }

    public void setPassword(String stringPassword)
    {
        WebElement password = driver.findElement(passwordInputLocator);
        password.clear();
        password.sendKeys(stringPassword);
    }

    public void clickLoginButton()
    {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void clickForgotPassword()
    {
        WebElement forgotPassword = driver.findElement(forgotPasswordLocator);
        forgotPassword.click();
    }
}