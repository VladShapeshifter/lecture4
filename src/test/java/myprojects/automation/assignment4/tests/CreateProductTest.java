package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {

    @DataProvider
    private Object[][] getOneLoginPassword() {
        return new Object[][] {
                {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
        };
    }

    @Test(dataProvider = "getOneLoginPassword")
    public void createNewProduct(String login, String password) {
        // TODO implement test for product creation
        actions.login(login, password);

        // actions.login(login, password);
        // ...
    }

    // TODO implement logic to check product visibility on website
}
