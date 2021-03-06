package tester;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.yaml.snakeyaml.reader.StreamReader;

import java.io.*;
import java.util.*;


public class MainTest {
    @Test
    public void manual() throws Exception {
        //for chromeDriver need to download last version of driver and set property
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aleksandr\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new HtmlUnitDriver();
        //url should be written in file input.txt
        //in other case it will be created with usual url
        File f = new File("input.txt");
        if (!f.exists()) {
            FileWriter fstream = new FileWriter(f);
            BufferedWriter out = new BufferedWriter(fstream);
            out.append("http://www.yandex.ru");
            out.close();
            fstream.close();
        }


        FileReader fr = new FileReader(f);

        Scanner sc = new Scanner(fr);
        String s = sc.nextLine();
        String d = "http://www.yandex.ru";
        Assert.assertEquals(s,d);
        sc.close();
        fr.close();
        driver.close();

    }
}
