package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogOutPresent()){
            app.getHelperUser().login(new User().withEmail("ula@gmail.co").withPassword("Ula12345$"));
        }
    }
    @Test
    public void addNewContactSuccess(){
        int index = (int) (System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("John"+index)
                .lastName("Dow")
                .phone("1234567"+index)
                .email("john"+index+"@gmail.com")
                .address("Rehovot")
                .description("The best friend")
                .build();
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());

        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().saveContact();

        Assert.assertTrue(app.getContact().isContactByName(contact.getName()));
        Assert.assertTrue(app.getContact().isContactByPhone(contact.getPhone()));

    }

}
