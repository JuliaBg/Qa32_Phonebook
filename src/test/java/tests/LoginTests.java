package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

   @BeforeMethod(alwaysRun = true)
   public void preCondition(){
       if(app.getHelperUser().isLogOutPresent()){
           app.getHelperUser().logout();
           logger.info("Test needs logout");
       }
   }


    @Test
    public void LoginSuccess(){
        //open login form
      //  WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));
      //  loginItem.click();
        //fill email
      //  WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
      //  emailInput.click();
      //  emailInput.clear();
      //  emailInput.sendKeys("ula@gmail.co");
        //fill password
      //  WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
      //  passwordInput.click();
      //  passwordInput.clear();
      //  passwordInput.sendKeys("Ula12345$");
        //click button login
      //  wd.findElement(By.xpath("//*[text()=' Login']")).click();
        //Assert
      //  Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size()>0);

    }

    @Test(dataProvider = "validLoginData",dataProviderClass = MyDataProvider.class)
    public void LoginSuccessNew(String email,String password){

       logger.info("The test starts with email:"+email +"and password:" +password);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,password);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());





    }
    @Test
    public void LoginSuccessModel(){
        User user = new User().withEmail("ula@gmail.co").withPassword("Ula12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());

   }
   @Test(dataProvider = "validModelLogin",dataProviderClass = MyDataProvider.class)
   public void LoginModelDataProvider(User user){
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm(user);
       app.getHelperUser().submitLogin();

       Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());

   }
    @Test(dataProvider = "validModelCSV",dataProviderClass = MyDataProvider.class)
    public void LoginModelDataProviderCSV(User user){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());

    }



   @Test(groups = {"web"})
    public void loginNegativeTestWrongPassword(){
       User user = new User().withEmail("ula@gmail.co").withPassword("Ula");

       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm(user);
       app.getHelperUser().submitLogin();

       Assert.assertFalse(app.getHelperUser().isLoginRegistrationSuccess());
       Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
       Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
   }
}
