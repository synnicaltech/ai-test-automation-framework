import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver webDriver;

    public Login(){
        webDriver = new ChromeDriver();
    }

    public Login open(){
        webDriver.manage().window().maximize();
        try {
            webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        }finally {
            webDriver.quit();
        }
        return this;
    }
}
