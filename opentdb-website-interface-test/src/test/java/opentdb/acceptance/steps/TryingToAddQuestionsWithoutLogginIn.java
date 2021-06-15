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
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(" Add New
		// Questions")));
		WebElement addNewQuestionsButton = driver.findElement(By.xpath(
				"//body[@id='page-top']/nav[@class='navbar navbar-default']/div[@class='container-fluid']/div[@class='collapse navbar-collapse']/ul[@class='nav navbar-nav navbar-right']/li/a[@href='https://opentdb.com/trivia_add_question.php']"));
		// wait.until(ExpectedConditions.visibilityOf(addNewQuestionsButton));
		addNewQuestionsButton.click();
		// Assert.assertEquals(" Add New Questions", addNewQuestionsButton.getText());
	}

	@Then("I display error message with the text {string}.")
	public void displayErrorMessaget(String string) {
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		Assert.assertEquals(string, errorMessage.getText());
		driver.quit();
	}

}
