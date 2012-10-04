package tester;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for finding all possible elements on web page by some url.
 * @param      driver  webdriver for some browser, by default it is
 *                     a HtmlUnitDriver that platform independent and
 *                     do not needed any browser on PC.
 *@param       url     url for finding objects which human can interact
 */
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

    /**
     * Find all links within the current page using the given mechanism.
     * @return A list of all {@link WebElement}s of links, or an empty list if nothing matches
     * @see org.openqa.selenium.By
     * @see org.openqa.selenium.WebDriver.Timeouts
     */
    public List<WebElement> getAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        return links;
    }
    /**
     * Find all attributes of list of WebElements or nulls.
     * @param elements List of elements that needed to be proceed
     * @param attrib name of attribute that need to return
     * @return A list of attributes of any webelement
     * @see org.openqa.selenium.By
     * @see org.openqa.selenium.WebDriver.Timeouts
     */
    public List<String> getAttributes(List<WebElement> elements, String attrib) {
        List<String> result = new LinkedList<String>();
        for (WebElement w : elements) {
            result.add(w.getAttribute(attrib));
        }
        return result;
    }
    /**
     * Find all buttons within the current page using the given mechanism.
     * @return A list of all {@link WebElement}s of buttons, or an empty list if nothing matches
     * @see org.openqa.selenium.By
     * @see org.openqa.selenium.WebDriver.Timeouts
     */
    public List<WebElement> getAllButtons() {
        List<WebElement> buttons = driver.findElements(By.xpath("//input[@type='button' or @type='submit']"));

        return buttons;
    }

    public List<WebElement> getAllImages() {
        List<WebElement> imgs = driver.findElements(By.xpath("//img"));

        return imgs;
    }

    public List<WebElement> getAllRadio() {
        List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));

        return radio;
    }

    public List<WebElement> getAllCheckBoxes() {
        List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        return checkBox;
    }
    /**
     * Method that waits untol not find elements on web page.
     * @return A list of all {@link WebElement}s of buttons, or an empty list if nothing matches
     * @see org.openqa.selenium.By
     * @see org.openqa.selenium.WebDriver.Timeouts
     */
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
    /**
     * Find all we page source
     * @return A list of all {@link WebElement}s, or an empty list if nothing matches
     * @see org.openqa.selenium.By
     * @see org.openqa.selenium.WebDriver.Timeouts
     */
    public List<WebElement> getAll() {
        List<WebElement> all = driver.findElements(By.xpath("//*"));
        return all;
    }

    public List<WebElement> getSelectors() {
        List<WebElement> select = driver.findElements(By.xpath("//select"));
        return select;
    }

    public List<WebElement> getInputTexts() {
        List<WebElement> select = driver.findElements(By.xpath("//input[@type='text' or 'search']"));
        return select;
    }
    /**
     * Prints all input elements in console
     *@param elements List of lists of webelements
     */
    public void printListsOfElements(List<List<WebElement>> elements) {
        for (List<WebElement> e : elements) {
            System.out.println("<--------------------" + e.getClass() + "---------------------->");
            for (WebElement elem : e) {
                System.out.println(elem.getTagName() + " has name = " + elem.getText() + " attrib=" + elem.getAttribute("type"));
            }
        }
    }
    /**
     * Prints all input elements in console
     *@param elements List of webelements
     */
    public void printElements(List<WebElement> elements) {
        for (WebElement e : elements) {
            System.out.println(e.getTagName() + e.getText() + " " + e.getAttribute("type"));
        }
    }

}
