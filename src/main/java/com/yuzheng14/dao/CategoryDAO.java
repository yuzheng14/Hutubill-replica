package com.yuzheng14.dao;

import com.yuzheng14.entity.Category;
import com.yuzheng14.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuzheng14
 */
@Repository
public class CategoryDAO {
    public int getTotal(){
        String sql="select count(*) from category";
        int total=0;
        try(Connection connection= DBUtil.getConnection(); PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                total=resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    public void add(Category category){
        String sql="insert into category values(null,?)";
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, category.getName());
            preparedStatement.execute();
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                category.setId(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Category category){
        String sql="update category set name=? where id=?";
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1,category.getName());
            preparedStatement.setInt(2,category.getId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String sql="delete from category where id=?";
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Category category){
        delete(category.getId());
    }

    public Category get(int id){
        String sql="select * from category where id = ?";
        Category category=null;
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            category=new Category();
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setRecordNumber(getRecordNumber(id));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }
    private int getRecordNumber(int id){
        String sql="select count(*) from category c left join record r on c.id=r.category_id where c.id=? and r.id is not null";
        int recordNumber=0;
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                recordNumber=resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recordNumber;
    }

    public List<Category> list(){
        return list(0,Short.MAX_VALUE);
    }

    public List<Category> list(int start,int count){
        String sql="select * from category limit ?,?";
        List<Category> categories=new ArrayList<>();
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,count);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Category category=new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setRecordNumber(getRecordNumber(category.getId()));
                categories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categories;
    }
}
