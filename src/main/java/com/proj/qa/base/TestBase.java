package com.proj.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.proj.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	//Test Base Class Constructor:
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream io = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\MavenTest\\src\\main\\java\\com\\proj\\qa\\config\\config.properties");
			prop.load(io);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();			
		}
		catch(IOException e){
			e.printStackTrace();			
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
//		//For Fire Fox browser:
//		else if (browserName.equals("FF")) {
//			System.setProperty("webdriver.gecko.driver", "<File Path>");
//			driver = new ChromeDriver();
//		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitTime, TimeUnit.SECONDS);
//		//Alternative:
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageLoadTime));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicitTime));
		driver.get(prop.getProperty("url"));
	}

}
