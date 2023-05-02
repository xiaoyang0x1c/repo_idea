package com.lagou.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author xiaoyang
 * @date 2023/4/26
 * @program lagou_edu_home_parent
 */
@Data
public class Teacher {
    private int id;
    private int CourseId;
    private String teacherName;
    private String position;
    private String description;
    private Date createTime;
    private Date updateTime;
    private int isDel;
}
