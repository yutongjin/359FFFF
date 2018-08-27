package com.bookmarkers.DB.DAO;

import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @Author : Yutong Jin
 * @date : 8/20/18
 * @Description :
 */
public class AbstractDAO {
    protected Connection conn;
    protected PreparedStatement pstmt;
    //定义一个构造方法
    public AbstractDAO(Connection conn){
        this.conn = conn;
    }
}
