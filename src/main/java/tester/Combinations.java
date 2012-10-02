package tester;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;


public class Combinations extends Object {
    public static <T> List<List<T>> findCombinations(Collection<T> elements) {
        List<List<T>> result = new ArrayList<List<T>>();

        for (int i = 0; i <= elements.size(); i++)
            result.addAll(findCombinations(elements, i));

        return result;
    }

     public static List<String> findPer(){return null;}
    public static <T> List<List<T>> findCombinations(Collection<T> elements, int n) {
        List<List<T>> result = new ArrayList<List<T>>();

        if (n == 0) {
            result.add(new ArrayList<T>());

            return result;
        }

        List<List<T>> combinations = findCombinations(elements, n - 1);
        for (List<T> combination : combinations) {
            for (T element : elements) {
                if (combination.contains(element)) {
                    continue;
                }

                List<T> list = new ArrayList<T>();

                list.addAll(combination);

                if (list.contains(element))
                    continue;

                list.add(element);


                if (result.contains(list))
                    continue;

                result.add(list);
            }
        }

        return result;
    }


}
