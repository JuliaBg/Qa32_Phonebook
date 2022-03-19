package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

   @BeforeMethod
   public void preCondition(){
       if(app.getHelperUser().isLogOutPresent()){
           app.getHelperUser().logout();
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

    @Test
    public void LoginSuccessNew(){
        //open login form
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("ula@gmail.co","Ula12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());





    }
}
