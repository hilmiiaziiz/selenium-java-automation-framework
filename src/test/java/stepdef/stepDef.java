package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class stepDef extends helper {


    @Given("^User open the (.*) url$")
    public void openTheWeb(String demo) throws InterruptedException, IOException {
        helper.getProp(demo);

    }

    @And("^User input (.*) text on (.*) field$")
    public void inputText(String text, String loc) {
        WebElement element = driver.findElement(By.xpath(helper.getElementProperty(loc)));
        element.sendKeys(text);

    }

    @And("^User click on (.*)$")
    public void clickElement(String loc) {
        WebElement element = driver.findElement(By.xpath(helper.getElementProperty(loc)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

    }

    @And("^User verify (.*) appears$")
    public void verifyElement(String loc) {
        WebElement element = driver.findElement(By.xpath(helper.getElementProperty(loc)));
        element.isDisplayed();
    }

    @And("^User verify text appears contains (.*)$")
    public void containsText(String loc) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),"+loc+")]"));
        element.isDisplayed();
    }

    @And("^User ensure that (.*) not appears$")
       public static void assertLinkNotPresent(String loc) {
    try {
        driver.findElement(By.xpath(helper.getElementProperty(loc)));
    } catch (NoSuchElementException ex) {
    }
}

    @And("^User verify value (.*) is (.*)")
    public void verifyValueElement(String loc, String expected) {
        WebElement element = driver.findElement(By.xpath(helper.getElementProperty(loc)));
        Assert.assertEquals(element.getText(), expected);
    }

    @And("^close browser")
    public void closeBrowser() {
        driver.close();
    }

    @And("^User wait (.*) seconds$")
        public void implicitlyWait(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
    }
}