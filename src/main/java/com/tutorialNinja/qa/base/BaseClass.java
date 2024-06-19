package com.tutorialNinja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.tutorialNinja.qa.util.UtilClass;
import com.tutorialNinja.qa.util.WebEventListener;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop; 
	public static WebEventListener eventListener;
	public static Logger log;
	
	public BaseClass() {
		//To read config property values
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\veena.mc\\eclipse-workspace\\MavenHybridFramework\\TutorialsNinjaDemoProj\\src\\main\\java\\com\\tutorialNinja\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//Browser initialization and launch the application
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			driver = new ChromeDriver();
		}
		else if (browserName.equals("edge")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("edgePath"));
			driver = new EdgeDriver();
		}	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilClass.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
	}
	
	//To take screenshot for failed test cases.
	public void failed(String testMethodName)
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(srcfile, new File("C:\\Users\\veena.mc\\eclipse-workspace\\MavenHybridFramework\\TutorialsNinjaDemoProj\\screenshots\\" +testMethodName+".jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
