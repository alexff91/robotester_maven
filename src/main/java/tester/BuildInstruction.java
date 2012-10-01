package tester;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuildInstruction {
    public static List<String> feelAllTexts(WebElement w, List<String> values) {

        List l = new LinkedList();
        for (String t : values) {
            l.add(" ввести в поле <" + w.getTagName() + "> значение" + t);
        }
        return l;
    }

    public static List<String> feelText(List<WebElement> w) {
        Elements e = new Elements();
        List<String> tofeel = new LinkedList<String>();
        for(WebElement we : w){
            List l = new LinkedList();
            l.add(e.randomString(20));
            l.add(e.randomString(200));
            l.add(e.badMail);
            l.add(e.defaultValue);
            tofeel.addAll(feelAllTexts(we, l));
        }
        return tofeel;
    }
    public static List<String> someMethod(Object object,Method methodToCall, List<WebElement> objWithAllMethodsToBeCalled)
    {

        List<String> result = new LinkedList<String>();
        try{

        for(WebElement w : objWithAllMethodsToBeCalled){
            Object[] parameters = new Object[1];
            parameters[0] = w;
        result.add(methodToCall.invoke(object,parameters).toString());
        }

        }
        catch (Exception e) {
        System.out.println(e.getMessage());
        }
        return result;

    }
    public static String pressButton(WebElement w) {
        return " нажать кнопку <" + w.getTagName()+">";
    }
    public static String checkBox(WebElement w) {
        return " выбрать чекбокс <" + w.getTagName()+">";
    }
    public static String selectOr(WebElement w) {
        return " выбрать селектор <" + w.getTagName()+">";
    }
    public static String pressRadio(WebElement w) {
        return "выбрать радио-кнопку <" + w.getTagName()+">";
    }
    public static String pressLink(WebElement w) {
        return " кликнуть по ссылке <" + w.getTagName()+">";
    }
    public static <T> int combinations(List<List<T>> list) {
        int count = 1;
        for (List<T> current : list) {
            count = count * current.size();
        }
        return count;
    }

    public static <T> List<List<T>> combinate(List<List<T>> uncombinedList) {
        List<List<T>> list = new ArrayList<List<T>>();
        int index[] = new int[uncombinedList.size()];
        int combinations = combinations(uncombinedList) - 1;

        for (int i = 0; i < index.length; i++) {
            index[i] = 0;
        }

        List<T> combination = new ArrayList<T>();
        for (int m = 0; m < index.length; m++) {
            combination.add(uncombinedList.get(m).get(index[m]));
        }
        list.add(combination);
        for (int k = 0; k < combinations; k++) {
            combination = new ArrayList<T>();
            boolean found = false;

            for (int l = index.length - 1; l >= 0 && found == false; l--) {
                int currentListSize = uncombinedList.get(l).size();
                if (index[l] < currentListSize - 1) {
                    index[l] = index[l] + 1;
                    found = true;
                } else {

                    index[l] = 0;
                }
            }
            for (int m = 0; m < index.length; m++) {
                combination.add(uncombinedList.get(m).get(index[m]));
            }
            list.add(combination);
        }
        return list;
    }
}
