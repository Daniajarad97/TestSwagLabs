package swagLabs;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSwagLabs {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setup() {

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@Test(priority = 1)
	public void login() {

		String UserName = "standard_user";
		String Password = "secret_sauce";

		WebElement UserNameLogin = driver.findElement(By.id("user-name"));
		WebElement PasswordLogin = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameLogin.sendKeys(UserName);
		PasswordLogin.sendKeys(Password);
		LoginButton.click();
	}

	@Test(priority = 2)
	public void addToCart() {

//		 Loop to add the items to the cart

		List<WebElement> addButtons = (List<WebElement>) driver
				.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
		for (WebElement button : addButtons) {
			button.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		WebElement ShoppingCart = driver.findElement(By.id("shopping_cart_container"));
		ShoppingCart.click();
	}

	@Test(priority = 3)
	public void removeItems() {
		// Loop to remove the items to the cart

		List<WebElement> removeButtons = (List<WebElement>) driver
				.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
		for (WebElement button : removeButtons) {
			button.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		WebElement ContinueShopping = driver.findElement(By.id("continue-shopping"));
		ContinueShopping.click();

	}

}
