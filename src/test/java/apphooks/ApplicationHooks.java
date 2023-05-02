package apphooks;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.base.DriverFactory;
import com.utils.PropReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private RemoteWebDriver driver;

	@Before
	public void launchBrowser() {

		PropReader prop = new PropReader();

		String browserName = prop.configReader("browser");

		driverFactory = new DriverFactory();

		driver = driverFactory.init_driver(browserName);
		
	}
	
	
	@After
	public void tearDown(Scenario sc) {
		
		if (sc.isFailed()) {
			String screenShotName = sc.getName().replace(" ", "_");
			byte[] rawImageFile = driver.getScreenshotAs(OutputType.BYTES);
			sc.attach(rawImageFile, "image/png", screenShotName);
		}
		
		driver.quit();
	}

}
