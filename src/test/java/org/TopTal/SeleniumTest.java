package org.TopTal;


import org.apache.bcel.generic.Visitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Vinit Ratan\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("http://website.multiformis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'CLOSE')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sort and Tables')]")).click();


        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Showing')]"))).build().perform();

       String entryDetails= driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();

       int totalCount=Integer.parseInt(entryDetails.split(" ")[5]);


       if(totalCount>25){

           System.out.println("Total data present is "+totalCount+" which is greater than 25");
       }
       else{
           System.out.println("Total data present is "+totalCount+" which is less than 25");
       }

       WebElement countDD= driver.findElement(By.xpath("//select[@name='tablepress-2_length']"));
        Select select = new Select(countDD);
        select.selectByVisibleText("100");


       List<WebElement> listOfAgeElements=driver.findElements(By.xpath("//table[contains(@id,'tablepress')]//td[8]"));

       List<String> ageList=new ArrayList<>();

       for(WebElement ele:listOfAgeElements){
           ageList.add(ele.getText());
       }

        Collections.sort(ageList);

       System.out.println("List of age in sorted format: "+ageList);

       driver.quit();

    }


}
