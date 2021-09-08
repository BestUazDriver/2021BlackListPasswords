package Realisation;

import javax.sql.DataSource;

public class SignUpService {
    BlackListPasswordsRepImpl blackList;

    public SignUpService(BlackListPasswordsRepImpl blackList) {
        this.blackList = blackList;
    }

    void signUp(String password){
        System.out.println(blackList.isValid(password));
    }
}
