package Realisation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainSpring {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src\\main\\resources\\application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        ApplicationContext app=new ClassPathXmlApplicationContext("context.xml");
        SignUpService signUpService=app.getBean(SignUpService.class);
        signUpService.signUp("kek");
    }
}
