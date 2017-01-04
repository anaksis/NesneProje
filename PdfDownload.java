import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PdfDownload {

	public void pdfindir(String id) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C://chromedriver.exe"); 
		WebDriver driver= new ChromeDriver();

		driver.get("http://dl.acm.org/citation.cfm?id="+id);//Id ye ait indirme linkine gider
      
		WebElement Link;
		Link=driver.findElement(By.linkText("PDF")); // Adý "PDF" þeklinde yazan butona týklar
		Link.click();
		Thread.sleep(7000);
		driver.quit();
	}

}
