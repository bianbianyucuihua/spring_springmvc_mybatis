package com.hongyi.dao.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import com.hongyi.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public List<User> selectAll() {
        JdbcTemplate template = JDBCUtil.getJdbcTemplate();
        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    public User selectById(Integer id) {
        JdbcTemplate template = JDBCUtil.getJdbcTemplate();
        String sql = "select * from user where id=?";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<>(User.class), id);
        return query.get(0);
    }
}
