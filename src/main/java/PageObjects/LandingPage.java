package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By featured_course = By.xpath("//div[@class = 'text-center']/h2");
	By navigation_bar = By.xpath("/html/body/header/div[2]/div/nav");
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getcourse()
	{
		return driver.findElement(featured_course);
	}
	
	public WebElement nav_bar()
	{
		return driver.findElement(navigation_bar);
	}
}
