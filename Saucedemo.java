package ravi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Saucedemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("login is successful");

		List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));

		WebElement pro = products.stream().filter(
				p -> p.findElement(By.cssSelector(".inventory_item_name ")).getText().equals("Sauce Labs Backpack"))
				.findFirst().orElse(null);
		Thread.sleep(2000);
		pro.findElement(By.cssSelector(".btn_primary ")).click();
		System.out.println("product is added to the cart");

		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".inventory_item_name")).getText());
		Thread.sleep(2000);

		if (driver.findElement(By.cssSelector(".inventory_item_name")).getText().equals("Sauce Labs Backpack")) {
			System.out.println("product is verified");
			driver.findElement(By.id("checkout")).click();
			System.out.println("clicked on checkout");
		}

		driver.findElement(By.id("first-name")).sendKeys("sonu");
		driver.findElement(By.id("last-name")).sendKeys("mumbaiya");
		driver.findElement(By.id("postal-code")).sendKeys("411684");
		driver.findElement(By.id("continue")).click();
		System.out.println("product is continued");

		if (driver.findElement(By.cssSelector(".summary_subtotal_label")).getText().equals("Item total: $29.99")) {
			driver.findElement(By.id("finish")).click();
			System.out.println(driver.findElement(By.cssSelector(".complete-header")).getText());
		}
	}
}
