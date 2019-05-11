package com.hundsun.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Random;
import java.util.UUID;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/8/13 11:12
 */
public class JdbcTest {
    private static final Logger log = LoggerFactory.getLogger(JdbcTest.class);
    private static int i;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JdbcTest jdbcTest = new JdbcTest();
        while (true) {
            try {

                jdbcTest.oracle();
            } catch (Exception e) {
                i++;
                log.info("错误次数：" + i, e);
            }
        }
    }

    private void mysql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://10.20.35.196:18066/test?autoReconnect=true";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        String sql = "insert into testtable (l_node, vc_cust_no) values (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        Random random = new Random();

        stmt.setInt(1, random.nextInt());
        stmt.setString(2, UUID.randomUUID().toString().substring(0, 12));
        stmt.executeUpdate();
    }

    private void oracle() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@192.168.76.173:1521:db2";

        Connection connection = DriverManager.getConnection(url, "jy", "Caifu123");

        String sql = "select * from tc_taccorequest";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {

            System.out.println(rs.getString("c_permission_state"));
        }
    }

}
