package Realisation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;

public class BlackListPasswordsRepImpl implements BlacListPasswordRep {
    private JdbcTemplate jdbcTemplate;

    public BlackListPasswordsRepImpl(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_FIND_ALL_PASSWORDS = "select password from blacklistpasswords";


    private RowMapper<String> passwordRowsMapper = (rows, rowNumber) -> {
        String password = rows.getString("password");
        return password;
    };



    @Override
    public String isValid(String password) {
        ArrayList<String> passwords = new ArrayList<>();
        passwords.addAll(jdbcTemplate.query(SQL_FIND_ALL_PASSWORDS, passwordRowsMapper));
        if (passwords.contains(password)) {
            return "not allowed password";
        }
        return "user signed up";
    }

}
