package stepdef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Map;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;

public class helper {

    static Map<?,?> property;
    static String objectFilePath = "src/main/resources/object.yml";

   public static WebDriver driver;

    public static void getProp(String demo) throws IOException, InterruptedException {

        Properties prop = new Properties();
        File file = new File("src/main/resources/configsetting.properties");
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty(demo));
        Thread.sleep(2000);
        driver.manage().window().maximize();
    }

    public static String getCreds(String data) throws IOException, InterruptedException {

        Properties prop = new Properties();
        File file = new File("src/main/resources/configsetting.properties");
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        String result = prop.getProperty(data);
        return result;
    }

    public void inputCreds(String text, String loc) throws IOException, InterruptedException {
        WebElement element = driver.findElement(By.xpath(helper.getElementProperty(loc)));
        element.sendKeys(helper.getCreds(text));

    }

    public static String getElementProperty(String objectstring){
        try {
            Reader rd = new FileReader(objectFilePath);
            Yaml yml = new Yaml();
            property = (Map<?, ?>) yml.load(rd);
            rd.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<?,?> map = (Map<?,?>) property.get(objectstring.split("\\.")[0]);
        return map.get(objectstring.split("\\.")[1]).toString();
    }

}