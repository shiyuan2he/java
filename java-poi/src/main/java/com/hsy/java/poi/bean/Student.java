package com.hsy.java.poi.bean;

import lombok.Data;
import lombok.ToString;

/**
 * java/com.hsy.java.poi.bean
 *
 * @author heshiyuan
 */
@Data
@ToString
public class Student {

    private Integer no;
    private String name;
    private String sex;
    private String remark;
    private Integer score;
}
