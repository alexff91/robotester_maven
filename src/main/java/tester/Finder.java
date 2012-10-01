package tester;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.LinkedList;
import java.util.List;

public class Finder {
    public WebDriver driver = new HtmlUnitDriver();
    public String url = "http://www.yandex.ru";

    public Finder() {
        driver.get(url);

    }

    public Finder(WebDriver someDrive) {
        this.driver = someDrive;

    }

    public Finder(WebDriver someDrive, String someUrl) {
        this.driver = someDrive;
        this.url = someUrl;
        driver.get(url);

    }


    public List<WebElement> getAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        return links;
    }

    public List<String> getAttributes(List<WebElement> elements, String attrib) {
        List<String> result = new LinkedList<String>();
        for (WebElement w : elements) {
            result.add(w.getAttribute(attrib));
        }
        return result;
    }

    public List<WebElement> getAllButtons() {
        List<WebElement> buttons = driver.findElements(By.xpath("//input[@type='button']"));

        return buttons;
    }

    public List<WebElement> getAllRadio() {
        List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));

        return radio;
    }

    public List<WebElement> getAllCheckBoxes() {
        List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        return checkBox;
    }

    public ExpectedCondition<List<WebElement>> textIsPresent() {
        return new ExpectedCondition<List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                List<WebElement> allLinks = driver.findElements(By.xpath("input[@type='checkbox']"));
                return allLinks;

            }
        };
    }

    public List<WebElement> getAllInputs() {
        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        return inputs;
    }

    public List<WebElement> getAll() {
        List<WebElement> all = driver.findElements(By.xpath("//*"));
        return all;
    }

    public List<WebElement> getSelectors() {
        List<WebElement> select = driver.findElements(By.xpath("//input[@type='checkbox']"));
        return select;
    }

    public List<WebElement> getInputTexts() {
        List<WebElement> select = driver.findElements(By.xpath("//input[@type='text' and 'search']"));
        return select;
    }

    public void printListsOfElements(List<List<WebElement>> elements) {
        for (List<WebElement> e : elements) {
            System.out.println("<--------------------" + e.getClass() + "---------------------->");
            for (WebElement elem : e) {
                System.out.println(elem.getTagName() + " has name = " + elem.getText() + " attrib=" + elem.getAttribute("type"));
            }
        }
    }

    public void printElements(List<WebElement> elements) {
        for (WebElement e : elements) {
            System.out.println(e.getTagName() + e.getText());
        }
    }

}
