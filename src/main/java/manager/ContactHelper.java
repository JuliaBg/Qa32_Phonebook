package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
     click(By.cssSelector("[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void saveContact() {
        click(By.cssSelector("b"));
       // click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public boolean isContactByName(String name) {
        List<WebElement>list = wd.findElements(By.cssSelector("h2"));
        for(WebElement el: list){
            if(el.getText().equals(name))
                return true;
        }
        return false;

    }

    public boolean isContactByPhone(String phone) {
       List<WebElement>list= wd.findElements(By.cssSelector("h3"));
       for(WebElement el:list)
       {
           if(el.getText().equals(phone))
               return true;
       }
       return false;
    }

    public int removeOneContact() {
        int countBefore = countOfContacts();
        if(!isCountListEmpty()) {

            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(500);
        }
        int countAfter = countOfContacts();

        return countBefore - countAfter;
    }

    private boolean isCountListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() !=0) {


            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(500);
        }


    }

    public void provideContactData() {
        Contact contact = Contact.builder()
                .name("John")
                .lastName("Dow")
                .phone("1234567")
                .email("john@gmail.com")
                .address("Rehovot")
                .description("The best friend")
                .build();
        openContactForm();
        fillContactForm(contact);
        saveContact();

    }

    public boolean isAllContactRemoveMessage() {
        wd.findElement(By.cssSelector(".contact-page_message__2qafk"));
        String message = wd.findElement(By.cssSelector(".contact-page_message__2qafk h1")).getText();
        return message.equals("No Contacts here!");
    }
}
