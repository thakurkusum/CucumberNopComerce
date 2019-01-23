package CucumberNopComerce;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utils extends BasePage {


    // For clicking the elements
    public static void click_element(By by){
            driver.findElement(by).click();
    }
    // For getting the size
    public static int get_size(By by){
        int size = driver.findElements(by).size();
        return size; }
     public static void assertEquals(By by,String expectedresult){
        String actual_result =driver.findElement(by).getText();
        Assert.assertEquals(actual_result, expectedresult);
     }

    // For getting attribute
    public static String get_atributte(By by, String tex){
        String text = driver.findElement(by).getAttribute(tex);
        return  text; }

     // For getting the text element
    public static String get_text_element(By by) {
        String text = driver.findElement(by).getText();
        return text; }

     // input text
     public static void enter_text(By by, String text){
            driver.findElement(by).sendKeys(text); }

     // For explicity wait
     public static void explicity_wait(By by){
            driver.manage().timeouts(); }

     //For making dynamic email id and using Timestamp
     public static String timestamp(){
         DateFormat format = new SimpleDateFormat("ddmmyyhhmmss");
         return format.format(new Date()); }

      //For implicity wait
      public static void implicitlyWait(){
            driver.manage().timeouts(); }

      //For fullscreen
      public static void fullscreen(){
            driver.manage().window();
        }
        // For clearing the selection
      public static void clear(By by)
        {driver.findElement(by).clear();}

        // For selection
      public static void is_selected(By by){
            driver.findElement(by).isSelected();
        }

       public static void getCurrentUrl(){
            driver.getCurrentUrl();
                }
      // Element to be invisisble
       public static void wait_for_element_to_be_invisible(By by, int time){
           WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        }
        // Element to be load
       public static void wait_for_element_to_load(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
       }
       //Element to be clickable
       public static void wait_for_element_to_clickable(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
       }
       // For selecting from Drop-down value- by value
        public static void select_by_value(By element, String num){
        new Select(driver.findElement(element)).selectByValue(num);
        }
        //For selecting from Drop_down value - by visisble text
        public static void select_by_visisble_text(By element, String text){
        new Select(driver.findElement(element)).selectByVisibleText(text);
        }

        }





