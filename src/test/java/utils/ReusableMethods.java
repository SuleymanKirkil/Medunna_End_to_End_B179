package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethods {
    //HARD WAIT METHOD
    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertprompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    /*
        Select select2 = new Select(day);
        select2.selectByVisibleText("7");

        //ddmVisibleText(day,"7"); --> can be also used instead of above expression
     */
    public static void ddmVisibleText(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByValue(option);
    }

    //SwitchToWindow1
    public static void switchToWindow(int num) {
        List<String> allWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(allWindowHandles.get(num));
    }

    //SwitchToWindow2
    public static void window(int num) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[num].toString());
    }
    //EXPLICIT WAIT METHODS

    //Visible Wait
    public static void visibleWait(WebElement element, int num) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(num));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int num) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(num));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //Alert Wait
    public static void alertWait(int num) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(num));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //Tüm Sayfa ScreenShot
    public static String wholePagePicture(String name) {
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        String filePath = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePath;
    }

    //WebElement ScreenShot
    public static void webElementPicture(WebElement element) {
        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "TestOutput/screenshot/webElementScreenshot" + date + ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebTable
    public static void printData(int satir, int sutun) {
        WebElement rowColumn = Driver.getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(rowColumn.getText());
    }

    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SendAttributeValue
    public static void sendAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }
}