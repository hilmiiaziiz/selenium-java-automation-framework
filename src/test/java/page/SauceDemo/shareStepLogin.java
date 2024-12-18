package page.SauceDemo;

import io.cucumber.java.en.And;
import stepdef.stepDef;

import java.io.IOException;


public class shareStepLogin {
    stepDef callFunction = new stepDef();

    @And ("^User login to the (.*) with (.*) and (.*)")
    public void loginPage(String url, String username, String password) throws IOException, InterruptedException {
        callFunction.openTheWeb(url);
        callFunction.inputCreds(username, "loginPage.field_user_name");
        callFunction.inputCreds(password, "loginPage.field_password");
        callFunction.clickElement("loginPage.login_button");
        callFunction.verifyElement("HomePage.label_home");
        Thread.sleep(2000);
    }
}
