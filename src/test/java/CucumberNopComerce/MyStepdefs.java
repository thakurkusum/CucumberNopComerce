package CucumberNopComerce;

import cucumber.api.PendingException;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

      public class MyStepdefs extends Utils {

      SoftAssert softAssert=new SoftAssert();

    // LOGIN
    @Given("^user is on home page in Demonopcomerce$")
       public void userIsOnHomePageInDemonopcomerce(){
    }

    @When("^user enter all the details for login$")
       public void userEnterAllTheDetails() {
       click_element(By.linkText("Log in"));
       enter_text(By.xpath("//input[@class=\"email\"]"),"lotusrana12@mail.com");
       enter_text(By.xpath("//input[@id=\"Password\"]"),"refugee");
       click_element(By.xpath("//input[@value=\"Log in\"]"));
    }

    @Then("^user should login successfully$")
        public void userShouldSuccessfullyLogin() {
        String expected_result ="Welcome to our store";
        assertEquals(By.xpath("//div[@class=\"topic-block-title\"]//h2"),expected_result);
    }
    //REGISTRATION
    @Given("^user is on home page in Demonopcomerce $")
        public void userShouldRegisterSuccessfully(){

    }
    @When("^user enters all the details$")
        public void userEntersAllTheDetails()  {
        click_element(By.linkText("Register"));
        click_element(By.xpath("//input[@id=\"gender-female\"]"));
        enter_text(By.name("FirstName"),"lotus");
        enter_text(By.id("LastName"),"rana");
        enter_text(By.xpath("//select[@name=\"DateOfBirthDay\"]"),"25");
        enter_text(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"January");
        enter_text(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1990");
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        enter_text(By.name("Email"),"lotusrana" + date1 + "12@mail.com");
        enter_text(By.id("Company"),"Inspiring next");
        click_element(By.id("Newsletter"));
        enter_text(By.name("Password"),"refugee");
        enter_text(By.name("ConfirmPassword"),"refugee");
        click_element(By.xpath("//input[@value=\"Register\"]"));
    }
    @Then("^user should registered successfully$")
         public void userShouldRegisteredSuccessfully() {
         String expected_result = "Your registration completed";
         assertEquals(By.xpath("//div[@class='result']"),expected_result);

    }
    // SEND A MAIL TO FRIEND SUCCESSFULLY
    @Given("^user is already login in Demonopcomerce$")
        public void userIsAlreadyLoginInDemonopcomerce() {
    }
    @And("^he is in homepage$")
        public void heIsInHomepage()  {
    }
    @When("^user select any product$")
        public void userSelectAnyProduct() {
        click_element(By.linkText("Log in"));
        enter_text(By.xpath("//input[@class=\"email\"]"),"lotusrana12@mail.com");
        enter_text(By.xpath("//input[@id=\"Password\"]"),"refugee");
        click_element(By.xpath("//input[@value=\"Log in\"]"));
        click_element(By.linkText("Electronics"));
        click_element(By.linkText("Cell phones"));
        click_element(By.linkText("Nokia Lumia 1020"));
        click_element(By.xpath("//input[@value=\"Email a friend\"]"));
        enter_text(By.xpath("//input[@id=\"FriendEmail\"]"),"kusum.thakur@outlook.com");
        enter_text(By.xpath("//textarea[@id=\"PersonalMessage\"]"),"check out this");
        click_element(By.xpath("//input[@name=\"send-email\"]"));
    }
    @Then("^user should able to send a mail to his friend successfully$")
        public void userShouldAbleToSendAMailToHisFriendSuccessfully() {
        String expected_result ="Your message has been sent.";
        assertEquals(By.xpath("//div[@class=\"result\"]"),expected_result);
    }
    //UNREGISTERED USER TRIES TO SEND A MAIL TO FRIEND
    @When("^user select jewelry from list$")
        public void userSelectJewelryFromList() {
        click_element(By.linkText("Jewelry"));
        click_element(By.linkText("Flower Girl Bracelet"));
    }
    @And("^user enters his friend email id$")
        public void userEntersHisFriendEmailId() {
        click_element(By.xpath("//input[@value=\"Email a friend\"]"));
        enter_text(By.xpath("//*[@id=\"FriendEmail\"]"),"rajpatel@mail.com");
        enter_text(By.xpath("//*[@id=\"YourEmailAddress\"]"),"kusum.thakur@outlook.com");
        enter_text(By.xpath("//textarea[@id=\"PersonalMessage\"]"),"check out this");
    }
    @And("^user tries to send a mail without registering$")
        public void userTriesToSendAMailWithoutRegistering()
    {   click_element(By.xpath("//input[@name=\"send-email\"]"));
    }
    @Then("^user should not be able to send a mail to friend$")
        public void userShouldNotAbleToSendAMailToFriend(){
        String expected_result ="Only registered customers can use email a friend feature";
        assertEquals(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"),expected_result);
    }
    // VERIFY CATEGORY LIST IS WORKING ON HOMEPAGE
    // ELECTRONIC CATEGORY
    @When("^user click on electronic category$")
        public void userClickOnElectroniccategory() {
        click_element(By.linkText("Electronics"));

    }
    @Then("^user should navigate to electronic page$")
        public void userShouldNavigateToElectronicPage() {
        String expected_result= "Electronics";
        String actual_result = get_text_element(By.xpath("//div[@class=\"page-title\"]//h1"));
        Assert.assertEquals(expected_result,actual_result,"test case failed");
        String expectedurl = "https://demo.nopcommerce.com/electronics";
        String actualurl = driver.getCurrentUrl();
        softAssert.assertEquals(expectedurl,actualurl);
        softAssert.assertAll();
    }
    //APPAREL CATEGORY
    @When("^user click on apparel category$")
        public void userClickOnApparelCategory() {
        click_element(By.linkText("Apparel"));

    }
    @Then("^user should navigate to apparel page$")
        public void userShouldNavigateToApparelPage() {
        String expected_result = "Apparel";
        String actual_result = get_text_element(By.xpath("//div[@class=\"page-title\"]/h1"));
        Assert.assertEquals(expected_result,actual_result,"test case failed");
        String expectedurl ="https://demo.nopcommerce.com/apparel";
        String actualurl = driver.getCurrentUrl();
        softAssert.assertEquals(expectedurl,actualurl);
        softAssert.assertAll();
    }
    //COMPUTER CATEGORY
    @When("^user click on computer category$")
       public void userClickOnComputerCategory() {
        click_element(By.linkText("Computers"));
    }
    @Then("^user should navigate to computer page$")
       public void userShouldNavigateToComputerPage(){
       String expected_result ="Computers";
       String actual_result = get_text_element(By.xpath("//div[@class=\"page-title\"]/h1"));
       Assert.assertEquals(expected_result,actual_result,"test case failed");
       String expectedurl ="https://demo.nopcommerce.com/computers";
       String actualurl = driver.getCurrentUrl();
       softAssert.assertEquals(expectedurl,actualurl);
       softAssert.assertAll();
    }

    //Digital downloads
    @When("^user click on digital downloads category$")
        public void userClickOnDigitalDownloadsCategory() {
        click_element(By.linkText("Digital downloads"));
        }
    @Then("^useer should navigate to digital download page$")
        public void useerShouldNavigateToDigitalDownloadPage() {
        String expected_result ="Digital downloads";
        String actual_result = get_text_element(By.xpath("//div[@class=\"page-title\"]/h1"));
        Assert.assertEquals(expected_result,actual_result,"test case failed");
        String expectedurl ="https://demo.nopcommerce.com/digital-downloads";
        String actualurl =driver.getCurrentUrl();
        softAssert.assertEquals(expectedurl,actualurl);
        softAssert.assertAll();
        }
    //BOOKS CATEGORY
    @When("^user click on books category$")
        public void userClickOnBooksCategory() {
        click_element(By.linkText("Books"));
        }

    @Then("^user should navigate to books page$")
        public void userShouldNavigateToBooksPage() {
        String expected_result ="Books";
        String actual_result = get_text_element(By.xpath("//div[@class=\"page-title\"]/h1"));
        Assert.assertEquals(expected_result,actual_result,"test case failed");
        String expectedurl ="https://demo.nopcommerce.com/books";
        String actualurl =driver.getCurrentUrl();
        softAssert.assertEquals(expectedurl,actualurl);
        softAssert.assertAll();
        }
    //JEWELRY CATEGORY
    @When("^user click on jewelry category$")
        public void userClickOnJewelryCategory() {
        click_element(By.linkText("Jewelry"));
        }

    @Then("^user should navigate to jewelry page$")
        public void userShouldNavigateToJewelryPage() {
        String expected_result ="Jewelry";
        String actual_result = get_text_element(By.xpath("//div[@class=\"page-title\"]/h1"));
        Assert.assertEquals(expected_result,actual_result,"test case fail");
        String expectedurl ="https://demo.nopcommerce.com/jewelry";
        String actualurl = driver.getCurrentUrl();
        softAssert.assertEquals(expectedurl, actualurl);
        softAssert.assertAll();
        }
     //Gift Cards
     @When("^user click on gift card category$")
        public void userClickOnGiftCardCategory() {
        click_element(By.linkText("Gift Cards"));
        }


     @Then("^user should navigate to gift card page$")
        public void userShouldNavigateToGiftCardPage() {
        String expected_result ="Gift Cards";
        String actual_result = get_text_element(By.xpath("//div[@class=\"page-title\"]/h1"));
        Assert.assertEquals(expected_result,actual_result,"test case fail");
        String expectedurl ="https://demo.nopcommerce.com/gift-cards";
        String actualurl =driver.getCurrentUrl();
        softAssert.assertEquals(expectedurl,actualurl);
        softAssert.assertAll();

          }


     @And("^user click on currency sign$")
          public void userClickOnCurrencySign(){
          click_element(By.xpath("//select[@name=\"customerCurrency\"] / option[2]"));

          }

     @Then("^user shuold able to see euro sign on jewelery$")
          public void userShuoldAbleToSeeEuroSignOnJewelery() {
          }
      }

