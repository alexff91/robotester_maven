package tester;

import com.sun.xml.internal.stream.buffer.stax.StreamWriterBufferCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTask {
    private static List<String> feelAllTexts(WebElement w, List<String> values) {

        List l = new LinkedList();
        for (String t : values) {
            l.add(" ввести в поле <" + w.getText()+" "+ w.getAttribute("name") + "> значение " + t);
        }
        return l;
    }

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
        return " нажать кнопку <" + w.getText()+" "+ w.getAttribute("name") + ">";
    }

    public static String checkBox(WebElement w) {
        return " выбрать чекбокс <" + w.getText() +" "+ w.getAttribute("name")+ ">";
    }

    public static String selectOr(WebElement w) {
        return " выбрать селектор <" + w.getText()+" "+ w.getAttribute("name") + ">";
    }

    public static String pressRadio(WebElement w) {
        return " выбрать радио-кнопку <" + w.getText()+" "+ w.getAttribute("name") + ">";
    }

    public static String pressLink(WebElement w) {
        return " кликнуть по ссылке <" + w.getText()+" "+ w.getAttribute("name") + ">";
    }

    public static List<List<List<String>>> getCombinationsOfInstructions(WebDriver drive, String url) throws Exception {

        //Finder f = new Finder(drive,"http://market.yandex.ru/search?hid=7812186");
        Finder f = new Finder(drive, url);


        List<Method> m = new ArrayList<Method>(5);
        m.add(0, BTask.class.getMethod("pressButton", WebElement.class));
        m.add(1, BTask.class.getMethod("checkBox", WebElement.class));
        m.add(2, BTask.class.getMethod("pressLink", WebElement.class));
        m.add(3, BTask.class.getMethod("pressRadio", WebElement.class));
        m.add(4, BTask.class.getMethod("selectOr", WebElement.class));
        List<List<String>> result = new LinkedList<List<String>>();
        BTask build = new BTask();
        result.add(BTask.someMethod(build, m.get(0), f.getAllButtons()));
        result.add(BTask.someMethod(build, m.get(1), f.getAllCheckBoxes()));
        result.add(BTask.someMethod(build, m.get(2), f.getAllLinks()));
        result.add(BTask.someMethod(build, m.get(3), f.getAllRadio()));
        result.add(BTask.someMethod(build, m.get(4), f.getSelectors()));
        result.add(BTask.feelText(f.getInputTexts()));
        return Combinations.findCombinations(result);
    }

    public static void printInstructions(List<List<List<String>>> l) {
        for (List<List<String>> acc : l) {
            for (List<String> innerAcc : acc) {
                System.out.print(innerAcc);
            }
            System.out.println();
        }
    }

    public static void printInstructionsToFile(List<List<List<String>>> l) throws IOException {
        File file = new File("output.txt");

        FileWriter fstream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream);
        for (List<List<String>> acc : l) {
            for (List<String> innerAcc : acc) {
                out.append(innerAcc.toString());
            }
            out.append("\n");
        }
        out.close();


    }

}
