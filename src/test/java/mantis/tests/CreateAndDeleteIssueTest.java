package mantis.tests;

import mantis.pages.MantisSite;
import mantis.pages.ReportIssuesPage;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class CreateAndDeleteIssueTest extends BaseTest{
    private MantisSite mantisSite;
    private ReportIssuesPage reportIssuesPage;

    @Test
    public void createAndDeleteIssue() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        reportIssuesPage = new ReportIssuesPage(driver);
        mantisSite.login("admin","admin20");
        mantisSite.getMainPage().goToReportIssuesPage();
        reportIssuesPage.createSummary("Summary 2024-02-28");
        reportIssuesPage.createDescription("Text");

        Thread.sleep(3000);

    }
}
