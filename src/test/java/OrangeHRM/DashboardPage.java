package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    private WebDriver driver;
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locate elements

    private By adminLinkLocator = By.partialLinkText("Admin");
    private By pimLinkLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a");
    private By leaveLinkLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span");
    private By timeLinkLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a");
    private By recruitmentLinkLocator = By.partialLinkText("Recruitment");
    private By myInfoLinkLocator = By.partialLinkText("My Info");
    private By performanceLinkLocator = By.partialLinkText("Performance");
    private By directoryLinkLocator = By.partialLinkText("Directory");
    private By maintenanceLinkLocator = By.partialLinkText("Maintenance");
    private By buzzLinkLocator = By.partialLinkText("Buzz");
    private By dashboardLinkLocator = By.partialLinkText("Dashboard");

    //Methods

    public void clickAdminLink()
    {
        WebElement adminLink = driver.findElement(adminLinkLocator);
        adminLink.click();
    }

    public void clickPimLink()
    {
        WebElement pimLink = driver.findElement(pimLinkLocator);
        pimLink.click();
    }

    public void clickLeaveLink()
    {
        WebElement leaveLink = driver.findElement(leaveLinkLocator);
        leaveLink.click();
    }

    public void clickTimelink()
    {
        WebElement timeLink = driver.findElement(timeLinkLocator);
        timeLink.click();
    }

    public void clickRecruitmentLink()
    {
        WebElement recruitmentLink = driver.findElement(recruitmentLinkLocator);
        recruitmentLink.click();
    }

    public void clickMyInfoLink()
    {
        WebElement myInfoLink = driver.findElement(myInfoLinkLocator);
        myInfoLink.click();
    }

    public void clickPerformanceLink()
    {
        WebElement performanceLink = driver.findElement(performanceLinkLocator);
        performanceLink.click();
    }

    public void clickDirectoryLink()
    {
        WebElement directoryLink = driver.findElement(directoryLinkLocator);
        directoryLink.click();
    }

    public void clickMaintenanceLink()
    {
        WebElement maintenanceLink = driver.findElement(maintenanceLinkLocator);
        maintenanceLink.click();
    }

    public void clickBuzzLink()
    {
        WebElement buzzLink = driver.findElement(buzzLinkLocator);
        buzzLink.click();
    }

    public void clickDashboardLink()
    {
        WebElement dashboardLink = driver.findElement(dashboardLinkLocator);
        dashboardLink.click();
    }
}