package tests;


import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogOutPresent()){
            app.getHelperUser().logout();
        }
    }


        @Test
        public void registrationSuccess () {

            int index = (int) System.currentTimeMillis();
            System.out.println(index);

            app.getHelperUser().openLoginRegistrationForm();
            app.getHelperUser().fillLoginRegistrationForm("ylla" + index + "@gmail.com", "Ylla12345$");
            app.getHelperUser().submitRegistration();
            Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());


        }
    @Test
    public void registrationSuccessModel () {

        int index = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User().withEmail("ylla" + index + "@gmail.com").withPassword("Ylla12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());


    }

}
