package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;

    @FindBy(xpath = "//table[@id='buglist']//tr[1]//i[@class='fa fa-pencil bigger-130 padding-2 grey']")
    private WebElement editIssueButton;
    @FindBy(xpath = "//table[@id='buglist']//tr[1]//td[@class='column-summary']")
    private WebElement summaryIssue;

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30, 500));

        PageFactory.initElements(driver, this);
    }

    public int countIssues() {
        return issues.size();
    }

    public void editIssue() {
        editIssueButton.click();
    }

    public String getNewSummaryIssue() {
        return summaryIssue.getText();
    }
}
