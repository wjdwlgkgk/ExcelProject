package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectDB {
    String connectionUrl = "jdbc:sqlserver://localhost:49747;" + "databaseName = jiha;";
    Connection con =null;
    Statement stmt = null;
    ResultSet rs = null;
    String a[] = new String[100];

    public String[] getA() {
        return a;
    }

    public void init(){

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl, "test","1234");
            stmt = con.createStatement();

            String sql;
            sql ="select * from aaa";

            rs = stmt.executeQuery(sql);
            int num = 0;
            while(rs.next()){
                a[num++] = rs.getString("name");
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){ e.printStackTrace(); }

    }


}
