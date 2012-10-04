package tester;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Class for generating instructions using class Finder and Elements for this
 * reasons.
 */
public class BTask {
    /**
     * For input texts generates instructions for bad and good values
     *
     * @param w      WebElemend that needed to be feel
     * @param values values to feel
     * @return A list of one {@link String}s of instruction, or an empty list if nothing matches
     */
    private static List<String> feelAllTexts(WebElement w, List<String> values) {

        List l = new LinkedList();
        for (String t : values) {
            l.add(" ввести в поле <" + w.getText() + " name: " + w.getAttribute("name") + " class:" +
                    w.getAttribute("class") + " id:" + w.getAttribute("id") + "> значение " + t);
        }
        return l;
    }

    /**
     * For input texts generates instructions for bad and good values
     *
     * @param w      WebElemend that needed to be feel
     * @param values values to feel
     * @return A list of all {@link String}s of instructions, or an empty list if nothing matches
     */
    private static List<String> feelText(List<WebElement> w) {
        Elements e = new Elements();
        List<String> forFeel = new LinkedList<String>();
        for (WebElement we : w) {
            List l = new LinkedList();
            l.add(e.randomString(20));
            l.add(e.randomString(100));
            l.add(e.randomInt(10000));
            l.add(e.badMail);
            l.add(e.defaultValue);
            forFeel.addAll(feelAllTexts(we, l));
        }
        return forFeel;
    }

    /**
     * Method that takes as argument an method.
     *
     * @param object                      object of class that takes 1 parameter of webelement
     * @param methodToCall                metod for proceeding
     * @param objWithAllMethodsToBeCalled list of WebElements
     * @return A list of all {@link String}s of instructions, or an empty list if nothing matches
     */
    private static List<String> someMethod(Object object, Method methodToCall, List<WebElement> objWithAllMethodsToBeCalled) {

        List<String> result = new LinkedList<String>();
        try {

            for (WebElement w : objWithAllMethodsToBeCalled) {
                Object[] parameters = new Object[1];
                parameters[0] = w;
                result.add(methodToCall.invoke(object, parameters).toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;

    }

    public static String pressButton(WebElement w) {
        return " нажать кнопку <" + w.getText() + " name: " + w.getAttribute("name") + " class:" +
                w.getAttribute("class") + " id:" + w.getAttribute("id") + ">";
    }

    public static String checkBox(WebElement w) {
        return " выбрать чекбокс <" + w.getText() + " name: " + w.getAttribute("name") + " class:" +
                w.getAttribute("class") + " id:" + w.getAttribute("id") + ">";
    }

    public static String selectOr(WebElement w) {
        return " выбрать селектор <" + w.getText() + " name: " + w.getAttribute("name") + " class:" +
                w.getAttribute("class") + " id:" + w.getAttribute("id") + ">";
    }

    public static String pressRadio(WebElement w) {
        return " выбрать радио-кнопку <" + w.getText() + " name: " + w.getAttribute("name") + " class:" +
                w.getAttribute("class") + " id:" + w.getAttribute("id") + ">";
    }

    public static String pressImage(WebElement w) {
        return " кликнуть по изображению <" + w.getText() + " name: " + w.getAttribute("name") + " class:" +
                w.getAttribute("class") + " id:" + w.getAttribute("id") + ">";
    }

    public static String pressLink(WebElement w) {
        return " кликнуть по ссылке <" + w.getText() + " name: " + w.getAttribute("name") + " href:" +
                w.getAttribute("href") + " id:" + w.getAttribute("id") + ">";
    }

    /**
     * Find all combinations of the combinations of filled instructions for every element
     *
     * @param drive WebDriver
     * @param url   url for proceeding
     * @return A list of lists of Lists of  all {@link String} instructions, or an empty list if nothing matches
     */
    public static List<List<List<String>>> getCombinationsOfInstructions(WebDriver drive, String url) throws Exception {

        //Finder f = new Finder(drive,"http://market.yandex.ru/search?hid=7812186");
        Finder f = new Finder(drive, url);


        List<Method> m = new ArrayList<Method>(6);
        m.add(0, BTask.class.getMethod("pressButton", WebElement.class));
        m.add(1, BTask.class.getMethod("checkBox", WebElement.class));
        m.add(2, BTask.class.getMethod("pressLink", WebElement.class));
        m.add(3, BTask.class.getMethod("pressRadio", WebElement.class));
        m.add(4, BTask.class.getMethod("selectOr", WebElement.class));
        m.add(5, BTask.class.getMethod("pressImage", WebElement.class));
        List<List<String>> result = new LinkedList<List<String>>();
        BTask build = new BTask();
        result.add(BTask.someMethod(build, m.get(0), f.getAllButtons()));
        result.add(BTask.someMethod(build, m.get(1), f.getAllCheckBoxes()));
        result.add(BTask.someMethod(build, m.get(2), f.getAllLinks()));
        result.add(BTask.someMethod(build, m.get(3), f.getAllRadio()));
        result.add(BTask.someMethod(build, m.get(4), f.getSelectors()));
        result.add(BTask.someMethod(build, m.get(5), f.getAllImages()));
        result.add(BTask.feelText(f.getInputTexts()));
        return Combinations.findCombinations(result);
    }

    /**
     * Find all combinations of the combinations of filled instructions for every element but only for some restriction
     * because of too large dimencion of size of all elements
     *
     * @param drive WebDriver
     * @param url   url for proceeding
     * @param restr restriction, usually equal to 3
     * @return A list of lists of  all {@link String} instructions, or an empty list if nothing matches
     */
    public static List<List<String>> getCombinationsOfInstructionsStricted(WebDriver drive, String url, int restr) throws Exception {


        Finder f = new Finder(drive, url);


        List<Method> m = new ArrayList<Method>(6);
        m.add(0, BTask.class.getMethod("pressButton", WebElement.class));
        m.add(1, BTask.class.getMethod("checkBox", WebElement.class));
        m.add(2, BTask.class.getMethod("pressLink", WebElement.class));
        m.add(3, BTask.class.getMethod("pressRadio", WebElement.class));
        m.add(4, BTask.class.getMethod("selectOr", WebElement.class));
        m.add(5, BTask.class.getMethod("pressImage", WebElement.class));
        Collection<String> result = new LinkedList<String>();
        BTask build = new BTask();
        result.addAll(BTask.someMethod(build, m.get(0), f.getAllButtons()));
        result.addAll(BTask.someMethod(build, m.get(1), f.getAllCheckBoxes()));
        //result.addAll(BTask.someMethod(build, m.get(2), f.getAllLinks()));
        result.addAll(BTask.someMethod(build, m.get(3), f.getAllRadio()));
        result.addAll(BTask.someMethod(build, m.get(4), f.getSelectors()));
        result.addAll(BTask.someMethod(build, m.get(5), f.getAllImages()));
        result.addAll(BTask.feelText(f.getInputTexts()));
        List<List<String>> res = new LinkedList<List<String>>();
        for (String s : BTask.someMethod(build, m.get(2), f.getAllLinks())) {
            List l = new ArrayList(1);
            l.add(0, s);
            res.add(l);
        }
        for (int i = 0; i <= restr; i++) {
            res.addAll(Combinations.findCombinations(result, i));
        }


        return res;
    }

    /**
     * Print all instuctions
     *
     * @param l list of all instructions
     */
    public static void printInstructions(List<List<List<String>>> l) {
        for (List<List<String>> acc : l) {
            for (List<String> innerAcc : acc) {
                System.out.print(innerAcc);
            }
            System.out.println();
        }
    }

    /**
     * Print restricted instuctions to file
     * @param l list of all instructions
     */
    public static void printInstructionsToFileStricted(List<List<String>> l) throws IOException {
        File file = new File("output_stricted.txt");

        FileWriter fstream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream);
        int i = 1;
        for (List<String> acc : l) {
            out.append("Тест" + i);
            for (String innerAcc : acc) {
                out.append(" " + innerAcc.toString() + ".");

            }
            i++;
            out.append("\n");
        }
        out.close();
        fstream.close();

    }
    /**
     * Print not restricted instuctions to file
     * @param l list of all instructions
     */
    public static void printInstructionsToFile(List<List<List<String>>> l) throws IOException {
        File file = new File("output.txt");

        FileWriter fstream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream);
        int i = 1;
        for (List<List<String>> acc : l) {
            out.append("Тест" + i);
            for (List<String> innerAcc : acc) {
                out.append(" " + innerAcc.toString() + ".");
            }
            out.append("\n");
            i++;
        }
        out.close();
        fstream.close();

    }

}
