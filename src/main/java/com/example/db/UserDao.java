package com.example.db;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.model.UserVO;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
     return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     @SuppressWarnings({ "unchecked", "rawtypes" })
     public List<UserVO> find(){
         String sql="select * from userbo";//这里也可以添加查询限制条件
         return jdbcTemplate.query(sql, new RowMapper(){

             public Object mapRow(ResultSet rs, int num) throws SQLException {
                 UserVO uservo=new UserVO();
                 uservo.setId(rs.getInt("id"));
                 uservo.setName(rs.getString("name"));
                 uservo.setPwd(rs.getString("pwd"));
                 return uservo;
             }
         });
     }
}
