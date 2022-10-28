package by.it_academy.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final String DRIVER_HAS_BEEN_SET_MESSAGE = "Driver has been set: ";

    public static void setDriver() {
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            driver.get().manage().window().maximize();
        } else {
            System.out.println(DRIVER_HAS_BEEN_SET_MESSAGE + Thread.currentThread().getId());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
