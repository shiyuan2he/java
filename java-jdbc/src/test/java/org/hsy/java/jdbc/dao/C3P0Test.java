package org.hsy.java.jdbc.dao;
import org.hsy.java.jdbc.entity.Tag;
import org.hsy.java.jdbc.utils.C3p0Helper;
import org.junit.Assert;
import org.junit.Test;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * @author heshiyuan
 * @date 2021/2/22 14:44
 */
public class C3P0Test {
    Logger logger = Logger.getLogger(C3P0Test.class.getName());
    TagDao tagDao = new TagDao(C3p0Helper.getInstance());
    // 2.570, 2.499s, 2.509s
    // 3.991s 4.134s 4.420s
    // 5.9s 5.617s 5.107s
    @Test
    public void batchInsert() {
        IntStream.range(1, 3001).forEach(i -> {
            Tag tag = new Tag();
            tag.setName("insert" + i);
            tag.setDescription("我是描述 insert" + i);
            logger.info("threadId = "+Thread.currentThread().getId()+", 第 "+i+" 次，result = " + tagDao.insert(tag));
        });
    }
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
        logger.info(tagDao.findList(new Tag()).toString());
    }

    @Test
    public void testTransaction(){
        Tag tag = new Tag();
        tag.setId(100L);
        tagDao.testTransaction(tag);
    }
}