package io.selendroid.demo.mobileweb;


import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class EBureauVerificationTests {

    public static WebDriver driver;

//    @BeforeMethod
//    public void testName() throws Exception {
//        DesiredCapabilities caps = SelendroidCapabilities.android();
//        driver = new SelendroidDriver(new URL("http://localhost:4444/wd/hub"), caps);
//    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

// connect to USB Device
//adb devices -> "List of devices attached"

    @Test
    public void testNameRemote() throws Exception {
//        DesiredCapabilities caps = SelendroidCapabilities.android();
//        driver = new SelendroidDriver(new URL("http://localhost:4444/wd/hub"), caps);
//
        driver = new RemoteWebDriver(DesiredCapabilities.android());


//        DesiredCapabilities caps = SelendroidCapabilities.android();
//        driver = new SelendroidDriver(caps);

        driver.get("http://m.ebay.com");
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("Nexus 5 16 gb");
        element.submit();
        takeScreenshot();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

    private void takeScreenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("target" + File.separator + "screens-selendroid" + File.separator + "screenshot-" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
