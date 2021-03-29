package CompleteProj.E2EProj;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.base;

public class NavigationBar extends base
{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize(ITestContext context) throws IOException
	{
		driver = Initializedriver();
		log.info("Driver is initialized");
		context.setAttribute("WebDriver", driver);
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigative(String username, String password) throws IOException
	{
		
		
		LandingPage lp = new LandingPage(driver);
		
		
		Assert.assertEquals(lp.getcourse().getText(),"FEATURED COURSES123");
		
		lp.getLogin().click();
		
		LoginPage lg = new LoginPage(driver);
		
		lg.getEmail().sendKeys(username);
		lg.getPassword().sendKeys(password);
		//System.out.println(text);
		lg.getsubmit().click();
		
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
