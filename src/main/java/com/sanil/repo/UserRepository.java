package com.sanil.repo;

import com.sanil.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String save(User user) {

        int rowAffected = jdbcTemplate.update("insert into user values(?, ?, ?, ?);", user.getId(),
                user.getName(), user.getPhoneNumber(), user.getEmail());
        return "Saved (row " + rowAffected + " affected";

    }

    public List<User> findById(int id) {

/*        List<User> users = jdbcTemplate.query("select * from user where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
        return users;*/
                List<User> users = jdbcTemplate.query("select * from user where id=?",
                new Object[]{id}, new UserRowMapper());
        return users;
    }

    public List<User> findAll() {
        List<User> users = jdbcTemplate.query("select * from user",
                new UserRowMapper());
        return users;
    }

    public User update(User user) {

        //needs to be implemented as save method. use jdbc update method to update.
        return null;
    }

    public void delete(Integer id) {
        jdbcTemplate.update("delete from user where id=?", id);
    }

    class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("email"));
            return user;
        }
    }
}
