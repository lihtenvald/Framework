package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#summary")
    private WebElement summaryField;
    @FindBy(css = "#description")
    private WebElement descriptionFiled;
    @FindBy(css = "input[class='btn btn-primary btn-white btn-round']")
    private WebElement submitIssueButton;
    @FindBy(css = "input[class='btn btn-primary btn-white btn-round']")
    private WebElement updateInformationButton;
    @FindBy(css = "input[value='Delete']")
    private WebElement DeleteButton;
    @FindBy(css = "input[value='Delete Issues']")
    private WebElement DeleteIssuesButton;


    public ReportIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30, 500));

        PageFactory.initElements(driver, this);
    }

    public void createSummary(String summary) {
        summaryField.click();
        summaryField.sendKeys(summary);
    }

    public void createDescription(String description) {
        descriptionFiled.sendKeys(description);
    }

    public void clickSubmitIssueButton() {
        submitIssueButton.click();
    }

    public void clickUpdateInformationButton() {
        updateInformationButton.click();
    }

    public void clickDelete() {
        DeleteButton.click();
    }

    public void clickDeleteIssues() {
        DeleteIssuesButton.click();
    }
}
