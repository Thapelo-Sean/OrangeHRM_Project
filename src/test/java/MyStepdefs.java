import OrangeHRM.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private String dashboardUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    @Before
    public void initBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

    @Given("I navigated to the login page")
    public void iNavigatedToTheLoginPage()
    {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword()
    {
        loginPage.setUsername("Admin");
        loginPage.setPassword("admin123");
    }

    @And("I click the login button")
    public void iClickTheLoginButton()
    {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully()
    {
        if(driver.getCurrentUrl().equalsIgnoreCase(dashboardUrl))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.fail();
        }
    }
}