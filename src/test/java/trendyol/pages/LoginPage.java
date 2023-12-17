package trendyol.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import trendyol.utils.Driver;


public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "trendyol.com:id/editTextEmail")        public WebElement email_textBox;
    @AndroidFindBy(id = "trendyol.com:id/editTextPassword")        public WebElement pwd_textBox;
    @AndroidFindBy(id = "trendyol.com:id/buttonLogin")     public WebElement girisYap_Button;
    @AndroidFindBy(id = "com.google.android.gms:id/cancel")     public WebElement none_of_the_above_Button;
    @AndroidFindBy(id = "trendyol.com:id/snackbar_text")     public WebElement wrong_input_message;


}
