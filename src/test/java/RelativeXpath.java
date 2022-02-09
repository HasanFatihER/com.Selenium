import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        // Locate edilemeyen webelementlerin tarif yöntemi. Locate etiiğin bir webelemente göre tarif şekli
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver=new ChromeDriver();
        // https://www.diemol.com/selenium-4-demo/relative-locators-demo.html sitesine gidelim
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // önce loccate edebileceğimiz webelementleri edelim.(senaryo gereği)
        WebElement toronto=driver.findElement(By.id("pid2_thumb"));
        WebElement london=driver.findElement(By.id("pid5_thumb"));
        WebElement warsaw=driver.findElement(By.id("pid1_thumb"));
        WebElement maurellio=driver.findElement(By.id("pid10_thumb"));
        //Bostonı bulalım
        WebElement boston=driver.findElement(RelativeLocator.with(By.tagName("img")).above(maurellio).toRightOf(london));

        String ecpectedIdName="pid6_thumb";

        if(boston.getAttribute("id").equals(ecpectedIdName)){
            System.out.println("Boston Test PASSED");
        } else  System.out.println("Boston Test FAILED");

        boston.click();
        Thread.sleep(3000);

       WebElement amsterdam=driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(maurellio).below(london));
        String ecpectedIdNameA="pid9_thumb";
        if(amsterdam.getAttribute("id").equals(ecpectedIdNameA)){
            System.out.println("Amsterdam Test PASSED");
        } else  System.out.println("Amsterdam Test FAILED");
        driver.close();
    }
}
