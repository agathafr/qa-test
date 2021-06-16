package opentdb.acceptance.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchingInAQuestionBank {
	WebDriver driver = new ChromeDriver();
	
	@Given("that I navigate to the search page of the question bank")
	public void navigateToTheSearchPageOfTheQuestionBank() {
		driver.navigate().to("https://opentdb.com/");
		WebElement browse = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		browse.click();
		Assert.assertEquals("https://opentdb.com/browse.php", driver.getCurrentUrl());
	}

	@And("type {string} in the search field")
	public void fillsTheSearchField(String string) {
		WebElement queryField = driver.findElement(By.id("query"));
		queryField.sendKeys(new CharSequence[] { string });
		Assert.assertEquals(string, queryField.getAttribute("value"));
	}

	@When("I click the search button")
	public void clickTheSearchButton() {
		WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-sm btn-default']"));
		searchButton.click();
		Assert.assertEquals("https://opentdb.com/browse.php?query=Science%3A+Computers&type=Question#",
				driver.getCurrentUrl());
	}

	@Then("I visualize an error message with the text {string}.")
	public void displaysErrorMessage(String string) {
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		Assert.assertEquals(string, errorMessage.getText());
		driver.quit();
	}

	@And("select as search parameter the category")
	public void selectSearchParameter() {
		WebElement typeField = driver
				.findElement(By.xpath("//select[@class='form-control']/option[@value='Category']"));
		typeField.click();
		Assert.assertEquals("Category", typeField.getAttribute("value"));
	}

	@When("I click the page search button")
	public void clickThePageSearchButton() {
		WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-sm btn-default']"));
		searchButton.click();
		Assert.assertEquals("https://opentdb.com/browse.php?query=Science%3A+Computers&type=Category#",
				driver.getCurrentUrl());
	}

	@Then("I check if the listing of questions is with {int} items")
	public void checkTheListOfItens(int int1) {
		List<WebElement> trTable = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
		int count = trTable.size();
		Assert.assertEquals(int1, count);
	}

	@And("what if the page control appears")
	public void checkTheAppearenceOfPageControl() {
		WebElement pagination = driver
				.findElement(By.xpath("//ul[@class='pagination pagination-lg']/li[@class='active']"));
		Assert.assertEquals("active", pagination.getAttribute("class"));
		// Assert.assertEquals("1", pagination.getText());
		driver.quit();
	}
}
