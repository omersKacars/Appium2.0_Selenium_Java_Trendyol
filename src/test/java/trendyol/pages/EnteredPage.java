package trendyol.pages;

import trendyol.utils.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


    public class EnteredPage {
    public EnteredPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "trendyol.com:id/buttonSelectGenderMan")
    public WebElement male_Button;
    @AndroidFindBy(id = "trendyol.com:id/buttonSelectGenderWoman")
    public WebElement female_Button;
    @AndroidFindBy(id = "trendyol.com:id/imageButtonClose")
    public WebElement close_img_button;




}
