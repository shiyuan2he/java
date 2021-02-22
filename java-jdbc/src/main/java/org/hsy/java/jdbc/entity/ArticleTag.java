package org.hsy.java.jdbc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author heshiyuan
 * @date 2021/2/22 11:42
 */
@Data
public class ArticleTag {
    private Long id;
    private Long tagId;
    private Long articleId;
    private Date createTime;
    private Date updateTime;
}
