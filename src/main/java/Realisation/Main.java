package Realisation;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import models.User;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src\\main\\resources\\application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        HikariConfig config = new HikariConfig();
        config.setPassword(properties.getProperty("db.password"));
        config.setUsername(properties.getProperty("db.user"));
        config.setJdbcUrl(properties.getProperty("db.url"));
        config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikariPoolSize")));
        config.setDriverClassName(properties.getProperty("db.driver"));
        DataSource dataSource = new HikariDataSource(config);
        BlackListPasswordsRepImpl blackList=new BlackListPasswordsRepImpl(dataSource);
        SignUpService signUpService = new SignUpService(blackList);
        User user1 = new User("lol@yandex.com", "kek");
        User user2 = new User("lol@yandex.com", "qwerty007");
        signUpService.signUp(user1.getPassword());
        signUpService.signUp(user2.getPassword());
    }
}
