package com.pages.ramada;

import com.tools.AbstractPage;
import com.tools.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends AbstractPage{

    @FindBy(id = "User")
    private WebElementFacade userNameField;
    @FindBy(id = "Password")
    private WebElementFacade userPasswordField;
    @FindBy(css = "a.green.button.widget.compiled")
    private WebElementFacade loginLink;


    public void login() {
        waitFor(userNameField);
        typeInto(userNameField, Constants.USER_NAME);
        typeInto(userPasswordField, Constants.USER_PASS);
        clickOn(loginLink);
    }

}
