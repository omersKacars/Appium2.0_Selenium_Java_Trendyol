package trendyol.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import trendyol.utils.Driver;


public class HomePage {
    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(id = "trendyol.com:id/imageViewTooltipClose")    public WebElement close_discover_button;
    @AndroidFindBy(accessibility = "Hesabım")                       public WebElement myAccound_button;



}
