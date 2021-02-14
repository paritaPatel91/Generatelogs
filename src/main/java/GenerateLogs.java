import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenerateLogs {

    public static void main(String[] args) {

        Logger log = Logger.getLogger(GenerateLogs.class);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        log.info("Facebook url has been launched");

        String title = driver.getTitle();
        System.out.println("Title value is"+title);

        log.info("Title value is"+title);

        if (title.equals("Facebook - Log In or Sign Up")){
            System.out.println("correct title");
            log.info("correct title and testcase is passed");
        }else{
            System.out.println("Incorrect title");
            log.info("Incorrect title and testcase is failed");
        }
    }
}
