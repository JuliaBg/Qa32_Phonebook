package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogOutPresent()) {
            app.getHelperUser().login(new User().withEmail("ula@gmail.co").withPassword("Ula12345$"));
        }
        app.getContact().provideContactData();
    }

    @Test(groups = {"web"})
    public void removeOneContact(){


       Assert.assertEquals(app.getContact().removeOneContact(),1);

    }



    @Test
    public void removeAllContact(){
        app.getContact().removeAllContacts();

        Assert.assertTrue(app.getContact().isAllContactRemoveMessage());

    }
}
