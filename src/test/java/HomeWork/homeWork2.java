package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class homeWork2 {

    @Test
    public void testCase1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        if(actualTitle.equals(expectedTitle)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Web Orders";
        Assert.assertEquals(actualTitle2,expectedTitle2);
        if(actualTitle2.equals(expectedTitle2)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);
        if(actualHeader.equals(expectedHeader)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    @Test
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        WebElement viewAllProductsButton = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        viewAllProductsButton.click();
        Thread.sleep(1000);
        List<WebElement> allOptions = driver.findElements(By.tagName("li"));
        for(WebElement option: allOptions){
            if(option.getAttribute("class").equals("selected") && BrowserUtils.getText(option).equals("View all products")){
                System.out.println("View all Product is selected");
            }
        }
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);
        if(expectedHeader.equals(actualHeader)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        if(driver.getCurrentUrl().contains("Products")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
    @Test
    public void testCase3(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        List<WebElement> allOptions = driver.findElements(By.xpath("//li//a"));
        List<String> actualHref = new ArrayList<>();
        List<String> expectedHref = Arrays.asList("Default.aspx","Products.aspx","Process.aspx");
        for(WebElement option: allOptions){
            actualHref.add(option.getAttribute("href"));
        }
        Assert.assertEquals(actualHref,expectedHref);
        if(actualHref.equals(expectedHref)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
    @Test
    public void testCase4(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        WebElement order = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        order.click();
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select choice = new Select(dropdown);
        choice.selectByVisibleText("ScreenSaver");
        WebElement quantity = driver.findElement(By.xpath("//input[@onchange='productsChanged()']"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipCode.sendKeys("60018");
        WebElement masterCard = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        if(masterCard.isEnabled() && !masterCard.isSelected()){
            masterCard.click();
        }
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.xpath("//a[contains(text(),'Process')]"));
        processButton.click();
        WebElement confirmMessage = driver.findElement(By.tagName("strong"));
        String actualConfirmMessage = BrowserUtils.getText(confirmMessage);
        String expectedConfirmMessage = "New order has been successfully added.";
        Assert.assertEquals(actualConfirmMessage,expectedConfirmMessage);
        WebElement viewAllOrdersButton = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrdersButton.click();
        List<WebElement> allColumn = driver.findElements(By.xpath("//table[@class='SampleTable']//tr//th"));
        List<WebElement> allListOrders = driver.findElements(By.xpath("//table[@class='SampleTable']//tr//td"));
        Map<String,String> expectedMap = new LinkedHashMap<>();
        expectedMap.put("Name","CodeFish IT School");
        expectedMap.put("Product","ScreenSaver");
        expectedMap.put("#","5");
        expectedMap.put("Date","06/03/2023");
        expectedMap.put("Street","2200 E devon");
        expectedMap.put("City","Des Plaines");
        expectedMap.put("State","Illinois");
        expectedMap.put("Zip","60018");
        expectedMap.put("Card","MasterCard");
        expectedMap.put("Card Number","444993876233");
        expectedMap.put("Exp","03/24");
        Map<String,String> actualMap = new LinkedHashMap<>();
        for(int i=1;i< allColumn.size()-1;i++){
           actualMap.put(BrowserUtils.getText(allColumn.get(i)),BrowserUtils.getText(allListOrders.get(i)));
        }
        System.out.println(expectedMap);
        System.out.println(actualMap);
        Assert.assertEquals(actualMap,expectedMap);

        }

    }

