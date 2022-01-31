import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/* WebElement : Web sitelerinde kullanılan her argümana denir.
Page Source da (web de inspect yap)tagler ve attribute ler üzerinden ulaşılır.
Hızlı ve doğru ulaşabilmek için Unique degerler kullanılmalıdır.

WebElementlere Locators(Konum bulucu) lar üzerinden ulaşılır.

Attribute bağlı 6 adet - Toplamda 8 adet Locator vardır.
-id
-name
-className
-tagName
-linkText
-partialLinkText  (Uzun linkleri bölerek kullanma)

////////////////
-xpath
-cssSelector

*/



public class SeleniumWebElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       /*
        webElement.click( );   Web Element’e click yapar
        webElement.sendKeys(“Metin” );  Parametre olarak yazilan metni Web Elemente gonderir
        webElement.submit( );   Web element ile islem yaparken Enter tusuna basma gorevi yapar
        webElement.sendKeys(“Metin” + Keys.ENTER );    Istedigimiz metni yollayip, sonra ENTER’a basar.
        webElement.getText( ); Web Element uzerindeki yaziyi getirir
        webElement.getAttribute(“Att.ismi” ); Ismi girilen attribute’un degerini getirir.
        webElement.getTagName( );Web elementin tag ismini getirir


        */

        WebElement searchElement=driver.findElement(By.id("twotabsearchtextbox"));
       // searchElement.sendKeys("flower"+ Keys.ENTER);
       searchElement.sendKeys("drum");
       searchElement.submit();
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement searchElement1=driver.findElement(By.id("twotabsearchtextbox"));
        searchElement1.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchElement1.sendKeys("flower"+Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[3]")).click();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        driver.navigate().back();
        driver.navigate().back();
        WebElement cicek=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[2]"));
        if(cicek.isDisplayed())
        {
            System.out.println("Çiçek göründü -PASSED");
        }
        else System.out.println("Çiçek bulunamadı - FAILED");

    }
}
