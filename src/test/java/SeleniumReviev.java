import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumReviev {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver=new ChromeDriver();
        // https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        //sayfayı büyültme
        driver.manage().window().maximize();
        Thread.sleep(2000); // bekleme
        //sayfayı yenile
        driver.navigate().refresh();
        //title da satış var mı kontrol et
        String actualTitle=driver.getTitle();
        String expectedStr="satış";

        if(actualTitle.contains(expectedStr)){
            System.out.println("Başlıkta "+expectedStr+" geçiyor");
        }
        else System.out.println("Başlıkta "+expectedStr+" geçmiyor");

        //******* Webelement locat ederkendeğer ' ' tırnak işareti içeriyorsa hata verir.

        // Registryi syfasını aç.
       driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_2']")).click();
       //Baby Registry sayfasına git
        driver.findElement(By.xpath("(//div[@class='gr-registry-types__header'])[2]"));
        Thread.sleep(2000);
        //önceki sayfaya geri dönün
        driver.navigate().back();
        driver.close();



    }
}
