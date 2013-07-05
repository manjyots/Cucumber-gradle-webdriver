package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class BasicStepDefs {

  private WebDriver driver = new FirefoxDriver();
  /*
 Basic.feature steps
  */

  @Given("^\"([^\"]*)\" use Cucumber Main class to run tests$")
  public void I_use_Cucumber_Main_class_to_run_tests(String testString) throws Throwable {
    System.out.println("Hello cucumber jvm " + testString);
  }

  @When("^I run failing test$")
  public void I_run_failing_test() throws Throwable {
    new Production().doWork();
  }

  @Then("^Gradle should report \"([^\"]*)\"$")

  public void Gradle_should_report(String arg1) throws Throwable {
    throw new PendingException();
  }


 /*
 google.feature steps
  */


  @Given("^the page is open \"([^\"]*)\"$")
  public void the_page_is_open(String page) throws Throwable {
    driver.get(page);
  }

  @When("^I search for \"([^\"]*)\"$")
  public void I_search_for(String search) throws Throwable {
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys(search);
    element.submit();
  }

  @Then("^a browser title should contains \"([^\"]*)\"$")
  public void a_browser_title_should_contains(String text) throws Throwable {
    Thread.sleep(2000);
    assertTrue(driver.getTitle().contains(text));
    closeDriver();

  }

  private void closeDriver() {
    driver.close();
    driver.quit();
  }

}