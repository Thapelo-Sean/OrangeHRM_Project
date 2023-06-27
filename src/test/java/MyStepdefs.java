import OrangeHRM.DashboardPage;
import OrangeHRM.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.client5.http.HttpResponseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

    public class MyStepdefs
    {
        private final String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        private final String dashboardUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        private final String sendPasswordResetUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset";
        private final String adminUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        private final String pimUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
        private final String leaveUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";
        private final String timeUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet";
        private final String recruitmentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";
        private final String myInfoUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7";
        private final String performanceUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/performance/searchEvaluatePerformanceReview";
        private final String directoryUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/directory/viewDirectory";
        private final String maintenanceUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee";
        private final String buzzUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz";
        private WebDriver driver;
        private LoginPage loginPage;
        private DashboardPage dashboardPage;

        @Before
        public void initBrowser()
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            loginPage = new LoginPage(driver);
            dashboardPage = new DashboardPage(driver);
        }

        @After
        public void tearDown()
        {
            if (driver != null)
            {
                driver.quit();
            }
        }

        @Given("User navigated to the login page")
        public void iNavigatedToTheLoginPage()
        {
            driver.get(baseUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        @When("User enters valid username and password")
        public void iEnterValidUsernameAndPassword()
        {
            loginPage.setUsername("Admin");
            loginPage.setPassword("admin123");
        }

        @And("User clicks the login button")
        public void iClickTheLoginButton()
        {
            loginPage.clickLoginButton();
        }

        @Then("User should be logged in successfully")
        public void iShouldBeLoggedInSuccessfully()
        {
            if (driver.getCurrentUrl().equalsIgnoreCase(dashboardUrl))
            {
                Assert.assertTrue(true);
            } else
            {
                Assert.fail();
            }
        }

        @When("User enters invalid username and password")
        public void iHaveEnteredInvalidUsernameAndPassword()
        {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            loginPage.setUsername("Invalid Username");
            loginPage.setPassword("Invalid Password");
        }

        @Then("User should get an error message")
        public void iShouldGetAnErrorMessage()
        {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).isDisplayed(),true);
        }

        @When("User clicks the forgot password link")
        public void iClickTheForgotPasswordLink()
        {
            loginPage.clickForgotPassword();
        }

        @Then("User should be navigated to the forgot Password page")
        public void iShouldBeNavigatedToTheForgotPasswordPage()
        {
            String forgotPasswordUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
            Assert.assertEquals(driver.getCurrentUrl(), forgotPasswordUrl);
        }

        @And("User enters valid username")
        public void iEnterValidUsername()
        {
            loginPage.setUsername("Admin");
        }

        @And("User clicks the reset password button")
        public void clickTheResetPasswordButton()
        {
            loginPage.clickResetPassword();
        }

        @Then("Reset password link should be sent successfully")
        public void resetPasswordLinkShouldBeSentSuccessfully()
        {
            Assert.assertEquals(driver.getCurrentUrl(),sendPasswordResetUrl);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/h6")).isDisplayed());
        }

        @Given("User navigated to the dashboard page")
        public void userNavigatedToTheDashboardPage()
        {
            driver.get(dashboardUrl);
        }

        @When("User clicks any of the navigation links")
        public void userClicksAnyOfTheNavigationLinks()
        {
            iNavigatedToTheLoginPage();
            iEnterValidUsernameAndPassword();
            iClickTheLoginButton();
            dashboardPage.clickAdminLink();
            dashboardPage.clickDashboardLink();
        }

        @Then("User should not see a {int} error or broken links")
        public void userShouldNotSeeAErrorOrBrokenLinks(int arg0) throws IOException
        {
            List<WebElement> links = driver.findElements(By.tagName("a"));
            int linksSize = links.size();
            System.out.println("Number of links present are: " + linksSize);

            for(int i = 0; i < linksSize; i++)
            {
                WebElement element =links.get(i);
                String url =element.getAttribute("href");
                verifyLinks(url);
            }
        }

        private void verifyLinks(String url) throws IOException
        {
            URL verifyUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)verifyUrl.openConnection();
            httpURLConnection.setConnectTimeout(4000);
            httpURLConnection.connect();

            if(httpURLConnection.getResponseCode() < 400)
            {
                Assert.assertTrue(true);
                System.out.println("No broken links available");
            }
            else
            {
                throw new HttpResponseException(httpURLConnection.getResponseCode(), "Broken link");
            }
        }

        @Then("User should be redirected to the correct page")
        public void userShouldBeRedirectedToTheCorrectPage()
        {
            dashboardPage.clickAdminLink();
            Assert.assertEquals(adminUrl,driver.getCurrentUrl());

            dashboardPage.clickPimLink();
            Assert.assertEquals(pimUrl, driver.getCurrentUrl());

            dashboardPage.clickLeaveLink();
            Assert.assertEquals(leaveUrl, driver.getCurrentUrl());

            dashboardPage.clickTimelink();
            Assert.assertEquals(timeUrl, driver.getCurrentUrl());

            dashboardPage.clickRecruitmentLink();
            System.out.println(driver.getCurrentUrl());
            Assert.assertEquals(recruitmentUrl, driver.getCurrentUrl());

            dashboardPage.clickMyInfoLink();
            Assert.assertEquals(myInfoUrl, driver.getCurrentUrl());

            dashboardPage.clickPerformanceLink();
            Assert.assertEquals(performanceUrl, driver.getCurrentUrl());

            dashboardPage.clickDashboardLink();
            Assert.assertEquals(dashboardUrl, driver.getCurrentUrl());

            dashboardPage.clickDirectoryLink();
            Assert.assertEquals(directoryUrl, driver.getCurrentUrl());

            dashboardPage.clickMaintenanceLink();
            Assert.assertEquals(maintenanceUrl, driver.getCurrentUrl());
            driver.navigate().to(dashboardUrl);

            dashboardPage.clickBuzzLink();
            Assert.assertEquals(buzzUrl, driver.getCurrentUrl());
        }
    }