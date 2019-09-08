import com.trello.tests.TestBase;
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

}
