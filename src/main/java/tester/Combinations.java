package tester;

import java.util.*;

/**
 * Class for finding all combinations given any Collection of type T
 */
public class Combinations extends Object {

    /**
     * Find all combinations of the collection size
     * @param elements collection of elements for finding all possible combinations
     * @return A list of lists  all {@link T} elements, or an empty list if nothing matches
     */
    public static <T> List<List<T>> findCombinations(Collection<T> elements) {
        List<List<T>> result = new ArrayList<List<T>>();

        for (int i = 0; i <= elements.size(); i++)
            result.addAll(findCombinations(elements, i));

        return result;
    }
    // To do: find all possible permutations
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
    /**
     * Find all combinations of the restiction size
     * @param elements collection of elements for finding all possible combinations
     * @param n size of bound
     * @return A list of lists  all {@link T} elements, or an empty list if nothing matches
     */
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
