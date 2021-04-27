package com.yuzheng14.dao;

import static com.yuzheng14.util.DBUtil.getConnection;
import static com.yuzheng14.util.DateUtil.util2sql;
import static com.yuzheng14.util.DateUtil.today;
import com.yuzheng14.entity.Record;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yuzheng14
 */
@Repository
public class RecordDAO {
    public int getTotal(){
        String sql="select count(*) from record";
        int total=0;
        try(Connection connection=getConnection(); PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                total=resultSet.getInt(1);
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return total;
    }

    public void add(Record record){
        String sql="insert into record values(null,?,?,?,?)";
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1,record.getSpend());
            preparedStatement.setInt(2,record.getCategoryId());
            preparedStatement.setString(3,record.getComment());
            preparedStatement.setDate(4,util2sql(record.getDate()));
            preparedStatement.execute();
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                record.setId(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Record record){
        String sql="update record set spend=?,category_id=?,comment=?,date=? where id=?";
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,record.getId());
            preparedStatement.setInt(2,record.getCategoryId());
            preparedStatement.setString(3,record.getComment());
            preparedStatement.setDate(4,util2sql(record.getDate()));
            preparedStatement.setInt(5,record.getId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String sql="delete from record where id=?";
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Record record){
        delete(record.getId());
    }

    public Record get(int id){
        String sql="select * from record where id = ?";
        Record record=null;
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next()){
                record=new Record();
                record.setId(id);
                record.setSpend(resultSet.getInt("spend"));
                record.setCategoryId(resultSet.getInt("category_id"));
                record.setComment(resultSet.getString("comment"));
                record.setDate(resultSet.getDate("date"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return record;
    }
    public List<Record> list(){
        return list(0,Short.MAX_VALUE);
    }
    public List<Record> list(int start,int count){
        String sql="select * from record limit ?,?";
        List<Record> records=new ArrayList<>();
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,count);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                Record record=new Record();
                record.setId(resultSet.getInt("id"));
                record.setSpend(resultSet.getInt("spend"));
                record.setCategoryId(resultSet.getInt("category_id"));
                record.setComment(resultSet.getString("comment"));
                record.setDate(resultSet.getDate("date"));
                records.add(record);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return records;
    }
    public List<Record> list(int categoryId){
        String sql="select * from record where category_id=?";
        List<Record> records=new ArrayList<>();
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,categoryId);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                Record record=new Record();
                record.setId(resultSet.getInt("id"));
                record.setSpend(resultSet.getInt("spend"));
                record.setCategoryId(resultSet.getInt("category_id"));
                record.setComment(resultSet.getString("comment"));
                record.setDate(resultSet.getDate("date"));
                records.add(record);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return records;
    }

    public List<Record> listToday(){
        return list(today());
    }
    public List<Record> list(Date date){
        String sql="select * from record where date=?";
        List<Record> records=new ArrayList<>();
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setDate(1,util2sql(date));
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                Record record=new Record();
                record.setId(resultSet.getInt("id"));
                record.setSpend(resultSet.getInt("spend"));
                record.setCategoryId(resultSet.getInt("category_id"));
                record.setComment(resultSet.getString("comment"));
                record.setDate(resultSet.getDate("date"));
                records.add(record);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return records;
    }
    public List<Record> listThisMonth(){
        String sql="select * from record where MONTH(date)=MONTH(NOW())";
        List<Record> records=new ArrayList<>();
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                Record record=new Record();
                record.setId(resultSet.getInt("id"));
                record.setSpend(resultSet.getInt("spend"));
                record.setCategoryId(resultSet.getInt("category_id"));
                record.setComment(resultSet.getString("comment"));
                record.setDate(resultSet.getDate("date"));
                records.add(record);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return records;
    }
    public List<Record> list(Date start,Date end){
        String sql="select * from record where date>=? and date<=?";
        List<Record> records=new ArrayList<>();
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setDate(1,util2sql(start));
            preparedStatement.setDate(2,util2sql(end));
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                Record record=new Record();
                record.setId(resultSet.getInt("id"));
                record.setSpend(resultSet.getInt("spend"));
                record.setCategoryId(resultSet.getInt("category_id"));
                record.setComment(resultSet.getString("comment"));
                record.setDate(resultSet.getDate("date"));
                records.add(record);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return records;
    }
}
