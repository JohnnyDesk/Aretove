package com.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.exceptions.InvalidBrowserNameException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public RemoteWebDriver driver;

	public static ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * Used for initializing the ThreadLocal of RemoteWebDriver type with the given browserName
	 * @param browserName
	 * @return
	 */
	public RemoteWebDriver init_driver(String browserName) {
		System.out.println("Launching Browser: " + browserName);

		String name = browserName.toLowerCase();

		if (name.isEmpty()) {
			throw new InvalidBrowserNameException(name);
		} else if (name.contains("google") || name.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (name.contains("microsoft") || name.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} else if (name.contains("mozilla") || name.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (name.equals("safari")) {
			tlDriver.set(new SafariDriver());
			driver = new SafariDriver();
		} else {
			throw new InvalidBrowserNameException(name);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	/**
	 * Used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized RemoteWebDriver getDriver() {
		return tlDriver.get();
	}

}
