package tester;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.*;


public class Main {
    @Test
    public void manual() throws Exception {
        //for chromeDriver need to download last version of driver and set property
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aleksandr\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new HtmlUnitDriver();
        String s = "file:///C:/Users/Aleksandr/Documents/testrobot/1.html";
        // BTask.printInstructionsToFile(BTask.getCombinationsOfInstructions(driver, s));

//        for (List<String> acc : res2) {
//            for (String innerAcc : acc) {
//                System.out.print(innerAcc.toString());
//            }
//            System.out.println();
//        }
        BTask.printInstructionsToFileStricted(BTask.getCombinationsOfInstructionsStricted(driver, s,3));


    }
}
