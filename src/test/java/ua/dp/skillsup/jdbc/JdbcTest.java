package ua.dp.skillsup.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JdbcTest {

    private Connection conn;

    @Before
    public void setUp() throws Exception {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:mem:", "sa", "");
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void testUser() throws Exception {
        Statement statement = conn.createStatement();
        statement.execute("DROP TABLE IF EXISTS USER;" +
                "CREATE TABLE USER\n" +
                "(\n" +
                "    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "    USERNAME VARCHAR(64) NOT NULL UNIQUE,\n" +
                "    PASSWORD VARCHAR(60) NOT NULL,\n" +
                "    EMAIL VARCHAR(64) NOT NULL,\n" +
                ");");
        statement.close();


        statement = conn.createStatement();
        statement.execute("INSERT INTO user(USERNAME, PASSWORD, EMAIL) VALUES\n" +
                "  ('admin','$2a$08$DobXCJtm7dQwfNz3J0ZILevNNXVslyrY2j0J2dKOBG56uPpBooVoy',\n" +
                "   'helen.moore@gmail.com');");
        statement.close();

        statement = conn.createStatement();
        statement.execute("DROP TABLE IF EXISTS POST;"+"CREATE TABLE POST\n"+
                "(\n"+
                "AUTHOR_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n"+
                "TITLE VARCHAR(65) NOT NULL UNIQUE,\n"+
                "CONTENT VARCHAR (90) NOT NULL,\n);");
        statement.close();

        statement = conn.createStatement();
        statement.execute("INSERT INTO post (AUTHOR_ID,TITLE,CONTENT) VALUE\n"+"('1234','Hello world','Hello')");
        statement.close();



        ResultSet resultSet = conn.prepareStatement("select * from user").executeQuery();
        ResultSetMetaData rsmt = resultSet.getMetaData();
        int numOfCols = rsmt.getColumnCount();
        for(int i = 1; i <= numOfCols; i++)
        {
            System.out.print(rsmt.getColumnName(i)+" ");
        }
        System.out.println();
        while (resultSet.next()) {
            for (int i=1;i<=numOfCols; i++) {
                System.out.print(resultSet.getObject(i)+"|");
            }
        }

        ResultSet resultSet1 = conn.prepareStatement("select * from post").executeQuery();

        ResultSetMetaData rsmr = resultSet.getMetaData();
        int numfCols = rsmr.getColumnCount();
        for(int i = 1; i <= numfCols; i++)
        {
            System.out.print(rsmr.getColumnName(i)+" ");
        }
        System.out.println();

        while (resultSet1.next()) {
            for (int i=1;i<=numOfCols; i++) {
                System.out.print(resultSet.getObject(i)+"|");
            }
        }

    }
}
