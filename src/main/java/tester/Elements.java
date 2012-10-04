package tester;

import java.util.Random;


/**
 * Class for some random values for filling forms on site.
 * Consist of some bad, permissible and prohibited values.
 */
public class Elements {
    public String defaultValue = "random@emailfortest.ru";
    public String defStr = "Ivan";
    public String defInt = "111";
    public String badVals = "/\\/-+=)(*&^%$#@!~";
    public String badMail = badVals + ".com";

    public String randomString(int leng) {
        StringBuilder str = new StringBuilder();
        int r = (new Random()).nextInt(leng);
        for (int i = 0; i < r; i++) {
            str.append(i * (new Random().nextInt(160)));
        }
        return str.toString();
    }

    public String randomString() {
        StringBuilder str = new StringBuilder();
        int r = (new Random()).nextInt(100);
        for (int i = 0; i < r; i++) {
            str.append(i * (new Random().nextInt(160)));
        }
        return str.toString();
    }

    public String randomInt(int max) {
        return ((new Random()).nextInt(max)) + "";
    }

}
