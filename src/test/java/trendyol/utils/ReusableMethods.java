package trendyol.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class ReusableMethods {

    public static void bekle(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme yapilamadi");
            throw new RuntimeException(e);
        }
    }

    public static void clickGesture(AndroidDriver driver, WebElement element) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void clickGesture(AndroidDriver driver, int x, int y) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public static void doubleClickGesture(AndroidDriver driver, WebElement element) {
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void doubleClickGesture(AndroidDriver driver, int x, int y) {
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public static void longClickGesture(AndroidDriver driver, WebElement element) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void longClickGesture(AndroidDriver driver, WebElement element, int milisecond) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", milisecond
        ));
    }

    public static void longClickGesture(AndroidDriver driver, int x, int y) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public static void longClickGesture(AndroidDriver driver, int x, int y, int milisecond) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y,
                "duration", milisecond
        ));
    }

    public static void dragGesture(AndroidDriver driver, WebElement element, int endX, int endY) {
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }


    public static void dragGesture(AndroidDriver driver, int startX, int startY, int endX, int endY) {
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX,
                "startY", startY,
                "endX", endX,
                "endY", endY
        ));
    }

    public static void swipeGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed) {
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }

    public static void scrollGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed) {
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }

    //Visible Wait
    public static void visibleWait(AndroidDriver driver, WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //uiAutomatorScrollable
    public static void uiAutomatorScrollable(AndroidDriver driver, String attributeName, String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + attributeName + "(\"" + text + "\"))"));
    }

    //scroll with tab

    public static void scrollDownWithTab(AndroidDriver driver){
        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth_x = screenSize.getWidth();
        int screenHeight_y = screenSize.getHeight();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(1), PointerInput.Origin.viewport(), screenWidth_x/2, 5*(screenHeight_y/6) ))//belirtilen x,y uzerine git
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))//mouseun sol clicini bas
                .addAction(new Pause(finger, Duration.ofMillis(50)))//belirlenen sure kadar bekle
                .addAction(finger.createPointerMove(Duration.ofMillis(1200), PointerInput.Origin.viewport(), screenWidth_x/2, screenHeight_y/8))//belirtilen zaman kadar belirtilen noktaya ilerle
                .addAction(new Pause(finger, Duration.ofMillis(50)))//ilerledikten sonra belirlenen sure kadar bekle
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                ;
        driver.perform(Collections.singletonList(sequence));
    }


    //handle irregular messages
    public static void handle_automatic_incoming_message(WebElement element){
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("autofill_save_no mesaji gelmedi");
        }
    }


}