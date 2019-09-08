import com.trello.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamDeleteTest extends TestBase {
    @Test
    public void testDeleteTeam(){
        clickSettingsButton();
        clickDeleteThisTeam();
        clickConfirmButton();
        Assert.assertTrue(isUserLoggedIn());


    }

   public void clickConfirmButton() {
        click(By.cssSelector("input[value='Delete Forever']"));
    }

    public void clickDeleteThisTeam() {
        click(By.xpath("//span[contains(text(),'Delete this team?')] "));
    }

    public void clickSettingsButton() {
        click(By.xpath("//div[3]//div[1]//div[2]//a[3] "));
    }
}
