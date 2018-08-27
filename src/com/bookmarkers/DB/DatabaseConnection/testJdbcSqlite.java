package com.bookmarkers.DB.DatabaseConnection;

/**
 * @Author : Yutong Jin
 * @date : 8/27/18
 * @Description :
 */
public class testJdbcSqlite {
    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = DataBaseConnection.getInstance();
        dataBaseConnection.getDBConnection();
    }
}
