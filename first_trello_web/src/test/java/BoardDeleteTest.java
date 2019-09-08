import com.trello.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {
    @Test
    public void testDeleteBoard(){
        clickOnTheBoard();
        clickButtonMore();
        clickCloseBoard();
        clickConfirmClose();
        clickPermanentlyDelete();
        Assert.assertTrue(isUserLoggedIn());
    }


}
