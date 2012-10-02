package tester;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRobot {
    @Test
    public void getElements() {
        try {
            // Create a new instance of the html unit driver
            // Notice that the remainder of the code relies on the interface,
            // not the implementation.
            WebDriver driver = new FirefoxDriver();
            driver.get("http://market.yandex.ru/search?hid=7812186");


            List<List<WebElement>> elements = findAllElements(driver);
            for (List<WebElement> e : elements) {
                System.out.println("<--------------------" + e.getClass() + "---------------------->");
                for (WebElement elem : e) {
                    System.out.println(elem.toString()+ elem.getText());
                }
            }
            find(driver);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private ExpectedCondition<WebElement> textIsPresent(final String text) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                List<WebElement> allLinks = driver.findElements(By.tagName("a"));
                for (WebElement link : allLinks) {
                    if (link.getText().contains(text)) {
                        return link;
                    }

                }
                return null;

            }
        };
    }

    private List<List<WebElement>> findAllElements(WebDriver driver) {
        List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        List<WebElement> foo = driver.findElements(By.tagName("a"));
//        for(WebElement element : foo){
//            String link = element.getAttribute("src");
//        }
        List<WebElement> inputsSearch = driver.findElements(By.xpath("//input"));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        List<List<WebElement>> l = new LinkedList<List<WebElement>>();
        l.add(buttons);
       l.add(checkBox);
        l.add(links);
        l.add(inputsSearch);
        return l;
    }
    private void find(WebDriver driver){
        String htmlSource = driver.getPageSource();
        Pattern linkElementPattern = Pattern.compile("<ab[^>]*href=\"[^>]*>(.*?)</a>");
        Matcher linkElementMatcher = linkElementPattern.matcher(htmlSource);
        while (linkElementMatcher.find()) {
            System.out.println(linkElementMatcher.group());
        }
        Object thisurl = driver.getCurrentUrl();
        System.out.println(thisurl);
    }
}
