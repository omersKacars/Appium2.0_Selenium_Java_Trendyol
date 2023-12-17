package trendyol.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setUiautomator2ServerInstallTimeout(Duration.ofSeconds(40))
                    .setAppPackage(ConfigReader.getProperty("AppPackage"))
                    .setAppActivity(ConfigReader.getProperty("AppActivity"))
                    ;
            URL url = null;
            try {
                url = new URL("http://0.0.0.0:4723");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver = new AndroidDriver(service.getUrl(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void serverBaslat(String ipAdress, int port) {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(ConfigReader.getProperty("mainJS_path")))
                .withIPAddress(ipAdress)
                .usingPort(port)
                .build();
        service.start();
    }

    public static void uygulamayiKapat() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void serverKapat() {
        service.stop();
    }
}
