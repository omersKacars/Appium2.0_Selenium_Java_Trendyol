package trendyol.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import trendyol.utils.Driver;

import java.util.List;


public class MyAccoundPage {
    public MyAccoundPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(id = "trendyol.com:id/textViewEmail")
    public WebElement visible_EmailAddress;
    @AndroidFindBy(id = "trendyol.com:id/imageViewBodyMass")
    public WebElement account_Settings;
    @AndroidFindBy(id = "trendyol.com:id/linearLayoutAccountSettingsItem")
    public List<WebElement> account_Setting_List;
    @AndroidFindBy(id = "trendyol.com:id/stateLayout")
    public WebElement wait_visible_for_accountSettings;
    @AndroidFindBy(id = "android:id/button1")
    public WebElement exit_accept_Button;
    @AndroidFindBy(id = "android:id/autofill_save_no")
    public WebElement autofill_save_no_Button;
    @AndroidFindBy(id = "trendyol.com:id/layoutContents")
    public WebElement sana_Ozel_Teklif;


}
