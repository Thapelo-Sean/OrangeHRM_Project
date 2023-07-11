package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DashboardPage
{
    private WebDriver driver;
    //Constructor
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locate elements
    private By adminLinkLocator = By.partialLinkText("Admin");
    private By pimLinkLocator = By.partialLinkText("PIM");
    private By leaveLinkLocator = By.partialLinkText("Leave");
    private By timeLinkLocator = By.partialLinkText("Time");
    private By recruitmentLinkLocator = By.partialLinkText("Recruitment");
    private By myInfoLinkLocator = By.partialLinkText("My Info");
    private By performanceLinkLocator = By.partialLinkText("Performance");
    private By directoryLinkLocator = By.partialLinkText("Directory");
    private By maintenanceLinkLocator = By.partialLinkText("Maintenance");
    private By buzzLinkLocator = By.partialLinkText("Buzz");
    private By dashboardLinkLocator = By.partialLinkText("Dashboard");
    private By userDropdownLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p");
    private By logoutLinkLocator = By.partialLinkText("Logout");
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

    public void clickUserDropdownIcon()
    {
        WebElement userDropdown = driver.findElement(userDropdownLocator);
        userDropdown.click();
    }

    public void clickLogoutLink()
    {
        WebElement logoutLink = driver.findElement(logoutLinkLocator);
        logoutLink.click();
    }

    public void links()
    {
        List<WebElement> links = driver.findElements(By.tagName("a"));
    }
}