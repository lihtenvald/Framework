package mantis.tests;

import mantis.pages.MantisSite;
import mantis.pages.ViewIssuesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssuesTest extends BaseTest{

    private MantisSite mantisSite;

    @Test
    public void checkIssuesNumber(){
         mantisSite = new MantisSite(driver);
         mantisSite.login("admin","admin20");
         mantisSite.getMainPage().goToViewIssuesPage();

         int actualIssuesNumber = mantisSite.getViewIssuesPage().countIssues();

        Assertions.assertEquals(50,actualIssuesNumber);


    }
}
