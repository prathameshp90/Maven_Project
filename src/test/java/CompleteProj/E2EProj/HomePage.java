package CompleteProj.E2EProj;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.base;

public class HomePage extends base
{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize(ITestContext context) throws IOException
	{
		driver = Initializedriver();
		log.info("Driver is initialized");
		context.setAttribute("WebDriver", driver);
		
	}
	
	  
	
	@Test(dataProvider = "getData")
	public void basePageNavigative(String username, String password) throws IOException
	{
		String url = prop.getProperty("url");
		driver.get(url);
		log.info("browser opened");
		LandingPage lp = new LandingPage(driver);
		System.out.println(lp.getcourse().getText());
		
		
		
		lp.getLogin().click();
		
		LoginPage lg = new LoginPage(driver);
		
		lg.getEmail().sendKeys(username);
		lg.getPassword().sendKeys(password);
		//System.out.println(text);
		lg.getsubmit().click();
		
		log.info("Home page Test Case completed");
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "1234";
		
		return data;
				
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
