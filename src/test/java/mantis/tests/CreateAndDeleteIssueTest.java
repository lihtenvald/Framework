package mantis.tests;

import mantis.pages.MantisSite;
import mantis.pages.ReportIssuesPage;
import mantis.pages.ViewIssuesPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAndDeleteIssueTest extends BaseTest {
    private MantisSite mantisSite;
    private ReportIssuesPage reportIssuesPage;
    private ViewIssuesPage viewIssuesPage;

    @Test
    public void createAndDeleteIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        reportIssuesPage = new ReportIssuesPage(driver);
        viewIssuesPage = new ViewIssuesPage(driver);
        SoftAssertions softAssert = new SoftAssertions();

        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuesPage();
        reportIssuesPage.createIssueWithRequiredFields("Summary 2024-03-3", "Text");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String newIssue = viewIssuesPage.getNewSummaryIssue();
        softAssert.assertThat(newIssue).isEqualTo("Summary 2024-03-3");
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertThat(currentUrl).isEqualTo("https://academ-it.ru/mantisbt/view_all_bug_page.php");

        viewIssuesPage.editIssue();
        reportIssuesPage.clickUpdateInformationButton();
        reportIssuesPage.clickDeleteButton();
        reportIssuesPage.clickDeleteIssuesButton();

        String lastIssue = viewIssuesPage.getNewSummaryIssue();
        softAssert.assertThat(lastIssue).isNotEqualTo("Summary 2024-02-29");
        softAssert.assertAll();
    }
}
