package tester;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;



public class Main {
   @Test
    public void manual(){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Aleksandr\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
       Wait wait = new WebDriverWait(driver,500);
    Finder f = new Finder(driver,"http://market.yandex.ru/search?hid=7812186");

    f.printElements(f.getAllLinks());
    }
}
