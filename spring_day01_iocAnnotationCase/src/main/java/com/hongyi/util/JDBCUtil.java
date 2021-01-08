package com.hongyi.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource dataSource;
    static{
        Properties p = new Properties();
        InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            p.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static JdbcTemplate getJdbcTemplate(){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return  template;
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
