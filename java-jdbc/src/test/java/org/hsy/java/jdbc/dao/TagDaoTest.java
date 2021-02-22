package org.hsy.java.jdbc.dao;

import org.hsy.java.jdbc.entity.Tag;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author heshiyuan
 * @date 2021/2/22 14:44
 */
public class TagDaoTest {
    TagDao tagDao = new TagDao();

    @Test
    public void insert() {
        Tag tag = new Tag();
        tag.setId(100L);
        tag.setName("临时测试insert");
        tag.setDescription("我是描述呀insert");
        Assert.assertEquals(1, tagDao.insert(tag));
    }
    @Test
    public void delete() {
        Assert.assertEquals(1, tagDao.delete(100L));
    }
    @Test
    public void update() {
        Tag tag = new Tag();
        tag.setId(100L);
        tag.setName("临时测试update");
        tag.setDescription("我是描述呀update");
        Assert.assertEquals(1, tagDao.update(tag));
    }
    @Test
    public void findOne() {
        Assert.assertEquals(java.util.Optional.of(100L).get(), tagDao.findOne(100L).getId());
    }
    @Test
    public void findList() {
        System.out.println(tagDao.findList(new Tag()));
    }

    @Test
    public void testTransaction(){
        Tag tag = new Tag();
        tag.setId(5L);
        tagDao.testTransaction(tag);
    }
}