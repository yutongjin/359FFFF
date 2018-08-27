package com.bookmarkers.DB.JSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;

/**
 * @Author : Yutong Jin
 * @date : 8/16/18
 * @Description :
 */
public class JSON {
  /*  public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            JSONArray jsonArray = new JSONArray();

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM Item")) {
                ResultSetMetaData metaData =  resultSet.getMetaData();
                while (resultSet.next()) {
                    JSONObject jsonObj = new JSONObject();
                    for(int i = 1; i <= metaData.getColumnCount() ;i++)
                    {
                        String columnName = metaData.getColumnLabel(i);
                        String value =resultSet.getString(columnName);
                        jsonObj.put(columnName, value);
                    }
                    jsonArray.put(jsonObj);
                    // 依次打印出查询结果中Name的字符串
                  //  System.out.println(resultSet.getString("username"));
                }
                System.out.println("转换JSON数据：");
                for (int i = 0; i < jsonArray.length(); i++) {
                    System.out.println(jsonArray.get(i));

                }
                System.out.println(jsonArray.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        String serverName = "localhost";
        String database = "cooper1";
        String url = "jdbc:mysql://localhost:3306/cooper1" ;

        // 数据配置用户和密码
        String user = "root";
        String password = "Jyt6554056!";

        return DriverManager.getConnection(url, user, password);
    }*/
}
