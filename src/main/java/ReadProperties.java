import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {
    public static WebDriver driver;

    public static void main(String[] args) {

        Properties prop = new Properties();
    try {
        FileInputStream ip = new FileInputStream("C:\\Users\\Parita Patel\\Desktop\\frame\\Generatelogs\\src\\main\\java\\config.properties");
        prop.load(ip);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException exception) {
        exception.printStackTrace();
    }
        System.out.println("browser");

        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();

        }else if (browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();

        }else if (browserName.equals("EDGE")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\msedgedriver.exe");
            driver = new EdgeDriver();

        }else if (browserName.equals("OPERA")){
            System.setProperty("webdriver.opera.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\operadriver.exe");
            driver = new OperaDriver();
        }else {
            System.out.println("no browser value is given");

            driver.get(prop.getProperty("url"));

            driver.manage().window().maximize();

            driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();

            driver.findElement(By.name("email")).sendKeys("email");

            driver.findElement(By.name("password")).sendKeys("password ");

            driver.findElement(By.xpath("@FindBy(xpath = \"//div[text()='Login']\")")).click();

        }
}
}
