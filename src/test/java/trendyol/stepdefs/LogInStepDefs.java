package trendyol.stepdefs;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import trendyol.pages.EnteredPage;
import trendyol.pages.HomePage;
import trendyol.pages.LoginPage;
import trendyol.pages.MyAccoundPage;
import trendyol.utils.ConfigReader;
import trendyol.utils.Driver;
import trendyol.utils.ReusableMethods.*;


import java.util.Random;

import static trendyol.utils.ReusableMethods.*;

public class LogInStepDefs {
    MyAccoundPage   myAccoundPage= new MyAccoundPage();
    EnteredPage     enteredPage  = new EnteredPage();
    LoginPage       loginPage    = new LoginPage();
    HomePage        homePage     = new HomePage();


    @Then("The gender is randomly selected for the most suitable products.")
    public void the_gender_is_randomly_selected_for_the_most_suitable_products() {
        visibleWait(Driver.getDriver(),enteredPage.male_Button,30);
        Random random = new Random();
        int rnd = random.nextInt(2);
        if (rnd == 1) {
            enteredPage.male_Button.click();
        } else enteredPage.female_Button.click();

    }

    @Then("The page for new products and campaigns can be closed by clicking the close button in the top right corner.")
    public void the_page_for_new_products_and_campaigns_can_be_closed_by_clicking_the_close_button_in_the_top_right_corner() {
        visibleWait(Driver.getDriver(),enteredPage.close_img_button,30);
        enteredPage.close_img_button.click();
    }

    @And("To close the Discover notification")
    public void toCloseTheDiscoverNotification() {
        visibleWait(Driver.getDriver(),homePage.close_discover_button,30);
        homePage.close_discover_button.click();
    }

    @Then("Click to Hesabim")
    public void clickToHesabim() {
        visibleWait(Driver.getDriver(), homePage.myAccound_button, 30);
        homePage.myAccound_button.click();
        bekle(2);
        try {
            loginPage.none_of_the_above_Button.click();
        } catch (Exception e) {
            System.out.println("Continue with ekrani gelmedi");
        }
    }

    @And("Enter a valid email address into the email textbox.")
    public void enterAValidEmailAddressIntoTheEmailTextbox() {
        handle_automatic_incoming_message(loginPage.none_of_the_above_Button);
        visibleWait(Driver.getDriver(),loginPage.email_textBox,30);
        loginPage.email_textBox.sendKeys(ConfigReader.getProperty("currentEmail"));
    }

    @And("Enter a valid password address into the password textbox.")
    public void enterAValidPasswordAddressIntoThePasswordTextbox() {
        loginPage.pwd_textBox.sendKeys(ConfigReader.getProperty("currentPwd"));
    }

    @And("click Giris Yap button")
    public void clickGirisYapButton() {
        loginPage.girisYap_Button.click();
    }

    @But("Verify that logged in.")
    public void verifyThatLoggedIn() {
        try {
            if (myAccoundPage.sana_Ozel_Teklif.isDisplayed()){
                KeyEvent back = new KeyEvent(AndroidKey.BACK);
                Driver.getDriver().pressKey(back);
            }
        } catch (Exception e) {
            System.out.println("Sana ozel teklif mesaji cikmadi");
        }
        visibleWait(Driver.getDriver(),myAccoundPage.visible_EmailAddress,30);
        String actualEmail = myAccoundPage.visible_EmailAddress.getText();
        System.out.println(actualEmail);
        String expectedEmail = ConfigReader.getProperty("currentEmail");
        Assert.assertEquals(expectedEmail, actualEmail);
    }

    @And("log Out")
    public void logOut() {
        visibleWait(Driver.getDriver(), myAccoundPage.visible_EmailAddress, 30);
        scrollDownWithTab(Driver.getDriver());
        myAccoundPage.account_Settings.click();
        bekle(2);
        scrollDownWithTab(Driver.getDriver());
        myAccoundPage.account_Setting_List.get(8).click();
        myAccoundPage.exit_accept_Button.click();
        bekle(5);
    }

    @And("Enter a invalid email address into the email textbox.")
    public void enterAInvalidEmailAddressIntoTheEmailTextbox() {
        handle_automatic_incoming_message(myAccoundPage.autofill_save_no_Button);
        loginPage.email_textBox.sendKeys(ConfigReader.getProperty("unCurrentEmail"));

    }

    @And("Enter a invalid password address into the password textbox.")
    public void enterAInvalidPasswordAddressIntoThePasswordTextbox() {
        loginPage.pwd_textBox.sendKeys(ConfigReader.getProperty("unCurrentPwd"));
    }

    @But("Verify that not logged in.")
    public void verifyThatNotLoggedIn() {
    Assert.assertTrue(loginPage.wrong_input_message.isDisplayed());
    }



}
