package com.bookmarkers.DB.DAO.Impl;

import com.bookmarkers.DB.DAO.AbstractDAO;
import com.bookmarkers.DB.DAO.Impl.Builder.Builder;
import com.bookmarkers.DB.DAO.Impl.Builder.ConcreteBuilder;
import com.bookmarkers.DB.DAO.ItemDAO;
import com.bookmarkers.DB.DatabaseConnection.DataBaseConnection;
import com.bookmarkers.Data.Item.Item;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/20/18
 * @Description :
 */
public class ItemDAOImpl extends AbstractDAO implements ItemDAO {
    public ItemDAOImpl(Connection conn) {
        super(conn);
    }
    Builder itemBuilder;
    @Override
    public boolean checkOutItem(String userId,String itemId) {
        System.out.println("checking out");
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        Date returnDate= new java.sql.Date(new java.util.Date().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = null;
        try {
            dt = sdf.parse(returnDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, 1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);

        int setNumber = getSetNumber(itemId);

        String sql2 ="";
        String sql3 = "";
        String sql4 = "";
        if(setNumber == 0) {

             sql2 = "UPDATE Item SET Active = 0 where Id = '" + itemId + "'";
             sql3 = "UPDATE Item SET Booker ='" + userId + "' where Id = '" + itemId +"'";
             sql4 = "UPDATE Item SET ReturnDate = '" + reStr + "' where Id = '" + itemId + "'";
        }
        else{
             sql2 = "UPDATE Item SET Active = 0 where setNumber = '" + setNumber + "'";
             sql3 = "UPDATE Item SET Booker ='" + userId + "' where setNumber = '" + setNumber +"'";
             sql4 = "UPDATE Item SET ReturnDate = '" + reStr + "' where setNumber = '" + setNumber +"'";
            //String nowTime = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(returnDate);//将时间格式转换成符合Timestamp要求的格式.
            //Timestamp goodsC_date =Timestamp.valueOf(returnDate);//把时间转换

        }
            try {
                statement = connection.createStatement();
                statement.executeUpdate(sql2);
                statement.executeUpdate(sql3);
                statement.executeUpdate(sql4);
                if (connection.isClosed()) {
                    System.out.println("Closed !");
                }
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return false;
    }

    @Override
    public boolean returnItem(String userId, String itemId) {
        int setNumber = getSetNumber(itemId);
        System.out.println("userid" + userId + " itemI到"+ itemId);
        String sql2 ="";
        String sql3 = "";
        String sql4 = "";
        if(setNumber == 0) {
             sql2 = "UPDATE Item SET Active = 1 where Id = '" + itemId+"'";
             sql3 = "UPDATE Item SET Booker =null  where Id = '" + itemId+"'";
             sql4 = "UPDATE Item SET ReturnDate = null where Id = '" + itemId+"'";
        }
          else{
            sql2 = "UPDATE Item SET Active = 1 where setNumber = '" + setNumber +"'";
            sql3 = "UPDATE Item SET Booker = null where setNumber = '" + setNumber +"'";
            sql4 = "UPDATE Item SET ReturnDate =  null where setNumber = '" + setNumber +"'";
            //String nowTime = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(returnDate);//将时间格式转换成符合Timestamp要求的格式.
            //Timestamp goodsC_date =Timestamp.valueOf(returnDate);//把时间转换
        }
        String sql5 = "UPDATE user SET Active = 1 where setNumber = " + setNumber;

        try {
            java.sql.Connection connection = this.conn;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
            //connection.close();
            if (connection.isClosed()) {
                System.out.println("Closed !");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean active(String itemId) throws SQLException {
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        int active = -1;
        // look up status
        String sql = "SELECT Active FROM Item where Id = '" + itemId+ "'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                String columnName = metaData.getColumnLabel(1);
                 active = resultSet.getInt(columnName);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return active == 1;
    }

    @Override
    public String getBookerId(String itemId) throws SQLException {
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        String bookerId = "";
        // look up status
        String sql = "SELECT Booker FROM Item where Id = '" + itemId+"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {

                String columnName = metaData.getColumnLabel(1);
                bookerId = resultSet.getString(columnName);
                System.out.println("found" + bookerId);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return bookerId;
    }

    public String getType(String itemId){
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String type = "";
        // look up status
        String sql = "SELECT ItemType FROM Item where Id = '" + itemId +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                String columnName = metaData.getColumnLabel(1);
                type = resultSet.getString(columnName);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status
        return type;
    }

    @Override
    public void searchByInfo(String info) {
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String id = "";
        // look up status
        String sql = "SELECT Id FROM Item where KeyWords like '%" + info +"%'";
        System.out.println("start searching");

        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                //System.out.println("start searching");
                String columnName = metaData.getColumnLabel(1);
                id = resultSet.getString(columnName);
                System.out.println(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> getItemListById(String id) {
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        List<Item> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // look up status
        String sql = "SELECT Id ,name ,ItemType ,Type, Author ,ReturnDate,Active, Location,Booker FROM Item where Booker = '" + id +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("找到了元素");
            ResultSetMetaData metaData = resultSet.getMetaData();
            Item item = null;
            while (resultSet.next()) {
                String[] s = new String[9];
                item = new Item();
                System.out.println("数据流有"+metaData.getColumnCount()+"hang");
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnLabel(i);
                    s[i - 1] = resultSet.getString(columnName);
                    if(i == 6)
                    System.out.println("日期是"+s[i -1]);
                }

                itemBuilder = new ConcreteBuilder(s);
                itemBuilder.buildId();
                itemBuilder.buildName();
                itemBuilder.buildActive();
                itemBuilder.buildAuthor();
                itemBuilder.buildBooker();
                itemBuilder.buildDetailedType();
                itemBuilder.buildLoc();
                itemBuilder.buildType();
                itemBuilder.buildReturnDate();
                item = itemBuilder.getItem();
                list.add(item);
                // 依次打印出查询结果中Name的字符串
                //  System.out.println(resultSet.getString("username"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    @Override
    public Item getItemByItemId(String id) {

        java.sql.Connection connection = this.conn;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // look up status
        Item item = null;
        String sql = "SELECT Id ,name ,ItemType, Type, Author, ReturnDate, Active, Location,Booker FROM Item where Id = '" + id +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("找到了元素");
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                String[] s = new String[9];

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnLabel(i);
                    s[i - 1] = resultSet.getString(columnName);
                    System.out.println(s[i -1]);
                }

                itemBuilder = new ConcreteBuilder(s);
                itemBuilder.buildId();
                itemBuilder.buildName();
                itemBuilder.buildActive();
                itemBuilder.buildAuthor();
                itemBuilder.buildBooker();
                itemBuilder.buildDetailedType();
                itemBuilder.buildLoc();
                itemBuilder.buildType();
                itemBuilder.buildReturnDate();

                item = itemBuilder.getItem();
                // 依次打印出查询结果中Name的字符串
                //  System.out.println(resultSet.getString("username"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return item;
    }

    @Override
    public int getBookNumber() throws SQLException {
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        int  number = 0 ;
        // look up status
        String sql = "SELECT  count(*) FROM Item group by ItemType = '" + "Book" +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {

                String columnName = metaData.getColumnLabel(1);
                number = resultSet.getInt(columnName);
                System.out.println("found" + number);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return number;
    }

    @Override
    public int getMagNumber() {
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int  number = 0 ;
        // look up status
        String sql = "SELECT  count(*) FROM Item group by ItemType = '" + "Magazine" +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {

                String columnName = metaData.getColumnLabel(1);
                number = resultSet.getInt(columnName);
                System.out.println("found" + number);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return number;
    }

    @Override
    public int getVideoNumber() {
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int  number = 0 ;
        // look up status
        String sql = "SELECT  count(*) FROM Item group by ItemType = '" + "Video" +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {

                String columnName = metaData.getColumnLabel(1);
                number = resultSet.getInt(columnName);
                System.out.println("found" + number);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return number;
    }

    @Override
    public int getBookedBookNumber() throws SQLException {
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        int  number = 0 ;
        // look up status
        String sql = "SELECT  count(*) FROM Item group by Active = 0 ,ItemType = '" + "Book" +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {

                String columnName = metaData.getColumnLabel(1);
                number = resultSet.getInt(columnName);
                System.out.println("found" + number);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return number;    }

    @Override
    public int getBookedMagNumber() {
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int  number = 0 ;
        // look up status
        String sql = "SELECT  count(*) FROM Item group by Active = 0 ,ItemType = '" + "Magazine" +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {

                String columnName = metaData.getColumnLabel(1);
                number = resultSet.getInt(columnName);
                System.out.println("found" + number);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return number;
    }

    @Override
    public int getBookedVideoNumber() {
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int  number = 0 ;
        // look up status
        String sql = "SELECT  count(*) FROM Item group by Active = 0 ,ItemType = '" + "Video" +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {

                String columnName = metaData.getColumnLabel(1);
                number = resultSet.getInt(columnName);
                System.out.println("found" + number);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return number;
    }

    public int getSetNumber(String itemId){
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int setNumber = 0;
        // look up status
        String sql = "SELECT setNumber FROM Item where Id = '" + itemId +"'";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                String columnName = metaData.getColumnLabel(1);
                setNumber = resultSet.getInt(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setNumber;
    }


}



