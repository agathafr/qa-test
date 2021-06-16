package opentdb.acceptance.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TryingToAddQuestionsWithoutLogginIn {
	WebDriver driver = new ChromeDriver();

	@Given("that I access the question bank page")
	public void acessTheQuestionBankPage() {
		driver.navigate().to("https://opentdb.com/");
		Assert.assertEquals("https://opentdb.com/", driver.getCurrentUrl());
	}

	@When("I click the Add New Questions button")
	public void clickTheAddNewQuestionsButton() {
		WebElement addNewQuestionsButton = driver.findElement(By.xpath(
				"//a[text()=' Add New Questions']"));
		addNewQuestionsButton.click();
	}

	@Then("I display error message with the text {string}.")
	public void displayErrorMessaget(String string) {
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		Assert.assertEquals(string, errorMessage.getText());
		driver.quit();
	}

}
