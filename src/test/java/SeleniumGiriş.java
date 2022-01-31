import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumGiriş {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        /* Sistem ayarlarını yapmalıyız.
         src/driver/chromedriver  yüklemiş olduğumuz driver ın yolu
       */
        WebDriver driver=new ChromeDriver();

        /* WebDriver bir interface dir. Interface lerden obje üretemeyiz. Bu sebeple ChromeDriver() kullanırız.

        Bu aşamada çalıştırdığımızda bize boş bir sayfa üretir.

         */
//********** get methods************//
        driver.get("https://coinmarketcap.com/");
        System.out.println(driver.getTitle());   // Sitenin başlığını getirir.
        System.out.println(driver.getCurrentUrl());
       //  System.out.println(driver.getPageSource());  Source kodları verir.
        System.out.println(driver.getWindowHandle()); // Açılan pencere için unique bir değer
        System.out.println(driver.getWindowHandles()); // Tüm açık pencerele için.

        // Site başlığı bitcoin içeriyor mu? En basit yöntemle test edelim.

        String siteBasligi="bitcoin";
        if(driver.getTitle().contains(siteBasligi)){
            System.out.println("Test PASSED-Site başlığında bitcoin içeriyor.");
        } else{
            System.out.println("Test FAİLED-Site başlığında bitcoin içermiyor.");
        }

        // Web sitesi "coin" ifadesini içeriyor mu?

        String actualUrl=driver.getCurrentUrl();
        String urlDeger="coin";
        if(driver.getCurrentUrl().contains(actualUrl)){
            System.out.println("Test PASSED - Url coin kelimesini içeriyor.");
        }
        else System.out.println("Test PASSED - Url coin kelimesini içermiyor.");

//********** manage.window ile sayfa genişliği değişikliği yapılır************//

        driver.manage().window().maximize();
        Thread.sleep(3000); // exception fırlatır. Ama önemli değil.
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
        System.out.println(driver.manage().window().getPosition()); // Browserın koordinatlarını döner.
        System.out.println(driver.manage().window().getSize()); // Browserın ölçülerini döner.
        driver.manage().window().setPosition(new Point(300,500)); // Browser’i istenen koordinata tasir
        driver.manage().window().setSize(new Dimension(1500,1080)); // Browser’i istenen boyutlara ayarlar.


//**************** navigate methodu *******************//

        // driver.get ile aynı işlemleri yapar fakat daha hızlıdır.
        driver.navigate().to("https://www.tradingview.com/x/p0RKk5i7/");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // Açılana kadar maks 15 dk bekler. Eğer açılırsa beklemez.
        driver.navigate().back();  // Bir önceki sayfaya gider.
        driver.navigate().refresh(); // Sayfa yenileme
        driver.navigate().forward();
        driver.navigate().to("https://coinmarketcap.com/");
        driver.manage().window().maximize();




        //driver.close();  Açık sayfayı kapatır.
        driver.quit();  // Açık tüm sayfaları kapatır.
    }
}
