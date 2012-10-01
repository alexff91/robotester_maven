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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class Main {
    @Test
    public void manual() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aleksandr\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new HtmlUnitDriver();

        //Finder f = new Finder(driver,"http://market.yandex.ru/search?hid=7812186");
        Finder f = new Finder(driver, "file:///C:/Users/Aleksandr/Desktop/1.html");

        LinkedList<List<WebElement>> l = new LinkedList<List<WebElement>>();
        l.add(f.getAllButtons());
        l.add(f.getAllRadio());
        l.add(f.getAllLinks());
        l.add(f.getInputTexts());
        l.add(f.getAllCheckBoxes());
        l.add(f.getSelectors());
        f.printListsOfElements(l);
        List<List<String>> listOfStrings = new LinkedList<List<String>>();
        List<Method> m = new ArrayList<Method>(5);
        m.add(0, BuildInstruction.class.getMethod("pressButton", WebElement.class));
        m.add(1, BuildInstruction.class.getMethod("checkBox", WebElement.class));
        m.add(2, BuildInstruction.class.getMethod("pressLink", WebElement.class));
        m.add(3, BuildInstruction.class.getMethod("pressRadio", WebElement.class));
        m.add(4, BuildInstruction.class.getMethod("selectOr", WebElement.class));
        List<List<String>> result = new LinkedList<List<String>>();
        BuildInstruction build = new BuildInstruction();
        result.add(BuildInstruction.someMethod(build,m.get(0), f.getAllButtons()));
        result.add(BuildInstruction.someMethod(build,m.get(1), f.getAllCheckBoxes()));
        result.add(BuildInstruction.someMethod(build,m.get(2), f.getAllLinks()));
        result.add(BuildInstruction.someMethod(build,m.get(3), f.getAllRadio()));
        result.add(BuildInstruction.someMethod(build,m.get(4), f.getSelectors()));
        result.add(BuildInstruction.feelText(f.getInputTexts()));
        List<List<String>> resultToPrint  = BuildInstruction.combinate(result);
        for(List<String> acc:resultToPrint){
            for(String innerAcc: acc){
                System.out.print(innerAcc);
            }
            System.out.println();
        }
       List<List<List<String>>> lnew = Combinations.findCombinations(result);
        for(List<List<String>> acc:lnew){
            for(List<String> innerAcc: acc){
                System.out.print(innerAcc);
            }
            System.out.println();
        }
    }
}
