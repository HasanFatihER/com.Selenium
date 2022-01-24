import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        driver.get("https://www.trendyol.com/");
//********** manage.window ile sayfa genişliği değişikliği yapılır************//

        driver.manage().window().maximize();
        Thread.sleep(3000); // exception fırlatır. Ama önemli değil.
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        driver.manage().window().minimize();
        Thread.sleep(3000);
       // driver.manage().window().getPosition();
       // Thread.sleep(3000);
       // driver.manage().window().getSize();
       // Thread.sleep(3000);
        //driver.manage().window().setPosition("100");
        //driver.manage().window().setSize(1000);


    }
}
