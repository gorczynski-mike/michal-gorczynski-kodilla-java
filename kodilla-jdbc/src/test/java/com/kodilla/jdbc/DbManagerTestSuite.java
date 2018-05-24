package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {

    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM users";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("id") + ", " +
                    rs.getString("first_name") + ", " +
                    rs.getString("last_name"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException{
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQueryActiveUsers = "SELECT u.first_name, u.last_name, COUNT(p.id) AS posts_number FROM users u " +
                "INNER JOIN posts p ON p.user_id = u.id " +
                "GROUP BY u.id HAVING posts_number >= 2";
        Statement statementActiveUsers = dbManager.getConnection().createStatement();
        ResultSet rsActiveUsers = statementActiveUsers.executeQuery(sqlQueryActiveUsers);
        //Then
        int counter = 0;
        while(rsActiveUsers.next()) {
            System.out.println(rsActiveUsers.getString("first_name") + ", " +
                    rsActiveUsers.getString("last_name") + ", " +
                    rsActiveUsers.getInt("posts_number"));
            counter++;
        }
        rsActiveUsers.close();
        statementActiveUsers.close();
        Assert.assertEquals(2, counter);
    }

}
