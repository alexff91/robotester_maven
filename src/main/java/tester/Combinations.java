package tester;

import java.util.*;


public class Combinations extends Object {
    public static <T> List<List<T>> findCombinations(Collection<T> elements) {
        List<List<T>> result = new ArrayList<List<T>>();

        for (int i = 0; i <= elements.size(); i++)
            result.addAll(findCombinations(elements, i));

        return result;
    }

    public static List<String> findPermutations(List<List<String>> in) {
        Set<List<String>> set = new HashSet<List<String>>();

        for (List<String> acc : in) {
            for (String s : acc) {
                List<List<String>> t = in.subList(0, in.indexOf(acc));
                t.addAll(in.subList(in.indexOf(acc) + 1, in.size()));
                for (List<String> acc_inner : in) {
                    for (String s_inner : acc) {

                    }
                }

            }
        }

       return null;
    }

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
