package com.yuzheng14.dao;


import com.yuzheng14.entity.Config;
import com.yuzheng14.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuzheng14
 */
@Repository
public class ConfigDAO {
    public int getTotal(){
        int total=0;
        try(Connection connection= DBUtil.getConnection(); Statement statement=connection.createStatement()){
            String sql="select count(*) from config";

            ResultSet resultset=statement.executeQuery(sql);
            while (resultset.next()){
                total=resultset.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    public void add(Config config){
        String sql="insert into config values(null,?,?)";
        try(Connection connection=DBUtil.getConnection(); PreparedStatement preparedStatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,config.getKey());
            preparedStatement.setString(2,config.getValue());
            preparedStatement.execute();
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                int id=resultSet.getInt(1);
                config.setId(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Config config){
        String sql="update config set key_=?,value=? where id=?";
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1,config.getKey());
            preparedStatement.setString(2,config.getValue());
            preparedStatement.setInt(3,config.getId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public  void delete(int id){
        String sql="delete from config where id=?";
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Config config){
        delete(config.getId());
    }

    public Config get(int id){
        Config config=null;
        String sql="select * from config where id=?";
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                config=new Config();
                config.setId(id);
                config.setKey(resultSet.getString("key_"));
                config.setValue(resultSet.getString("value"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return config;
    }

    public List<Config> list(int start,int count){
        List<Config> configs=new ArrayList<>();
        String sql="select * from config order by id limit ?,?";
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,count);

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Config config=new Config();
                config.setId(resultSet.getInt("id"));
                config.setKey(resultSet.getString("key_"));
                config.setValue(resultSet.getString("value"));
                configs.add(config);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return configs;
    }

    public List<Config> list(){
        return list(0,Short.MAX_VALUE);
    }

    public Config getByKey(String key){
        Config config=null;
        String sql="select * from config where key_=?";
        try(Connection connection=DBUtil.getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1,key);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                config=new Config();
                config.setId(resultSet.getInt("id"));
                config.setKey(resultSet.getString("key_"));
                config.setValue(resultSet.getString("value"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return config;
    }
}
