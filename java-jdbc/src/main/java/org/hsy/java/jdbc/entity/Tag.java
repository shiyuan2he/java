package org.hsy.java.jdbc.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author heshiyuan
 * @date 2021/2/22 11:42
 */
@Data
@ToString
public class Tag {
    private Long id;
    private String name;
    private String description;
    private Date createTime;
    private Date updateTime;
}
