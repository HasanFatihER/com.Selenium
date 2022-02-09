import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        // Locate edilemeyen webelementlerin tarif yöntemi. Locate etiiğin bir webelemente göre tarif şekli
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver=new ChromeDriver();
        // https://opensea.io/assets sitesine gidelim
        driver.get("https://opensea.io/assets");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // önce loccate edebileceğimiz webelementleri edelim.(senaryo gereği)
        //Collectionı seç
        driver.findElement(By.xpath("//span[.='Collections']")).click();
        Thread.sleep(2000);
       driver.findElement(By.xpath("(//div[@class='CollectionFilter--item-name'])[1]")).click();

    }
}
