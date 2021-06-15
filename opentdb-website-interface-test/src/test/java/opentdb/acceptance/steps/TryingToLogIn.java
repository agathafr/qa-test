package opentdb.acceptance.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TryingToLogIn {
	WebDriver driver = new ChromeDriver();

	@Given("that I navigate to the login page of the question bank")
	public void navigateToTheLoginPage() {
		driver.navigate().to("https://opentdb.com/login.php");
		Assert.assertEquals("https://opentdb.com/login.php", driver.getCurrentUrl());
	}

	@Given("I type the username")
	public void fillInTheUsernameField() {
		WebElement usernameField = driver.findElement(By.name("username"));
		usernameField.sendKeys(new CharSequence[] { "user001" });
	}

	@Given("I type the password")
	public void fillInThePasswordField() {
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(new CharSequence[] { "123456" });
	}

	@When("I click the sign in button")
	public void clickTheSignInButton() {
		WebElement signInButton = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
		signInButton.click();
	}

	@Then("I display the error message with the text {string}")
	public void displaysErrorMessage(String string) {
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		Assert.assertEquals(string, errorMessage.getText());
		driver.quit();
	}

}
