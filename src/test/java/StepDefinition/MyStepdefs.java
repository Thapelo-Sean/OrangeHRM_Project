package StepDefinition;

import Pages.DashboardPage;
import Pages.LoginPage;
import Routes.TestUrls;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.client.HttpResponseException;
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
        private WebDriver driver;
        private LoginPage loginPage;
        private DashboardPage dashboardPage;
        TestUrls urls = new TestUrls();

        @Before
        public void initBrowser()
        {
            try
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                loginPage = new LoginPage(driver);
                dashboardPage = new DashboardPage(driver);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @After
        public void tearDown()
        {
            try
            {
                if (driver != null)
                {
                    driver.quit();
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Given("User navigated to the login page")
        public void iNavigatedToTheLoginPage()
        {
            try
            {
                driver.get(urls.baseUrl);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @When("User enters valid username and password")
        public void iEnterValidUsernameAndPassword()
        {
            try
            {
                loginPage.setUsername("Admin");
                loginPage.setPassword("admin123");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @And("User clicks the login button")
        public void iClickTheLoginButton()
        {
            try
            {
                loginPage.clickLoginButton();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        @Then("User should be logged in successfully")
        public void UserShouldBeLoggedInSuccessfully()
        {
            try
            {
                if (driver.getCurrentUrl().equalsIgnoreCase(urls.dashboardUrl))
                {
                    Assert.assertTrue(true);
                } else
                {
                    Assert.fail();
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @When("User enters invalid username and password")
        public void iHaveEnteredInvalidUsernameAndPassword()
        {
            try
            {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                loginPage.setUsername("Invalid Username");
                loginPage.setPassword("Invalid Password");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Then("User should get an error message")
        public void iShouldGetAnErrorMessage()
        {
            try
            {
                Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).isDisplayed(),true);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @When("User clicks the forgot password link")
        public void iClickTheForgotPasswordLink()
        {
            try
            {
                loginPage.clickForgotPassword();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Then("User should be navigated to the forgot Password page")
        public void iShouldBeNavigatedToTheForgotPasswordPage()
        {
            try
            {
                String forgotPasswordUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
                Assert.assertEquals(driver.getCurrentUrl(), forgotPasswordUrl);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @And("User enters valid username")
        public void iEnterValidUsername()
        {
            try
            {
                loginPage.setUsername("Admin");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @And("User clicks the reset password button")
        public void clickTheResetPasswordButton()
        {
            try
            {
                loginPage.clickResetPassword();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Then("Reset password link should be sent successfully")
        public void resetPasswordLinkShouldBeSentSuccessfully()
        {
            try
            {
                Assert.assertEquals(driver.getCurrentUrl(),urls.sendPasswordResetUrl);
                Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/h6")).isDisplayed());
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Given("User navigated to the dashboard page")
        public void userNavigatedToTheDashboardPage()
        {
            try
            {
                driver.get(urls.dashboardUrl);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @When("User clicks any of the navigation links")
        public void userClicksAnyOfTheNavigationLinks()
        {
            try
            {
                iNavigatedToTheLoginPage();
                iEnterValidUsernameAndPassword();
                iClickTheLoginButton();
                dashboardPage.clickAdminLink();
                dashboardPage.clickDashboardLink();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Then("User should not see a {int} error or broken links")
        public void userShouldNotSeeAErrorOrBrokenLinks(int arg0) throws IOException
        {
            try
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
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        private void verifyLinks(String url) throws IOException
        {
            try
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
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        @Then("User should be redirected to the correct page")
        public void userShouldBeRedirectedToTheCorrectPage()
        {
            try
            {
                dashboardPage.clickAdminLink();
                Assert.assertEquals(urls.adminUrl,driver.getCurrentUrl());

                dashboardPage.clickPimLink();
                Assert.assertEquals(urls.pimUrl, driver.getCurrentUrl());

                dashboardPage.clickLeaveLink();
                Assert.assertEquals(urls.leaveUrl, driver.getCurrentUrl());

                dashboardPage.clickTimelink();
                Assert.assertEquals(urls.timeUrl, driver.getCurrentUrl());

                dashboardPage.clickRecruitmentLink();
                Assert.assertEquals(urls.recruitmentUrl, driver.getCurrentUrl());

                dashboardPage.clickMyInfoLink();
                Assert.assertEquals(urls.myInfoUrl, driver.getCurrentUrl());

                dashboardPage.clickPerformanceLink();
                Assert.assertEquals(urls.performanceUrl, driver.getCurrentUrl());

                dashboardPage.clickDashboardLink();
                Assert.assertEquals(urls.dashboardUrl, driver.getCurrentUrl());

                dashboardPage.clickDirectoryLink();
                Assert.assertEquals(urls.directoryUrl, driver.getCurrentUrl());

                dashboardPage.clickMaintenanceLink();
                Assert.assertEquals(urls.maintenanceUrl, driver.getCurrentUrl());
                driver.navigate().to(urls.dashboardUrl);

                dashboardPage.clickBuzzLink();
                Assert.assertEquals(urls.buzzUrl, driver.getCurrentUrl());
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @And("User clicks the user dropdown name")
        public void userClicksTheUserDropdownName()
        {
            try
            {
                dashboardPage.clickUserDropdownIcon();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @And("User clicks the logout link")
        public void userClicksTheLogoutLink()
        {
            try
            {
                dashboardPage.clickLogoutLink();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Then("User should logged out successfully")
        public void userShouldLoggedOutSuccessfully()
        {
            try
            {
                Assert.assertEquals(urls.baseUrl, driver.getCurrentUrl());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }