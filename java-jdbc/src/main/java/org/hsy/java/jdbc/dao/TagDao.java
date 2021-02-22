package org.hsy.java.jdbc.dao;

import org.hsy.java.jdbc.entity.Tag;
import org.hsy.java.jdbc.utils.DbHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heshiyuan
 * @date 2021/2/22 11:44
 */
public class TagDao {

    public int testTransaction(Tag tag) {
        Connection connection = DbHelper.getConnection();
        Savepoint savepoint1=null, savepoint2=null, savepoint3 = null;
        try {
            connection.setAutoCommit(false);
            savepoint1 = connection.setSavepoint();
            PreparedStatement ps = connection.prepareStatement(
                    "update biz_tags set description = ?, update_time = now() where id = ?");
            ps.setString(1, "2222");
            ps.setLong(2, tag.getId());
            ps.executeUpdate();
            savepoint2 = connection.setSavepoint();
            PreparedStatement ps2 = connection.prepareStatement(
                    "update biz_article_tags set update_time = now() where id = ?");
            ps2.setLong(1, 4);
            ps2.executeUpdate();
            savepoint3 = connection.setSavepoint();
            int i = 2/0;
            connection.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback(savepoint1);
                connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }
    /**
     * 增加一条记录
     * @param tag
     * @return
     */
    public int insert(Tag tag) {
        Connection connection = DbHelper.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO biz_tags (id, name, description, create_time, update_time) " +
                            "VALUES ("+tag.getId()+", '"+tag.getName()+"', '"+tag.getDescription()+"', now(), now());");
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Long id){
        Connection connection = DbHelper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from biz_tags where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改一条记录
     * @param tag
     * @return
     */
    public int update(Tag tag){
        Connection connection = DbHelper.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "update biz_tags set name = ?, description = ?, update_time = now() where id = ?");
            ps.setString(1, tag.getName());
            ps.setString(2, tag.getDescription());
            ps.setLong(3, tag.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Tag findOne(Long id){
        Connection connection = DbHelper.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from biz_tags where id = ?");
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return convertTag(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Tag convertTag(ResultSet resultSet) throws SQLException {
        Tag tag = new Tag();
        tag.setId(resultSet.getLong("id"));
        tag.setName(resultSet.getString("name"));
        tag.setDescription(resultSet.getString("description"));
        tag.setCreateTime(resultSet.getDate("create_time"));
        tag.setUpdateTime(resultSet.getDate("update_time"));
        return tag;
    }

    public List<Tag> findList(Tag tag){
        Connection connection = DbHelper.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from biz_tags");
            ResultSet resultSet = ps.executeQuery();
            List<Tag> returnList = new ArrayList<>();
            while (resultSet.next()){
                returnList.add(convertTag(resultSet));
            }
            return returnList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
