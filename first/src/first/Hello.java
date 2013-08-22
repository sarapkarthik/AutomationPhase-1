package first;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hello {

	public static void main(String args[])
	{
	
	
	WebDriver wb = new FirefoxDriver();
	
	//WebDriverWait wd = new WebDriverWait(wb, 10);
	
	wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	// WebDriver wb = new FirefoxDriver();
	
	wb.get("http://www.gmail.com");
	
	
		  //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				  	
		Properties p = new  Properties();
			
		try
		{
		FileInputStream fis = new FileInputStream("C:\\karthik\\first\\data.properties");
	//	p.load(f);
		
		  p.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		 
		String str1 = p.getProperty("username");
		String str2 = p.getProperty("password");
		
		wb.findElement(By.name("Email")).sendKeys(str1);
		
		wb.findElement(By.name("Passwd")).sendKeys(str2);;
	    
		/*
		WebElement element = wb.findElement(By.name("Email"));
	    element.sendKeys("sarapkarthik");
	    
	    WebElement element1 = wb.findElement(By.name("Passwd"));
	    element1.sendKeys("iNNominds123$#");
	    */
		
	    wb.findElement(By.name("signIn")).click();
	    
	    
	    wb.findElement(By.id("gbg4")).click();
	    
	    String str = wb.findElement(By.id("gb_71")).getText();
		
	    System.out.println("Value is ---->" +str);  
	    
	    wb.findElement(By.id("gb_71")).click();
	    
	   // condition to verify that you have successfull logged into your account and signout button is visible.
	    if(str.equals("Sign out"))
	    {
	    	System.out.println("Signout is matched.");
	    }
	    
	    wb.close();
	}
}
	
	
	