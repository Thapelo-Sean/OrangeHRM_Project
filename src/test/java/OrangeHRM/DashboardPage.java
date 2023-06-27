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

    private By adminLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
    private By pimLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a");
    private By timeLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a");
    private By recruitmentLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a");
    private By myInfoLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a");
    private By performanceLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a");
    private By directoryLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a");
    private By maintenanceLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a");
    private By buzzLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a");

    //Methods

    public void clickAdminLink()
    {
        WebElement adminLink = driver.findElement(adminLocator);
        adminLink.click();
    }

    public void clickPimLink()
    {
        WebElement pimLink = driver.findElement(pimLocator);
        pimLink.click();
    }

    public void clickTimelink()
    {
        WebElement timeLink = driver.findElement(timeLocator);
        timeLink.click();
    }

    public void clickRecruitmentLink()
    {
        WebElement recruitmentLink = driver.findElement(recruitmentLocator);
        recruitmentLink.click();
    }

    public void clickMyInfoLink()
    {
        WebElement myInfoLink = driver.findElement(myInfoLocator);
        myInfoLink.click();
    }

    public void clickPerformanceLink()
    {
        WebElement performanceLink = driver.findElement(performanceLocator);
        performanceLink.click();
    }

    public void clickDirectoryLink()
    {
        WebElement directoryLink = driver.findElement(directoryLocator);
        directoryLink.click();
    }

    public void clickMaintenanceLink()
    {
        WebElement maintenanceLink = driver.findElement(maintenanceLocator);
        maintenanceLink.click();
    }

    public void clickBuzzLink()
    {
        WebElement buzzLink = driver.findElement(buzzLocator);
        buzzLink.click();
    }
}