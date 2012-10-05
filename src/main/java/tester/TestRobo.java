package tester;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.*;
import java.util.Scanner;

public class TestRobo {
    public static void main(String[] args) throws Exception {
        //for chromeDriver need to download last version of driver and set property
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aleksandr\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new HtmlUnitDriver();
        //WebDriver driver = new ChromeDriver();

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
        //String s = "http://www.yandex.ru";


        BTask.printInstructionsToFileStricted(BTask.getCombinationsOfInstructionsStricted(driver, s, 3));
        sc.close();
        fr.close();
        driver.close();


    }
}
