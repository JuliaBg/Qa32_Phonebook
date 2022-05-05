package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]>validLoginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"ula@gmail.co","Ula12345$"});
        list.add(new Object[]{"gula@gmail.com","Ggula12345$"});
        list.add(new Object[]{"sumy@gmail.com","Ssumy12345$"});
        list.add(new Object[]{"mir@gmail.com","Mmir12345$"});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validModelLogin(){
        List<Object[]>list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("ula@gmail.co").withPassword("Ula12345$")});
        list.add(new Object[]{new User().withEmail("gula@gmail.com").withPassword("Ggula12345$")});
        list.add(new Object[]{new User().withEmail("sumy@gmail.com").withPassword("Ssumy12345$")});
        list.add(new Object[]{new User().withEmail("mir@gmail.com").withPassword("Mmir12345$")});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]>validModelCSV() throws IOException {
        List<Object[]>list = new ArrayList<>();

        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/loginValid.csv")));

       String line= reader.readLine();


       while(line!=null){
           String[] split = line.split(",");
           list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
           line = reader.readLine();

       }

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validDataContact() throws IOException {
        List<Object[]>list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();

        while (line!=null){
            String []split = line.split(";");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                   // .phone(split[2])
                   // .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});
            line = reader.readLine();
        }

        return list.iterator();
    }

}
